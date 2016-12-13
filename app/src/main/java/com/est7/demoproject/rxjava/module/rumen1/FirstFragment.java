package com.est7.demoproject.rxjava.module.rumen1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.est7.demoproject.R;
import com.est7.demoproject.rxjava.BaseFragment;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2016/12/13.
 */

public class FirstFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo_first, container, false);
        ButterKnife.bind(this, view);


        demo1();

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


    public void demo1() {
        //创建一个被观察对象
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                //ObservableEmitter
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });

        //创建一个观察者
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Logger.d("subscribe");
            }

            @Override
            public void onNext(Integer value) {
                Logger.d("" + value);
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("error");
            }

            @Override
            public void onComplete() {
                Logger.d("complete");
            }
        };
        //建立连接
        observable.subscribe(observer);
    }


    //发射后拦截
    public void demo2() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
                              @Override
                              public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                                  Logger.d("emit 1");
                                  emitter.onNext(1);
                                  Logger.d("emit 2");
                                  emitter.onNext(2);
                                  Logger.d("emit 3");
                                  emitter.onNext(3);
                                  Logger.d("emit complete");
                                  emitter.onComplete();
                                  Logger.d("emit 4");
                                  //这个后面就不会再发送
                                  emitter.onNext(4);
                              }
                          }

        ).subscribe(new Observer<Integer>() {
            private Disposable mDisposable;
            private int i;

            @Override
            public void onSubscribe(Disposable d) {
                Logger.d("subscribe");
                mDisposable = d;
            }

            @Override
            public void onNext(Integer value) {
                Logger.d("onNext: " + value);
                i++;
                if (i == 2) {
                    Logger.d("dispose");
                    if (!mDisposable.isDisposed()) {
                        mDisposable.dispose();
                        //这样后面就不会再接收，可以用来做acitivty销毁时候关闭事件的监听，详情看basefragment的unsubscribe方法
                        Logger.d("isDisposed : " + mDisposable.isDisposed());
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("error");
            }

            @Override
            public void onComplete() {
                Logger.d("complete");
            }
        });
    }


    //lamda 表达式，需要写泛型，所以不能隐藏参数
    private void demo3() {
        Observable.create((ObservableEmitter<Integer> e) -> demo1()).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                //这里注意，也更改了方法名，但是还是和以前一样，一个参数指的接收ononext
                //两个参数加一个oneorro的出理
                //三个参数加一个oncomplet的出理
                Logger.d("onNext: " + integer);
            }
        });

    //整体来说就是这么写的，很整洁
        Observable.create((ObservableEmitter<Integer> e) -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);

        }).subscribe((integer -> {
            if (integer == 2) {
                Logger.d("receive 2");
            }
        }));

    }
}
