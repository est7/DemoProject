package com.est7.demoproject.dragger.component;

import com.est7.demoproject.dragger.DraggerFragment;
import com.est7.demoproject.dragger.module.DraggerFragemntModule;

import dagger.Component;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/8 1:54.
 * <p>
 * Description : File in com.est7.demoproject.dragger.component , Project in DemoProject
 * <p>
 * Content:
 */
@Component(modules = DraggerFragemntModule.class)
public interface DraggerFragmentComponent {

    void inject(DraggerFragment draggerFragment);

}
