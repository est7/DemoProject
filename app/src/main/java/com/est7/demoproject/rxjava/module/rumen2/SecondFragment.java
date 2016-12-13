package com.est7.demoproject.rxjava.module.rumen2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.est7.demoproject.R;
import com.est7.demoproject.rxjava.BaseFragment;

import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Scheduler;

/**
 * Created by Administrator on 2016/12/13.
 */

public class SecondFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo_second, container, false);
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


    //    创建线程
    private void demo1() {
        Observable.create((ObservableEmitter<Integer> e) -> {
            //empty method
        }).subscribeOn(Scheduler)
                .observeOn()
                .subscribe((integer -> {
                            //empty methid

                        })
                );


    }
}
