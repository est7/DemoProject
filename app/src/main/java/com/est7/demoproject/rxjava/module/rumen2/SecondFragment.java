package com.est7.demoproject.rxjava.module.rumen2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.est7.demoproject.R;
import com.est7.demoproject.retrofit.HttpMananger;
import com.est7.demoproject.retrofit.bean.BaseBean;
import com.est7.demoproject.retrofit.bean.ForecastBean;
import com.est7.demoproject.retrofit.bean.Weather;
import com.est7.demoproject.rxjava.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/12/13.
 */

public class SecondFragment extends BaseFragment {


    @BindView(R.id.tv_content)
    TextView mTvContent;

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
        Observable
                .create((ObservableEmitter<String> e) -> {

                        }
                ).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(s -> {

                });

    }


    //简单结合retrofit
    private void demo2() {
        HttpMananger.getWeather("济宁")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(weatherBaseBean -> {
                    mTvContent.setText(weatherBaseBean.getData().getWendu());
                });
    }


    //map-->输出温度值的hashcode，map可以理解为1对1的变换，可以任意把一个类型转变成另外一种类型
    private void demo3() {
        HttpMananger.getWeather("济宁")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(weatherBaseBean -> weatherBaseBean.getData().getWendu().hashCode())
                .subscribe(integer -> {
                });

    }

    //flatMap()-->打印出未来5天的天气预报，flatMap可以理解为1对多的的变换，可以任意把一个类型转变成多个另外一种类型,这里就相当于把一个weatherBean
    //转换成5个forecastBean;
    private void demo4() {
        HttpMananger.getWeather("济宁")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<BaseBean<Weather>, Observable<ForecastBean>>() {
                    @Override
                    public Observable<ForecastBean> apply(BaseBean<Weather> weatherBaseBean) throws Exception {
                            //原来的from方法被拆分为三个方法:fromArray fromIterable fromFuture
                        return Observable.fromIterable(weatherBaseBean.getData().getForecast());
                    }
                })
                .subscribe(forecastBean -> {
                    Log.e("TAG", "demo4: "+forecastBean.getHigh() );
                });

    }

    //线程的切换
    private void demo5() {
        HttpMananger.getWeather("济宁")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//指定接下来的操作在主线程,如果不指定,默认是子线程的
                .flatMap(new Function<BaseBean<Weather>, Observable<ForecastBean>>() {
                    @Override
                    public Observable<ForecastBean> apply(BaseBean<Weather> weatherBaseBean) throws Exception {
                        //这里在主线程运行
                        Log.e("TAG", "FlatMapthreadName"+ Thread.currentThread().getName());
                        return Observable.fromIterable(weatherBaseBean.getData().getForecast());
                    }
                })
                .observeOn(Schedulers.io())//假设这里要去操作数据库，指定接下来的操作在io线程
                .map(forecastBean -> {
                    //切换到了子线程，
                    Log.e("TAG", "MapthreadName"+ Thread.currentThread().getName());
                    return forecastBean.getHigh();
                })
                .observeOn(AndroidSchedulers.mainThread())//数据库操作完毕了要回主线程展示
                .subscribe(s -> {
                    //切回主线程
                    Log.e("TAG", "SubthreadName"+ Thread.currentThread().getName());
                    Log.e("TAG", "demo5: "+s );
                });

    }

    //比较贴近真实情况下的网络嵌套请求问题，获取上海的天气前先获取一下济宁的天气。
    private void demo6() {
        HttpMananger.getWeather("济宁")
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<BaseBean<Weather>,Observable<BaseBean<Weather>>>() {
                    @Override
                    public Observable<BaseBean<Weather>> apply(BaseBean<Weather> weatherBaseBean) throws Exception {

                        Log.e("TAG", "flatMapthreadName"+ Thread.currentThread().getName());
                        Log.e("TAG", "cityName"+ weatherBaseBean.getData().getCity());

                        return  HttpMananger.getWeather("上海");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherBaseBean -> {
                    Log.e("TAG", "subthreadName"+ Thread.currentThread().getName());
                    Log.e("TAG", "cityName:"+weatherBaseBean.getData().getCity());
                });


    }



}
