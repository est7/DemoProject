/*
 * Tencent is pleased to support the open source community by making Tinker available.
 *
 * Copyright (C) 2016 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.est7.demoproject.tinker.reporter;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;

import com.est7.demoproject.tinker.BuildInfo;
import com.est7.demoproject.tinker.crash.SampleUncaughtExceptionHandler;
import com.est7.demoproject.tinker.util.UpgradePatchRetry;
import com.est7.demoproject.tinker.util.Utils;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerLoadResult;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

import java.io.File;
import java.util.Properties;


/**
 * Created by zhangshaowen on 16/4/30.
 * optional, you can just use DefaultPatchListener
 * we can check whatever you want whether we actually send a patch request
 * such as we can check rom space or apk channel
 * <p>
 * PatchListener类是用来过滤Tinker收到的补丁包的修复、升级请求，也就是决定我们是不是真的要唤起:patch进程去尝试补丁合成。我们为你提供了默认实现DefaultPatchListener.java。
 * <p>
 * 若检查成功，我们会调用TinkerPatchService.runPatchService唤起:patch进程，
 * 去尝试完成补丁合成操作。反之，会回调检验失败的接口。事实上，你只需要复写patchCheck函数即可。
 * 若检查失败，会在LoadReporter的onLoadPatchListenerReceiveFail中回调。
 * <p>
 * 为了提高TinkerPatchService的进程优先级，我们将它设置为Foreground。对于sdk>18的版本，使用innerService方式使通知栏不会显示。
 * <p>
 * Warning, 这里占用了id为-1119860829.若你的app存在与它相同的id, 可以使用以下API重新设置
 * <p>
 * TinkerPatchService.setTinkerNotificationId(id);
 * Tinker.with(context).setPatchServiceNotificationId(id);
 */
public class SamplePatchListener extends DefaultPatchListener {
    private static final String TAG = "Tinker.SamplePatchListener";

    protected static final long NEW_PATCH_RESTRICTION_SPACE_SIZE_MIN = 60 * 1024 * 1024;

    private final int maxMemory;

    public SamplePatchListener(Context context) {
        super(context);
        maxMemory = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
        TinkerLog.i(TAG, "application maxMemory:" + maxMemory);
    }

    /**
     * because we use the defaultCheckPatchReceived method
     * the error code define by myself should after {@code ShareConstants.ERROR_RECOVER_INSERVICE
     *
     * @param path
     * @param newPatch
     * @return
     */
    @Override
    public int patchCheck(String path) {
        File patchFile = new File(path);
        TinkerLog.i(TAG, "receive a patch file: %s, file size:%d", path, SharePatchFileUtil.getFileOrDirectorySize(patchFile));
        int returnCode = super.patchCheck(path);

        if (returnCode == ShareConstants.ERROR_PATCH_OK) {
            returnCode = Utils.checkForPatchRecover(NEW_PATCH_RESTRICTION_SPACE_SIZE_MIN, maxMemory);
        }

        if (returnCode == ShareConstants.ERROR_PATCH_OK) {
            String patchMd5 = SharePatchFileUtil.getMD5(patchFile);
            SharedPreferences sp = context.getSharedPreferences(ShareConstants.TINKER_SHARE_PREFERENCE_CONFIG, Context.MODE_MULTI_PROCESS);
            //optional, only disable this patch file with md5
            int fastCrashCount = sp.getInt(patchMd5, 0);
            if (fastCrashCount >= SampleUncaughtExceptionHandler.MAX_CRASH_COUNT) {
                returnCode = Utils.ERROR_PATCH_CRASH_LIMIT;
            } else {
                //for upgrade patch, version must be not the same
                //for repair patch, we won't has the tinker load flag
                Tinker tinker = Tinker.with(context);

                if (tinker.isTinkerLoaded()) {
                    TinkerLoadResult tinkerLoadResult = tinker.getTinkerLoadResultIfPresent();
                    if (tinkerLoadResult != null) {
                        String currentVersion = tinkerLoadResult.currentVersion;
                        if (patchMd5.equals(currentVersion)) {
                            returnCode = Utils.ERROR_PATCH_ALREADY_APPLY;
                        }
                    }
                }
            }
            //check whether retry so many times
            if (returnCode == ShareConstants.ERROR_PATCH_OK) {
                returnCode = UpgradePatchRetry.getInstance(context).onPatchListenerCheck(patchMd5)
                        ? ShareConstants.ERROR_PATCH_OK : Utils.ERROR_PATCH_RETRY_COUNT_LIMIT;
            }
        }
        // Warning, it is just a sample case, you don't need to copy all of these
        // Interception some of the request
        if (returnCode == ShareConstants.ERROR_PATCH_OK) {
            Properties properties = ShareTinkerInternals.fastGetPatchPackageMeta(patchFile);
            if (properties == null) {
                returnCode = Utils.ERROR_PATCH_CONDITION_NOT_SATISFIED;
            } else {
                String platform = properties.getProperty(Utils.PLATFORM);
                TinkerLog.i(TAG, "get platform:" + platform);
                // check patch platform require
                if (platform == null || !platform.equals(BuildInfo.PLATFORM)) {
                    returnCode = Utils.ERROR_PATCH_CONDITION_NOT_SATISFIED;
                }
            }
        }

        SampleTinkerReport.onTryApply(returnCode == ShareConstants.ERROR_PATCH_OK);
        return returnCode;
    }
}
