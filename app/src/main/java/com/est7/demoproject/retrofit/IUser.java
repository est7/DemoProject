package com.est7.demoproject.retrofit;

import com.est7.demoproject.retrofit.bean.BaseBean;
import com.est7.demoproject.retrofit.bean.Weather;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by tao.
 * <p>
 * Created Time : 2016/12/6 11:19.
 * <p>
 * Description : File in  com.est7.demoproject.retrofit, Project in DemoProject.
 * <p>
 * Content:用户访问网络的接口.
 */

public interface IUser {

    @GET("weather_mini")
    Call<String> getWeather1(@Query("city") String cityname);

    @GET("weather_mini")
    Call<BaseBean<Weather>> getWeather2(@Query("city") String cityname);

    @POST("list")
    Call<String> getList(@QueryMap Map<String ,String> params);

    @GET("weather_mini")
    Flowable<BaseBean<Weather>> getWeather3(@Query("city") String cityname);


}
