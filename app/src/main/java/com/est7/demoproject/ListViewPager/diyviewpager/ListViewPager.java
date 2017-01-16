package com.est7.demoproject.ListViewPager.diyviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */

public class ListViewPager extends FrameLayout {

    private List<? extends View> mList;
    private int mNum = 8;
    private Context mContext;
    private ViewPager mViewPager;
    private ViewPagerIndicator mViewPagerIndicator;
    private PagerAdapter mPagerAdapter;

    public ListViewPager(Context context) {
        this(context, null);
    }

    public ListViewPager(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initViews();
    }

    private void initViews() {


        mViewPager = new ViewPager(mContext);
        ViewPager.LayoutParams lp = new ViewPager.LayoutParams();
        lp.width = ViewPager.LayoutParams.MATCH_PARENT;
        lp.height = ViewPager.LayoutParams.MATCH_PARENT;
        mViewPager.setLayoutParams(lp);
        // addView(mViewPager, viewPgaerLp);

        mViewPagerIndicator = new ViewPagerIndicator(mContext);
        FrameLayout.LayoutParams indicatorlp = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        indicatorlp.gravity = Gravity.BOTTOM | Gravity.CENTER;
        indicatorlp.bottomMargin = 20;
        mViewPagerIndicator.setLayoutParams(indicatorlp);
        //addView(mViewPagerIndicator, indicatorlp);
    }


    public void setAdapter(LisViewPagerAdapter adapter){

        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setIndicator(position,positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        addView(mViewPager);

        mViewPagerIndicator.setItemCount(adapter.getCount());
        addView(mViewPagerIndicator);


    }
    private void setIndicator(int position,float offset){
        mViewPagerIndicator.setPositionAndOffset(position,offset);
    }



}
