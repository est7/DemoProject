package com.est7.demoproject;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/12/5.
 */

public class ActivitySwitcher {

    public static void entryDaggerActivty(Context context) {
        Intent intent = new Intent(context, DaggerActivity.class);
        context.startActivity(intent);

    }
}
