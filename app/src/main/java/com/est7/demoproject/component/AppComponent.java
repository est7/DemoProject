package com.est7.demoproject.component;

import android.content.Context;

import com.est7.demoproject.module.AppModule;
import com.est7.demoproject.utils.HttpUtil;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/7 2:06.
 * <p>
 * Description : File in com.est7.demoproject.component , Project in DemoProject
 * <p>
 * Content:
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context getContext();
    HttpUtil getHttpUtil();

    //因为这里并不需要和具体的依赖组件发生关联，所以不需要添加注入接口
   //void inject(DemoProjectApplication demoProjectApplication);
}
