package com.est7.demoproject.dragger.module;

import com.est7.demoproject.dragger.bean.ChaoBean;
import com.est7.demoproject.dragger.scope.FragmentScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/8 1:36.
 * <p>
 * Description : File in com.est7.demoproject.dragger.module , Project in DemoProject
 * <p>
 * Content:这里是为了区分返回类型相同的@Provides方法,我们使用@Named
 */

@Module
public class DraggerFragemntModule {

    @Named("提莫")
    @Provides
    public ChaoBean provideTimoChao() {
        return new ChaoBean("提莫");
    }

    @FragmentScope
    @Named("盖伦")
    @Provides
    public ChaoBean provideGailunChao() {
        return new ChaoBean("盖伦");
    }

}
