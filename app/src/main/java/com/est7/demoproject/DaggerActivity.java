package com.est7.demoproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.est7.demoproject.bean.UserBean;
import com.est7.demoproject.component.DaggerDraggerActivityComponent;
import com.est7.demoproject.module.DraggerActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaggerActivity extends AppCompatActivity {

    @Inject
    UserBean mUserBean;

    @BindView(R.id.text)
    TextView mText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        ButterKnife.bind(this);

        initDI();

        initData();
    }

    private void initDI() {

        //如果DraggerActivityModule只有一个默认的无参构造方法(也就是默认不写构造方法的话)，
        // 我们是可以不用调用draggerActivityModule方法的，而且此时我们还可以用一个更简单的方式来替代，采用create()方法。
        // DaggerDraggerActivityComponent.create().inject(this);
        DaggerDraggerActivityComponent.builder().draggerActivityModule(new DraggerActivityModule()).build().inject(this);
        //此时mUserbean就被注入了

    }

    private void initData() {
        mText.setText(mUserBean.getString());
    }
}
