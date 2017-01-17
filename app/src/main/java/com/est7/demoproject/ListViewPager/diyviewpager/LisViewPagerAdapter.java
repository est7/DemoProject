package com.est7.demoproject.ListViewPager.diyviewpager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */


public class LisViewPagerAdapter extends PagerAdapter {

    private List<RecyclerView> mList;
    private int mNum = 8;
    private Context mContext;


    public LisViewPagerAdapter(Context context,List<Drawable> drawables, float num ) {

        mContext = context;
        if (num != 0) {
            mNum = (int) num;
        }

        mList = new ArrayList<RecyclerView>();

        //地板数
        double floor = Math.floor(drawables.size() / num);
        int j = (int) floor;
        //天花板数 应当做几个listview填充

        double ceil = Math.ceil(drawables.size() / num);
        int i = (int) ceil;


        List<Drawable> listViewdrawables = null;


        for (int i1 = 0; i1 < i; i1++) {
            if (i1 >= j) {
                listViewdrawables = drawables.subList(i1 * mNum, drawables.size());
            } else {
                listViewdrawables = drawables.subList(i1 * mNum, (i1 + 1) * mNum);
            }
            NoTouchEventRecycleView recyclerView = new NoTouchEventRecycleView(context);
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,RecyclerView.LayoutParams.WRAP_CONTENT);
            recyclerView.setLayoutParams(lp);

            BadgeRecyclerAdapter adapter = new BadgeRecyclerAdapter();
            adapter.setUrlData(listViewdrawables);
            recyclerView.setAdapter(adapter);
            mList.add(recyclerView);
        }
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(mList.get(position % mList.size()));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        View view = mList.get(position % mList.size());
        ViewGroup parent = (ViewGroup) view.getParent();
        //如果当前要显示的view有父布局先将父布局移除（view只能有一个父布局）
        if (parent != null) {
            parent.removeView(view);
        }
        container.addView(view);
        return view;
    }


    class BadgeRecyclerAdapter extends RecyclerView.Adapter<BadgeViewHodler> {

        private List<Drawable> mBadgeDataList;

        @Override
        public BadgeViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
            ImageView imageView = new ImageView(mContext);
            BadgeViewHodler actorBadgeViewHodler = new BadgeViewHodler(imageView);

            return actorBadgeViewHodler;
        }

        @Override
        public void onBindViewHolder(BadgeViewHodler holder, int position) {
            ImageView iv_actor_badge = holder.iv_badge;
            Drawable drawable = mBadgeDataList.get(position);
            iv_actor_badge.setImageDrawable(drawable);
        }

        @Override
        public int getItemCount() {
            return mBadgeDataList.size();
        }

        public void setUrlData(List badgeDataList) {
            mBadgeDataList = badgeDataList;

        }
    }


    class BadgeViewHodler extends RecyclerView.ViewHolder {

        private final ImageView iv_badge;

        public BadgeViewHodler(View itemView) {
            super(itemView);
            iv_badge = (ImageView) itemView;

        }
    }
}
