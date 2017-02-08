package com.est7.demoproject.tinker;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.est7.demoproject.R;
import com.est7.demoproject.tinker.util.DemoApplicationContext;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TinkerActivity extends AppCompatActivity {


    @BindView(R.id.tv_text)
    TextView mTvText;
    @BindView(R.id.btn_load_patch)
    Button mBtnLoadPatch;
    @BindView(R.id.btn_clear_patch)
    Button mBtnClearPatch;
    @BindView(R.id.activity_tinker)
    LinearLayout mActivityTinker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinker);
        ButterKnife.bind(this);

        //patch 包我们要把text文字换成修改成功哈哈哈哈或哈
        mTvText.setText("修改成功lema 3er24r234e23哈哈哈哈或哈");

    }


    @OnClick({R.id.btn_load_patch, R.id.btn_clear_patch})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_load_patch:
                //加载补丁（加载成功以后patch文件会自动删掉）
                TinkerInstaller.onReceiveUpgradePatch(DemoApplicationContext.context, Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");


                break;
            case R.id.btn_clear_patch:
                //清除补丁
                Toast.makeText(DemoApplicationContext.application,"clean patch!",Toast.LENGTH_LONG).show();
                Tinker.with(DemoApplicationContext.context).cleanPatch();
                break;
        }
    }
}
