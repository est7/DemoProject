package com.est7.demoproject.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

import com.est7.demoproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Rxjava2Activity extends AppCompatActivity {

    @BindView(R.id.activity_rxjava2)
    LinearLayout mActivityRxjava2;
    @BindView(R.id.btn_dialog)
    Button mBtnDialog;
    @BindView(R.id.btn_dialog1)
    Button mBtnDialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava2);
        ButterKnife.bind(this);
        setDosomething((num -> num + 5));
    }


    private void setDosomething(DoSomething dosomething) {
        int anInt = dosomething.getInt(45);
    }


    interface DoSomething {
        int getInt(int num);
    }
}
