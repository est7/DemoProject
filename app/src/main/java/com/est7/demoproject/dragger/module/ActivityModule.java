package com.est7.demoproject.dragger.module;

import android.app.Activity;

import com.est7.demoproject.dragger.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/8 1:02.
 * <p>
 * Description : File in com.est7.demoproject.dragger.module , Project in DemoProject
 * <p>
 * Content:
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public Activity provideActivity() {
        return this.activity;
    }
}