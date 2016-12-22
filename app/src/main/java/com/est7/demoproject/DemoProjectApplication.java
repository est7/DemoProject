package com.est7.demoproject;

import android.app.Application;
import android.content.Context;

import com.est7.demoproject.dragger.component.AppComponent;
import com.est7.demoproject.dragger.component.DaggerAppComponent;
import com.est7.demoproject.dragger.module.AppModule;
import com.est7.demoproject.utils.ToastUtil;

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
    private static Context  mDemoProjectApplication;

    public static Context getInstance() {
        return mDemoProjectApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mDemoProjectApplication = this;
        initDI();
        initToast();
    }
    //吐司初始化
    private void initToast() {
        ToastUtil.init(getApplicationContext());
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
