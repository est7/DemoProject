package com.est7.demoproject.mvp;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/12/8.
 */

public class LoginPresenterCompl implements LoginContract.ILoginPresenter {
    private LoginContract.ILoginView loginView;
    private UserBean user;
    private LoginContract.ILoginView mILoginView;
    private Handler handler;
    private UserModule mUserModule;


    @Inject
    public LoginPresenterCompl(LoginContract.ILoginView iLoginView) {
        mILoginView = iLoginView;
        mUserModule = new UserModule();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        //这里没有不用再做view的clear动作了，一般情况下是对module中的数据进行处理
        mILoginView.onClearText();
    }

    @Override
    public void doLogin(String email, String passwd) {
        UserBean userBean = new UserBean(email, passwd);
        boolean isLoginIn = mUserModule.checkUserValidity(userBean);

        if (isLoginIn) {
            mILoginView.showLoginSuccessToast(mUserModule.getUserInfo() + "用户名:" + mUserModule.getEmail() + "密码：" + mUserModule.getPasswd());
        } else {
            mILoginView.showLoginFailed();
        }
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        mILoginView.onSetProgressBarVisibility(visiblity);
    }
}
