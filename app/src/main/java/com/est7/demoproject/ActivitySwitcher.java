package com.est7.demoproject;

import android.content.Context;
import android.content.Intent;

import com.est7.demoproject.mvp.MvpLoginActivity;
import com.est7.demoproject.retrofit.RetrofitActivity;

/**
 * Created by Administrator on 2016/12/5.
 */

public class ActivitySwitcher {

    public static void entryDaggerActivty(Context context) {
        Intent intent = new Intent(context, com.est7.demoproject.dragger.DaggerActivity.class);
        context.startActivity(intent);

    }
    public static void entryRetrofitActivty(Context context) {
        Intent intent = new Intent(context, RetrofitActivity.class);
        context.startActivity(intent);

    }

    public static void entryMVPActivty(Context context) {
        Intent intent = new Intent(context, MvpLoginActivity.class);
        context.startActivity(intent);

    }
}
