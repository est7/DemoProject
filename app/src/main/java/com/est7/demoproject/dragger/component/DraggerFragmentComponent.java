package com.est7.demoproject.dragger.component;

import com.est7.demoproject.dragger.Dragger1Fragment;
import com.est7.demoproject.dragger.Dragger2Fragment;
import com.est7.demoproject.dragger.DraggerFragment;
import com.est7.demoproject.dragger.module.DraggerFragemntModule;
import com.est7.demoproject.dragger.scope.FragmentScope;

import dagger.Subcomponent;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/8 1:54.
 * <p>
 * Description : File in com.est7.demoproject.dragger.component , Project in DemoProject
 * <p>
 * Content:
 */
@FragmentScope
//这里表示 DraggerFragmentComponent 是一个子组件，
// 如何确定他的父组件呢？
// 提供了获取 DraggerFragmentComponent 的组件，如 DraggerActivityComponent中有一个方法  DraggerFragmentComponent providesDraggerFragmentComponent();，
@Subcomponent(modules = DraggerFragemntModule.class)
public interface DraggerFragmentComponent {

    //所有的Fragment可以依赖于同一个FragmentComponent，所以可以这么写
    void inject(DraggerFragment draggerFragment);

    void inject(Dragger1Fragment dragger1Fragment);

    void inject(Dragger2Fragment dragger2Fragment);

}
