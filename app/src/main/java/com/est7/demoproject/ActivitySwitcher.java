package com.est7.demoproject;

import android.content.Context;
import android.content.Intent;

import com.est7.demoproject.ListViewPager.ListViewPagerActivity;
import com.est7.demoproject.allstatusview.StatusActivity;
import com.est7.demoproject.expandtext.ExpandTextActivity;
import com.est7.demoproject.generic.GenericActivity;
import com.est7.demoproject.jsbridge.ViewActivity;
import com.est7.demoproject.mvp.MvpLoginActivity;
import com.est7.demoproject.retrofit.RetrofitActivity;
import com.est7.demoproject.rxjava.Rxjava2Activity;

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

    public static void entryGenericActivity(Context context) {
        Intent intent = new Intent(context, GenericActivity.class);
        context.startActivity(intent);

    }

    public static void entryBottomDialogActivity(Context context) {


    }

    public static void entryRxjavaActivity(Context context) {
        Intent intent = new Intent(context, Rxjava2Activity.class);
        context.startActivity(intent);
    }

    public static void entryDiyViewActivity(Context context) {
        Intent intent = new Intent(context, ViewActivity.class);
        context.startActivity(intent);
    }

    public static void entryStatusActivity(Context context) {
        Intent intent = new Intent(context, StatusActivity.class);
        context.startActivity(intent);

    }

    public static void entryExpandTextActivity(Context context) {
        Intent intent = new Intent(context, ExpandTextActivity.class);
        context.startActivity(intent);
    }

    public static void entrydiyListViewPagerActivity(Context context) {
        Intent intent = new Intent(context, ListViewPagerActivity.class);
        context.startActivity(intent);
    }
}
