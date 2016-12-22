package com.est7.demoproject.retrofit;

import com.est7.demoproject.retrofit.bean.BaseBean;
import com.est7.demoproject.retrofit.bean.Weather;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/12/14.
 */

public class HttpMananger {

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();

    private static IUserWarpper sUserWarpper;


    static {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://wthrcdn.etouch.cn/")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
        sUserWarpper = retrofit.create(IUserWarpper.class);
    }



    public static Observable<BaseBean<Weather>> getWeather(String s) {
        return sUserWarpper.getWeather2(s);
    }

}
