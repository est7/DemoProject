package com.est7.demoproject.dragger;

import android.support.v4.app.Fragment;

import com.est7.demoproject.dragger.bean.ChaoBean;

import javax.inject.Named;


public class DraggerFragment extends Fragment {

    @Named("提莫") //添加标记@Name("typeA")，只获取对应的@Name("typeA")的元依赖   @Inject
            ChaoBean mChaoBean;
    @Named("盖伦") //添加标记@Name("typeA")，只获取对应的@Name("typeA")的依赖    @Inject
            ChaoBean mChaoBean1;

    public DraggerFragment() {

        initDI();
    }

    private void initDI() {

        //DaggerFruitComponent.creaete().inject(this);

    }


}
