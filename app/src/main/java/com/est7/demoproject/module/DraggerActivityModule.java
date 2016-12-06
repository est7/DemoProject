package com.est7.demoproject.module;

import com.est7.demoproject.bean.LiBean;
import com.est7.demoproject.bean.TaoBean;
import com.est7.demoproject.bean.UserBean;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/12/6.
 */

@Module
public class DraggerActivityModule {
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
        return mTaoname;
    }

    @Provides
    LiBean provideLiBean(TaoBean taoBean) {
        return new LiBean(taoBean);
    }

}
