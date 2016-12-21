package com.est7.demoproject.utils;

import android.content.Context;
import android.widget.Toast;


public class ToastUtil {

    private static Toast mToast;
    private ToastUtil(Context context){

    }

    public static void init(Context context){
        if(mToast == null){
            mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
    }

    public static void show(final String text){
        mToast.setText(text);
        mToast.show();
    }

}
