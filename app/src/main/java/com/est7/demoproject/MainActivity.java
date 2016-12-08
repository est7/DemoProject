package com.est7.demoproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_1)
    Button mBtn1;
    @BindView(R.id.btn_2)
    Button mBtn2;
    @BindView(R.id.btn_3)
    Button mBtn3;
    @BindView(R.id.btn_4)
    Button mBtn4;
    @BindView(R.id.btn_5)
    Button mBtn5;
    @BindView(R.id.btn_6)
    Button mBtn6;
    @BindView(R.id.btn_7)
    Button mBtn7;
    @BindView(R.id.btn_8)
    Button mBtn8;
    @BindView(R.id.btn_9)
    Button mBtn9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_1)
    public void clickBtn1() {
        ActivitySwitcher.entryDaggerActivty(this);
    }

    @OnClick(R.id.btn_2)
    public void clickBtn2() {
        ActivitySwitcher.entryRetrofitActivty(this);
    }

    @OnClick(R.id.btn_3)
    public void clickBtn3() {
        ActivitySwitcher.entryMVPActivty(this);
    }

    @OnClick(R.id.btn_4)
    public void clickBtn4() {

    }

    @OnClick(R.id.btn_5)
    public void clickBtn5() {

    }

    @OnClick(R.id.btn_6)
    public void clickBtn6() {

    }

}
