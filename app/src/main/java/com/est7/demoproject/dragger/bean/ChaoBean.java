package com.est7.demoproject.dragger.bean;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/8 1:32.
 * <p>
 * Description : File in com.est7.demoproject.retrofit.bean , Project in DemoProject
 * <p>
 * Content:测试@Named ,这个ChaoBean是在draggerFragment域中的
 */

public class ChaoBean {

    public ChaoBean() {

    }

    public ChaoBean(String hero) {
        Logger.d("create 一个使用" + hero + "的chao");
    }
}
