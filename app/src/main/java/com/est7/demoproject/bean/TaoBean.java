package com.est7.demoproject.bean;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2016/12/6.
 */

public class TaoBean {

    public String getString() {
        return mString;
    }

    private String mString;

    public TaoBean(String name) {
        mString = "new Tao" + name;
        Logger.d("create a new Tao");
    }

}
