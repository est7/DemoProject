package com.est7.demoproject.annotation;

/**
 * Created by Administrator on 2017/2/8.
 */

public class UserI {

    public static  int childe=0x1;
    public static  int man=0x2;
    public static  int girl=0x3;


    private int userType;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}