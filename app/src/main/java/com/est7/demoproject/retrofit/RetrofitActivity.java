package com.est7.demoproject.retrofit;
/**
 * Created by tao.
 * <p>
 * Created Time : 2016/12/6 8:44.
 * <p>
 * Description : File in  com.est7.demoproject, Project in DemoProject.
 * <p>
 * Content:
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.est7.demoproject.R;
import com.est7.demoproject.retrofit.bean.BaseBean;
import com.est7.demoproject.retrofit.bean.Weather;
import com.est7.demoproject.retrofit.converter.MyConverter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tao.
 * <p>
 * Created Time : 2016/12/6 8:44.
 * <p>
 * Description : retrofit学习demo
 */
public class RetrofitActivity extends AppCompatActivity {


    @BindView(R.id.get1)
    Button get1;
    @BindView(R.id.get2)
    Button get2;
    @BindView(R.id.post)
    Button post;
    @BindView(R.id.upload)
    Button upload;
    @BindView(R.id.download)
    Button download;
    private String TAG = "TAO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.get1, R.id.get2, R.id.post, R.id.upload, R.id.download})
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.get1:
                get1();
                break;
            case R.id.get2:
                get2();
                break;
            case R.id.post:
                post();
                break;
            case R.id.upload:
                upload();
                break;
            case R.id.download:
                download();
                break;
        }
    }


    /**
     * @author tao
     * @time 2016/12/6 10:57
     * @desc get请求网络获取天气信息, 使用自带的转换器
     */
    private void get1() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://wthrcdn.etouch.cn/")
                .addConverterFactory(new MyConverter())
                .build();

        IUser iUser = retrofit.create(IUser.class);
        Call<String> call = iUser.getWeather1("济宁");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e(TAG, "get1: " + response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t);
            }
        });

    }

    /**
     * @author tao
     * @time 2016/12/6 10:57
     * @desc get请求网络获取天气信息, 使用Gson转换器
     */
    private void get2() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://wthrcdn.etouch.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IUser iUser = retrofit.create(IUser.class);
        Call<BaseBean<Weather>> call = iUser.getWeather2("济宁");
        call.enqueue(new Callback<BaseBean<Weather>>() {
            @Override
            public void onResponse(Call<BaseBean<Weather>> call, Response<BaseBean<Weather>> response) {

                Log.e(TAG, "get2: " + response.body().getData().getCity() + "风向 :" + response.body().getData().getForecast().get(0).getFengxiang());
            }

            @Override
            public void onFailure(Call<BaseBean<Weather>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t);
            }
        });

    }

    /**
     * @author tao
     * @time 2016/12/6 17:11
     * @desc 使用post请求.
     * http://pm.bjpake.com:8081/api/material/item/list?rows=20&page=1&sign=1
     */
    private void post() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pm.bjpake.com:8081/api/material/item/")
                .addConverterFactory(new MyConverter())
                .build();

        IUser iUser = retrofit.create(IUser.class);

        Call<String> call = iUser.getList(createParams());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e(TAG, "post: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

    private Map<String, String> createParams() {

        Map<String, String> params = new HashMap<>();
        params.put("rows", "20");
        params.put("page", "1");
        params.put("sign", "1");

        return params;
    }

    private void download() {
        //
    }

    private void upload() {

    }
}