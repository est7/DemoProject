package com.est7.demoproject.module;

import com.est7.demoproject.bean.LiBean;
import com.est7.demoproject.bean.TaoBean;
import com.est7.demoproject.bean.UserBean;

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
    @Provides
    LiBean provideLiBean(TaoBean taoBean) {
        return new LiBean(taoBean);
    }

}
