package com.est7.demoproject.ListViewPager;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.est7.demoproject.ListViewPager.diyviewpager.LisViewPagerAdapter;
import com.est7.demoproject.ListViewPager.diyviewpager.ListViewPager;
import com.est7.demoproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */

public class ShowerCard {

    private ShowerDialog mShowerDialog;
    private Context mContext;
    private ListViewPager mRcBadgeList;

    public ShowerCard(Context context) {
        mShowerDialog = new ShowerCard.ShowerDialog(context);
        mContext = context;
        init();

    }

    private void requestHttp(String vsId, String showerId, String actionVsId) {


    }

    private void init() {
        mShowerDialog.setCancelable(true);
        mShowerDialog.setCanceledOnTouchOutside(true);
        mShowerDialog.setContentView(R.layout.dialog_shower_card);
        Window window = mShowerDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        window.setAttributes(lp);

        mRcBadgeList = (ListViewPager) mShowerDialog.findViewById(R.id.list_view_pager);


        List list = new ArrayList<Drawable>();
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));
        list.add(mContext.getResources().getDrawable(R.mipmap.rc_item_add_already_user));

        mRcBadgeList.setAdapter(new LisViewPagerAdapter(mContext,list, 4 ));
    }

    public void showDialog(String vsId, String showerId, String actionVsId) {

        requestHttp(vsId, showerId, actionVsId);

        if (!mShowerDialog.isShowing()) {
            mShowerDialog.show();
        }


    }


    public void dismissDialog() {
        if (mShowerDialog.isShowing()) {
            mShowerDialog.dismiss();
        }


    }

    private class ShowerDialog extends Dialog {
        public ShowerDialog(Context context) {
            super(context, R.style.BottomDialog);
        }
    }


}
