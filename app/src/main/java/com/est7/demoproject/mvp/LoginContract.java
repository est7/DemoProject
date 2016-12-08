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
    }

    interface ILoginModule {

        String getEmail();

        String getPasswd();

        boolean checkUserValidity(UserBean bean);

    }

}
