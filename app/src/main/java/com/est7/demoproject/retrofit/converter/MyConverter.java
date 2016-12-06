package com.est7.demoproject.retrofit.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by tao.
 * <p>
 * Created Time : 2016/12/6 14:39.
 * <p>
 * Description : File in  com.est7.demoproject.retrofit, Project in DemoProject.
 * <p>
 * Content:自定义string类型的转换器,方便打印参数
 */

public class MyConverter extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return  new StringConverter(type);
    }
}
