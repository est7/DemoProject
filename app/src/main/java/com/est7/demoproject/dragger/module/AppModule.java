package com.est7.demoproject.dragger.module;

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
 * Description : File in com.est7.demoproject.dragger.module , Project in DemoProject
 * <p>
 * Content:
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    /*单例是基于Component的，所以不仅 Provides 的地方要加 @Singleton，Component上也需要加。
   如果有另外一个OtherActivity，并且创建了一个新的Component，也注入TaoBean，
  是不构成单例的，因为它们的Component是不同的。
     */
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
