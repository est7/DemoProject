package com.est7.demoproject.ListViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.est7.demoproject.ListViewPager.diyviewpager.LisViewPagerAdapter;
import com.est7.demoproject.ListViewPager.diyviewpager.ListViewPager;
import com.est7.demoproject.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.vp_list)
    ListViewPager mVpList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_pager);
        ButterKnife.bind(this);


        initView();
    }

    private void initView() {
        List list = new ArrayList<Drawable>();

        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        list.add(this.getResources().getDrawable(R.mipmap.ic_launcher));

        mVpList.setAdapter(new LisViewPagerAdapter(list, 8, this));

    }
}
