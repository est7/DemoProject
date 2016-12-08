package com.est7.demoproject.mvp;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/**
 * Created by Administrator on 2016/12/8.
 */

//做逻辑处理
public class UserModule implements LoginContract.ILoginModule {

    private String mUserInfo;
    private String mEmail;
    private String mPassword;
    private Handler mHandler;

    public UserModule() {
        mHandler = new Handler(Looper.getMainLooper());
    }


    public String getUserInfo() {
        return mUserInfo;
    }


    @Override
    public String getEmail() {
        return mEmail;
    }

    @Override
    public String getPasswd() {
        return mPassword;
    }

    @Override
    public boolean checkUserValidity(UserBean bean) {
        //用户的账号密码是abc ，123
        //模拟一下异步从网络获取用户信息
        mHandler.postDelayed(() -> {
            if (TextUtils.equals("abc", bean.getEmail()) && TextUtils.equals("123", bean.getPassword())) {
                mUserInfo = "你已经成功登陆~";
                return true;
            } else {
                return false;
            }
        }, 2000);


    }
}
