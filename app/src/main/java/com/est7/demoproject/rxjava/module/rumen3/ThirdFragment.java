package com.est7.demoproject.rxjava.module.rumen3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.est7.demoproject.R;
import com.est7.demoproject.rxjava.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/13.
 */

public class ThirdFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo_third, container, false);
        ButterKnife.bind(this, view);


        return view;

    }

    @Override
    protected int getDialogRes() {
        return 0;
    }

    @Override
    protected int getTitleRes() {
        return 0;
    }
}
