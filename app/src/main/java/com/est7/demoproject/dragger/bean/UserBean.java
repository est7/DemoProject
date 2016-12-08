package com.est7.demoproject.dragger.bean;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2016/12/6.
 */

public class UserBean {

    public String getString() {
        return mString;
    }

    private String mString;

    public UserBean() {
        mString = "new User";
        Logger.d("create a new user");
    }



}
