package com.est7.demoproject.ListViewPager.diyviewpager;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/1/17.
 */

public class MyRecycleView extends RecyclerView {
    public MyRecycleView(Context context) {
        super(context,null);

    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
    }


    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return false;
    }
}
