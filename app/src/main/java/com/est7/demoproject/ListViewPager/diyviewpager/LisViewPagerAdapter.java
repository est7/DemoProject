package com.est7.demoproject.ListViewPager.diyviewpager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.est7.demoproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */

public class LisViewPagerAdapter extends PagerAdapter {

    private List<ListView> mList;
    private int mNum = 8;
    private Context mContext;


    public LisViewPagerAdapter(List<Drawable> drawables, float num, Context context) {

        mContext = context;
        if (num != 0) {
            mNum = (int) num;
        }

        mList = new ArrayList<ListView>();

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
            ListView listView = new ListView(context);

            listView.setAdapter(new ArrayAdapter<Drawable>(context, R.layout.image_view, R.id.image, listViewdrawables) {
                @NonNull
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    final ImageView imageView;

                    if (convertView == null) {
                        imageView = new ImageView(mContext);
                    } else {
                        imageView = (ImageView) convertView;
                    }

                    Drawable item = getItem(position);

                    if (item instanceof Drawable) {
                        imageView.setImageDrawable(item);
                    }
                    return imageView;

                }
            });

            mList.add(listView);
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
}
