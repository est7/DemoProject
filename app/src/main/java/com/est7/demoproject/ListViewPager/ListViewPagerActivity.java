package com.est7.demoproject.ListViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.est7.demoproject.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.btn_1)
    Button mBtn1;
    private List mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_pager);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mList = new ArrayList<Drawable>();

        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));
        mList.add(this.getResources().getDrawable(R.mipmap.ic_launcher));

        //mVpList.setAdapter(new LisViewPagerAdapter(this, mList, 7));


    }

    @OnClick(R.id.btn_1)
    public void onClick() {


        ShowerCard showerCard = new ShowerCard(this);
        showerCard.showDialog("", "", "");


    }
}
