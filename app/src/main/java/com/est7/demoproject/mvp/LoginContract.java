package com.est7.demoproject.mvp;

/**
 * Created by Administrator on 2016/12/8.
 */


public interface LoginContract {
    //view的方法是写操作视图的
    interface ILoginView {

        void onClearText();

        void doLogin();

        void onSetProgressBarVisibility(int visibility);

        void showLoginSuccessToast(String userInfo);

        void showLoginFailed();


    }

    interface ILoginPresenter {
        void clear();

        void doLogin(String name, String passwd);

        void setProgressBarVisiblity(int visiblity);

        void loginFailed();

        void loginSuccess();
    }

    interface ILoginModule {

        String getEmail();

        String getPasswd();

        void checkUserValidity(UserBean bean);

    }

}
