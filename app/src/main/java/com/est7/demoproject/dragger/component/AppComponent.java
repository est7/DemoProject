package com.est7.demoproject.dragger.component;

import android.content.Context;

import com.est7.demoproject.dragger.module.AppModule;
import com.est7.demoproject.utils.HttpUtil;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/7 2:06.
 * <p>
 * Description : File in com.est7.demoproject.dragger.component , Project in DemoProject
 * <p>
 * Content:
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context getContext();

    HttpUtil getHttpUtil();

    //因为这里并不需要和具体的依赖组件发生关联，所以不需要添加注入接口
    //但是如果一旦使用 compoment.inject(...) 使某个实体类和Component发生了关系，
    // 那么对应Component的 Module 中必须提供 @Inject修饰的所有对象的 providesXXX 方法，
    // 而且如果有两种构造方法，必须提供两种 providesXXX 方法
    //void inject(DemoProjectApplication demoProjectApplication);
}
