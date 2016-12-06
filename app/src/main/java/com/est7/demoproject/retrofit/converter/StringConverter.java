package com.est7.demoproject.retrofit.converter;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by tao.
 * <p>
 * Created Time : 2016/12/6 14:46.
 * <p>
 * Description : File in  com.est7.demoproject.retrofit, Project in DemoProject.
 * <p>
 * Content:
 */
public class StringConverter implements Converter<ResponseBody, String>{

    private final Type type;

    public StringConverter(Type type) {
        this.type =type;
    }

    @Override
    public String convert(ResponseBody value) throws IOException {

        return value.string();
    }
}
