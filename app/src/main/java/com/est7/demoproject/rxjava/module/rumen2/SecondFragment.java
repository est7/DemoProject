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

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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

    /*
        用于创建Observable的操作符

        Create — 通过调用观察者的方法从头创建一个
        ObservableDefer — 在观察者订阅之前不创建这个Observable，为每一个观察者创建一个新的Observable
        Empty/Never/Throw — 创建行为受限的特殊ObservableFrom — 将其它的对象或数据结构转换为Observable
        Interval — 创建一个定时发射整数序列的Observable
        Just — 将对象或者对象集合转换为一个会发射这些对象的Observable
        Range — 创建发射指定范围的整数序列的Observable
        Repeat — 创建重复发射特定的数据或数据序列的Observable
        Start — 创建发射一个函数的返回值的Observable
        Timer — 创建在一个指定的延迟之后发射单个数据的Observable
     */
    public void demo1() {
        Observable
                .create((ObservableEmitter<String> e) -> {

                        }
                ).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(s -> {

                });

    }


    //简单结合retrofit
    public void demo2() {
        HttpMananger.getWeather("济宁")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(weatherBaseBean -> {
                    mTvContent.setText(weatherBaseBean.getData().getWendu());
                });
    }


    //map-->输出温度值的hashcode，map可以理解为1对1的变换，可以任意把一个类型转变成另外一种类型
    public void demo3() {
        HttpMananger.getWeather("济宁")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(weatherBaseBean -> weatherBaseBean.getData().getWendu().hashCode())
                .subscribe(integer -> {
                });

    }

    //flatMap()-->打印出未来5天的天气预报，flatMap可以理解为1对多的的变换，可以任意把一个类型转变成多个另外一种类型,这里就相当于把一个weatherBean
    //转换成5个forecastBean;
    public void demo4() {
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
                    Log.e("TAG", "demo4: " + forecastBean.getHigh());
                });

    }

    //线程的切换
    public void demo5() {
        HttpMananger.getWeather("济宁")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//指定接下来的操作在主线程,如果不指定,默认是子线程的
                .flatMap(new Function<BaseBean<Weather>, Observable<ForecastBean>>() {
                    @Override
                    public Observable<ForecastBean> apply(BaseBean<Weather> weatherBaseBean) throws Exception {
                        //这里在主线程运行
                        Log.e("TAG", "FlatMapthreadName" + Thread.currentThread().getName());
                        return Observable.fromIterable(weatherBaseBean.getData().getForecast());
                    }
                })
                .observeOn(Schedulers.io())//假设这里要去操作数据库，指定接下来的操作在io线程
                .map(forecastBean -> {
                    //切换到了子线程，
                    Log.e("TAG", "MapthreadName" + Thread.currentThread().getName());
                    return forecastBean.getHigh();
                })
                .observeOn(AndroidSchedulers.mainThread())//数据库操作完毕了要回主线程展示
                .subscribe(s -> {
                    //切回主线程
                    Log.e("TAG", "SubthreadName" + Thread.currentThread().getName());
                    Log.e("TAG", "demo5: " + s);
                });

    }

    //比较贴近真实情况下的网络嵌套请求问题，获取上海的天气前先获取一下济宁的天气。
    public void demo6() {
        HttpMananger.getWeather("济宁")
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<BaseBean<Weather>, Observable<BaseBean<Weather>>>() {
                    @Override
                    public Observable<BaseBean<Weather>> apply(BaseBean<Weather> weatherBaseBean) throws Exception {

                        Log.e("TAG", "flatMapthreadName" + Thread.currentThread().getName());
                        Log.e("TAG", "cityName" + weatherBaseBean.getData().getCity());

                        return HttpMananger.getWeather("上海");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherBaseBean -> {
                    Log.e("TAG", "subthreadName" + Thread.currentThread().getName());
                    Log.e("TAG", "cityName:" + weatherBaseBean.getData().getCity());
                });

    }

    //发送速度大于处理速度,无法被及时处理的数据堆积在上游,造成内存拥堵,直到OOM;
    // 同样的代码在1.0中会抛出异常MissingBackpressureException,原因是interval操作符本身是不支持背压的,因为他的发送速度不可控制;
    public void demo7() {
        Observable.interval(1, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.newThread())
                //观察者处理每1000ms才处理一个事件
                .subscribe(new io.reactivex.Observer<Long>() {
                    Disposable mDisposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(Long value) {

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.e("TAG", "打印结果" + value);
                        /*
                        if (value == 10) {
                            mDisposable.dispose();
                        }*/

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG", "完成");
                    }
                });
    }


    //使用range操作来发送100W个数据,这时候,内存也会增长,但是增长速度比较慢,原因是range操作符是支持背压的,他背压的策略是缓存,
    //资料上说,observeOn这个操作符内部有一个缓冲区，Android环境下长度是16，它会告诉range最多发送16个事件，充满缓冲区即可;
    public void demo8() {
        Observable.range(1, 1000000)
                .observeOn(Schedulers.newThread())
                //观察者1秒处理一个事件
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer value) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.e("TAG", "打印结果" + value);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    //这里会报错,原因在于interval是不支持背压的,request也不能在这使用.
    public void demo9() {
        Flowable.interval(1, TimeUnit.MILLISECONDS)
                //.onBackpressureBuffer(),使用这个操作符,可以使本来不支持响应式拉取的变成支持;
                .observeOn(Schedulers.newThread())
                //观察者处理每1000ms才处理一个事件
                .subscribe(new Subscriber<Long>() {
                    Subscription mSub;

                    @Override
                    public void onSubscribe(Subscription s) {
                        mSub = s;
                        mSub.request(10);//这里的request是必须调用的且request(0)是非法的,不调用是不会发送事件的,这里是要求请求10个,但是只发送出一个后就报错
                    }

                    @Override
                    public void onNext(Long aLong) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.e("TAG", "打印: " + aLong);
                        // mSub.request(1);这里请求不请求都会报错;
                    }

                    @Override
                    public void onError(Throwable t) {
                        // //错误信息io.reactivex.exceptions.MissingBackpressureException: Can't deliver value 128 due to lack of requests
                        Log.e("TAG", "错误信息" + t);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //使用request响应式拉去,拉取一个处理一个;
    public void demo10() {
        Flowable.range(0, 1000000)
                .observeOn(Schedulers.newThread())
                //观察者处理每1000ms才处理一个事件
                .subscribe(new Subscriber<Integer>() {
                    Subscription mSub;

                    @Override
                    public void onSubscribe(Subscription s) {
                        mSub = s;
                        mSub.request(1);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.e("TAG", "打印结果" + integer);
                        mSub.request(1);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("TAG", "onError: " + t);
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG", "onComplete: 完成");
                    }
                });
    }

   /* 综合上面的例子,我个人理解的背压就是一种控制上游发送速度的手段,基本分为三类,
    1,使用过滤操作符例如:sample()、throttleLast()、 throttleFirst()、throttleWithTimeout(),debounce()等,这类操作符就是丢弃过多的事件;
    2,使用缓存操作符Buffers() , windows()等;
    3,响应式拉取,request(使用onBackpressurebuffer,onBackpressureDrop,可以让一些不支持响应式拉取的操作符变的支持)
    至于Flowable和Observable的区别:我个人觉得就是把request的功能规定只能在flowable中使用,或者说,flowable支持响应式拉取,observable不支持...
    */
}


