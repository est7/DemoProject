package com.est7.demoproject.generic.bean;

/**
 * Created by tao.
 * <p>
 * Created Time : 2016/12/12 20:59.
 * <p>
 * Description : File in  com.est7.demoproject.generic.bean, Project in DemoProject.
 * <p>
 * Content:英雄池
 */

public class HeroPool<T extends Hero> {

    public HeroPool(T hero) {
        this.hero = hero;
    }

    private T hero;

    public T getHero() {
        return hero;
    }

    public void setHero(T hero) {
        this.hero = hero;
    }
}
