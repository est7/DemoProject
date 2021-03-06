package com.est7.demoproject.dragger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2016/12/8 1:03.
 * <p>
 * Description : File in com.est7.demoproject , Project in DemoProject
 * <p>
 * Content:元注解就是定义注解的注解，包含@Target、@Retention、@Inherited、@Documented这四种。
 *
 * @Target 描述注解的使用目标，取值有：
 * ElementType.PACKAGE 注解作用于包
 * ElementType.TYPE 注解作用于类型（类，接口，注解，枚举）
 * ElementType.ANNOTATION_TYPE 注解作用于注解
 * ElementType.CONSTRUCTOR 注解作用于构造方法
 * ElementType.METHOD 注解作用于方法
 * ElementType.PARAMETER 注解作用于方法参数
 * ElementType.FIELD 注解作用于属性
 * ElementType.LOCAL_VARIABLE 注解作用于局部变量
 * 默认可以作用于以上任何目标。
 * @Retention 描述注解的生命周期，取值有：
 * RetentionPolicy.SOURCE 源码中保留，编译期可以处理
 * RetentionPolicy.CLASS Class文件中保留，Class加载时可以处理
 * RetentionPolicy.RUNTIME 运行时保留，运行中可以处理
 * @Inherited 标记注解，使用@Inherited修饰的注解作用于一个类，则该注解将被用于该类的子类。
 * @Documented 描述注解可以文档化，是一个标记注解。
 * 在生成javadoc的时候，是不包含注释的，但是如果注解被@Documented修饰，则生成的文档就包含该注解。
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)//保留策略
public @interface ActivityScope {
    //这个自定义域的作用是为了让对象被记录在正确的组件中.怎么理解呢
    // 在这里被这个activityscope标记的组件的对象的生命周期应该都跟 Activity 的生命周期一致。
    //还有,对于这个自定义的域
    //如果被依赖的 Component 使用了Scope，那么依赖他的 Component 也必须使用Scope才能使用。
    // 典型例子就是：代码中ActivityComponent dependencies  AppComponent
    // 所以由于AppComponent使用了 Scope，那么ActivityComponent也必须使用Scope(要求必须是不同的域)，否则会编译出错。
    //Singleton的组件不能依赖其他scope的组件，只能其他scope的组件依赖Singleton的组件。
    //没有scope的不能依赖有scope的组件，理解一下。。。


    /*
         这里是我理解的Scope的作用:
         首先看一个使用@Scope注解的注解@Singleton,
         Singleton就是单例的意思,但是这个单例是基于Component的,
         两个不同的component是无法产生单例的依赖;
         所以我们要获得全局的单例,就必须控制component的唯一性,所以在application中初始化
         component是较好的选择;
         如果我们仅仅要求在当前activity中是单例,在activity中初始化component是较好的选择.
         使用scope管理依赖的生命周期,实际是就是通过初始化目标类的同时初始化component,目标类消亡的时候
         销毁component,达到同生共死的目的;

         (这一段中的scope指的是使用过@scope标注过的注解,就像@Singleton)
         Scope还有的一个作用是管理component与module的对应关系,如果module中使用了scope,那么component中必须使用相同的
         scope,如果两个module对应一个component且两个module中使用了不同的scope,那么component中必须使用两个scope,简单说
         一个component的对应的module(不管几个)中使用了不管几个scope,那么这个component也必须使用相同的scope

         scope的另一个作用是管理component之间的依赖(dependencies),包含(SubComponent)关系,这个航哥已经解释过了;

         所以component依赖关系之间,要求必须是不同的scope;


         关于@Qualifier限定符
         这个没几把用,主要作用就是区分返回类型相同的情况(高大上叫做:依赖迷失),@Named是本身提供的一个用@Qualifier标注过的注解,所以没必要使用自定义qualifier来
         解决依赖迷失问题;

     */


}
