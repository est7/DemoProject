package com.est7.demoproject.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/7 2:03.
 * <p>
 * Description : File in com.est7.demoproject.utils , Project in DemoProject
 * <p>
 * Content:
 */

/**
 * 这个单例域最大
 */
public class HttpUtil {

    private Context mContext;

    //这个context是application的context,相同的context可以通过Named来进行标记
    public HttpUtil(Context context) {
        mContext = context;
    }

    public void request(String url) {
        Toast.makeText(mContext, url, Toast.LENGTH_SHORT).show();
    }
}
