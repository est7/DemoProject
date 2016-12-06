package com.est7.demoproject.module;

import android.content.Context;

import com.est7.demoproject.utils.HttpUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/7 2:01.
 * <p>
 * Description : File in com.est7.demoproject.module , Project in DemoProject
 * <p>
 * Content:
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return this.context;
    }


    @Singleton
    @Provides
    public HttpUtil provideHttpUtil(Context context) {
        return new HttpUtil(context);
    }
}
