package com.est7.demoproject.mvp;

/**
 * Created by Administrator on 2016/12/8.
 */

public class UserBean {


    private String mEmail;

    private String mPassword;

    public UserBean(String email, String password) {
        mEmail = email;
        mPassword = password;

    }

    public String getEmail() {
        return mEmail;
    }

    public String getPassword() {
        return mPassword;
    }

}
