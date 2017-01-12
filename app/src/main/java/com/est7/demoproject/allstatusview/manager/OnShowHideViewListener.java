package com.est7.demoproject.allstatusview.manager;

import android.view.View;

/**
 * Created by Administrator on 2017/1/12.
 */

public interface OnShowHideViewListener {

    void onShowView(View view, int id);
    void onHideView(View view, int id);
}