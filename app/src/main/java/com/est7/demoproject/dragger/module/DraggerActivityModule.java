package com.est7.demoproject.dragger.module;

import com.est7.demoproject.dragger.bean.LiBean;
import com.est7.demoproject.dragger.bean.TaoBean;
import com.est7.demoproject.dragger.bean.UserBean;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/12/6.
 */

@Module
public class DraggerActivityModule {

    private String mTaoName;

    public DraggerActivityModule(String taoName) {
        mTaoName = taoName;
    }

    @Provides
    UserBean provideUserBean() {
        return new UserBean();
    }

    @Provides
    TaoBean provideTaoBean(String name) {
        return new TaoBean(name);
    }

    @Provides
    String provideTaoName() {
        //这里一般不会在module的构造方法中写出这个参数的,因为这样子就没有解耦效果了..
        return mTaoName;
    }

    @Singleton
    //component关联的Model中的任何一个被构造的对象有scope，则该整个component要加上这个scope。
    @Provides
    LiBean provideLiBean(TaoBean taoBean) {
        return new LiBean(taoBean);
    }

}
