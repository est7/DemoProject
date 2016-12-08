package com.est7.demoproject.dragger;

import android.support.v4.app.Fragment;

import com.est7.demoproject.dragger.bean.ChaoBean;
import com.est7.demoproject.dragger.component.DaggerDraggerActivityComponent;
import com.est7.demoproject.dragger.module.DraggerActivityOtherModule;

import javax.inject.Inject;
import javax.inject.Named;


public class Dragger2Fragment extends Fragment {
    @Inject
    @Named("提莫") //添加标记@Name("typeA")，只获取对应的@Name("typeA")的元依赖   @Inject
            ChaoBean mChaoBean;
    @Inject
    @Named("盖伦") //添加标记@Name("typeA")，只获取对应的@Name("typeA")的依赖    @Inject
            ChaoBean mChaoBean1;

    public Dragger2Fragment() {

        initDI();
    }

    private void initDI() {

        DaggerDraggerActivityComponent
                .builder()
                .draggerActivityOtherModule(new DraggerActivityOtherModule())
                .build()
                .providesDraggerFragmentComponent()
                .inject(this);


    }


}
