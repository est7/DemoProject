package com.est7.demoproject.component;

import com.est7.demoproject.dragger.DaggerActivity;
import com.est7.demoproject.dragger.bean.LiBean;
import com.est7.demoproject.dragger.bean.TaoBean;
import com.est7.demoproject.dragger.bean.UserBean;
import com.est7.demoproject.dragger.module.DraggerActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2016/12/6.
 *
 * 这里的singleton并不是说这是三个对象都是单例,只是说这里面有单例..单例就是libean,在muodle中可以看出来
 *
 */
@Singleton
@Component(modules = DraggerActivityModule.class)
public interface DraggerActivityComponent {

    //下面这三个方法，返回值必须是从上面指定的依赖库DraggerActivityMoudle.class中取得的对象
    //方法名不一致也行，但是方便阅读，建议一致，因为它主要是根据返回值类型来找依赖的
    //当然！！！！下面这三个方法也可以不写，但是如果要写，就按照这个格式来
    //但是当Component要被别的Component依赖时，这里就必须写这个方法，不写代表不向别的Component暴露此依赖，这里是个容易出bug的地方

    LiBean providesLiBean();
    TaoBean providesTaoBean();
    UserBean providesUserBean();

    //下面的这个方法，表示要将以上的三个依赖注入到某个类中
    void inject(DaggerActivity daggerActivity);

}
