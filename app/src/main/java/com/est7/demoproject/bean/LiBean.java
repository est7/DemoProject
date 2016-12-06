package com.est7.demoproject.bean;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2016/12/6.
 */

public class LiBean {

    public String getString() {
        return mString;
    }

    private String mString;

    public LiBean(TaoBean taoBean) {
        mString = "the new Li" + taoBean.getString() + ":hashCode判断是否是同一个对象" + this.hashCode();
        Logger.d("create the new Li");
    }
}
