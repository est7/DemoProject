package com.est7.demoproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }



    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_10, R.id.btn_11,R.id.btn_12})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                ActivitySwitcher.entryDaggerActivty(this);
                break;
            case R.id.btn_2:
                ActivitySwitcher.entryRetrofitActivty(this);
                break;
            case R.id.btn_3:
                ActivitySwitcher.entryMVPActivty(this);
                break;
            case R.id.btn_4:
                ActivitySwitcher.entryGenericActivity(this);
                break;
            case R.id.btn_5:
                ActivitySwitcher.entryTinkerActivity(this);
                break;
            case R.id.btn_6:
                ActivitySwitcher.entryRxjavaActivity(this);
                break;
            case R.id.btn_7:
                ActivitySwitcher.entryDiyViewActivity(this);
                break;
            case R.id.btn_8:
                ActivitySwitcher.entryStatusActivity(this);
                break;
            case R.id.btn_9:
                ActivitySwitcher.entryExpandTextActivity(this);
                break;
            case R.id.btn_10:
                ActivitySwitcher.entrydiyListViewPagerActivity(this);
                break;
            case R.id.btn_11:
                ActivitySwitcher.entryEditTextActivity(this);
                break;
            case R.id.btn_12:
                ActivitySwitcher.entryAnimationActivity(this);
                break;
        }
    }
}
