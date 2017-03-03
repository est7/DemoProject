package com.est7.demoproject.annotation;

/**
 * Created by Administrator on 2017/2/8.
 */

public class UserE {
    private UserEmun userType;

    public UserEmun getUserType() {
        return userType;
    }

    public void setUserType(UserEmun userType) {
        this.userType = userType;
    }

    enum UserEmun {
        childe,
        man,
        girl
    }
}