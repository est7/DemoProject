package com.est7.demoproject;

import android.app.Application;

import com.est7.demoproject.component.AppComponent;
import com.est7.demoproject.component.DaggerAppComponent;
import com.est7.demoproject.module.AppModule;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/7 2:09.
 * <p>
 * Description : File in com.est7.demoproject , Project in DemoProject
 * <p>
 * Content:
 */

public class DemoProjectApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDI();
    }

    private void initDI() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    /**
     * 这个方法暴露 出来appcomponent之后就可以在全局获取httputill的单例了
     * mAppComponent.getHttpUtil();因为可能不止有httputil一个单例要用,所以只用暴露出来mAppcompinent就可以了
     *
     * @return
     */
    public AppComponent getAppComponent() {
        return this.mAppComponent;
    }
}