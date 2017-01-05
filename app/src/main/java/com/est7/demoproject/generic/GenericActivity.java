package com.est7.demoproject.generic;
/**
 * Created by tao.
 * <p>
 * Created Time : 2016/12/12 20:41.
 * <p>
 * Description : File in  com.est7.demoproject.generic, Project in DemoProject.
 * <p>
 * Content:
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.est7.demoproject.generic.bean.HeroPool;
import com.est7.demoproject.generic.bean.PigSister;
import com.est7.demoproject.generic.bean.Tank;
import com.est7.demoproject.generic.bean.VN;
import com.est7.demoproject.utils.ToastUtil;

/**
 * Created by tao.
 *
 * Created Time : 2016/12/12 20:41.
 *
 * Description : 泛型
 *
 */
public class GenericActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //规定超哥只能玩tank
       // HeroPool<? extends Tank> chaoHeroPool = new HeroPool<>(new PigSister("猪妹"));

       // HeroPool<? extends Tank> chaoHeroPool = new HeroPool<Tank>(new PigSister("猪妹"));

       // ToastUtil.show(chaoHeroPool.getHero().name);

        //规定航哥不能玩猪妹
       HeroPool<? super Tank> hangHeroPool= new HeroPool<>(new VN("猪妹"));

        ToastUtil.show(((PigSister)hangHeroPool.getHero()).name+"航哥");


    }
}