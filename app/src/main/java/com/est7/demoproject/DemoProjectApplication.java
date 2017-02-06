package com.est7.demoproject;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.est7.demoproject.dragger.component.AppComponent;
import com.est7.demoproject.dragger.component.DaggerAppComponent;
import com.est7.demoproject.dragger.module.AppModule;
import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/7 2:09.
 * <p>
 * Description : File in com.est7.demoproject , Project in DemoProject
 * <p>
 * Content:
 */



@DefaultLifeCycle(
        application = ".DemoProjectApplication",             //application name to generate
        flags = ShareConstants.TINKER_ENABLE_ALL)                                //tinkerFlags above
public class DemoProjectApplication extends DefaultApplicationLike {

    private AppComponent mAppComponent;
    private static Context application;

    public DemoProjectApplication(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    public static Context getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = getApplication();

        TinkerInstaller.install(this);
        initDI();
    }

    private void initDI() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .build();
    }

    /**
     * 这个方法暴露 出来appcomponent之后就可以在全局获取httputill的单例了
     * mAppComponent.getHttpUtil();因为可能不止有httputil一个单例要用,所以只用暴露出来mAppcompinent就可以了
     *
     * @return
     */
    public AppComponent getAppComponent() {
        return this.mAppComponent;
    }



    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
    }
    
}
