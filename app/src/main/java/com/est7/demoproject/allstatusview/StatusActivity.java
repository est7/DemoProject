package com.est7.demoproject.allstatusview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.est7.demoproject.R;
import com.est7.demoproject.allstatusview.manager.OnShowHideViewListener;
import com.est7.demoproject.allstatusview.manager.RootFrameLayout;
import com.est7.demoproject.allstatusview.manager.StatusLayoutManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StatusActivity extends AppCompatActivity {


    protected StatusLayoutManager statusLayoutManager;
    @BindView(R.id.fL_container)
    RootFrameLayout mFLContainer;
    @BindView(R.id.btn_1)
    Button mBtn1;
    @BindView(R.id.btn_2)
    Button mBtn2;
    @BindView(R.id.btn_3)
    Button mBtn3;
    @BindView(R.id.btn_4)
    Button mBtn4;
    @BindView(R.id.activity_status)
    LinearLayout mActivityStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        ButterKnife.bind(this);

        statusLayoutManager = StatusLayoutManager.newBuilder(this)
                .setRootView(mFLContainer)
                .contentView(R.layout.activity_status_content)
                .emptyDataView(R.layout.activity_status_emptydata)
                .errorView(R.layout.activity_status_error)
                .loadingView(R.layout.activity_status_loading)
                .netWorkErrorView(R.layout.activity_status_networkerror)
                .onShowHideViewListener(new OnShowHideViewListener() {
                    @Override
                    public void onShowView(View view, int id) {
                    }

                    @Override
                    public void onHideView(View view, int id) {

                    }
                }).build();

        //或者使用mActivityStatus.addVIew(statusLayoutManager.getRootLayout());
        statusLayoutManager.showLoading();
    }


    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                statusLayoutManager.showContent();
                break;
            case R.id.btn_2:
                statusLayoutManager.showEmptyData();
                break;
            case R.id.btn_3:
                //   statusLayoutManager.showError();
                statusLayoutManager.showNetWorkError();
                break;
            case R.id.btn_4:
                statusLayoutManager.showLoading();
                break;
        }
    }

}
