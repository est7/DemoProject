package com.est7.demoproject.jsbridge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.est7.demoproject.R;
import com.est7.demoproject.diyview.RefreshView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewActivity extends AppCompatActivity {


    @BindView(R.id.refresh_view)
    RefreshView mRefreshView;
    @BindView(R.id.btn_click)
    Button mBtnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy_view);
        ButterKnife.bind(this);
        init();
    }


    public void init() {


    }

    @OnClick(R.id.btn_click)
    public void onClick() {
        mRefreshView.setDuration(3000);
        mRefreshView.startRefresh();


    }
}
