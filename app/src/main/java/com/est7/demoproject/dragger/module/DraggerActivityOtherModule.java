package com.est7.demoproject.dragger.module;

import com.est7.demoproject.dragger.bean.WangBean;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/12/6.
 *
 * 这个moudle是为了展示一个Component可以包含多个Module，
 * 这样Component获取依赖时候会自动从多个Module中查找获取，注意Module间不能有重复方法。添加多个Module有两种方法，
 * 一种是在Component的注解@Component(modules={××××，×××}) 添加多个modules
 * 还有一种是在 被使用Module中的@Module（includes={××××，×××}）
 */

@Module
public class DraggerActivityOtherModule {

    @Provides
    WangBean provideWangBean() {
        return new WangBean();
    }

}
