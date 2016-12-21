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
    // 所以由于AppComponent使用了 Scope，那么ActivityComponent也必须使用Scope(要求必须是相同的域)，否则会编译出错。
    //Singleton的组件不能依赖其他scope的组件，只能其他scope的组件依赖Singleton的组件。
    //没有scope的不能依赖有scope的组件，理解一下。。。
}
