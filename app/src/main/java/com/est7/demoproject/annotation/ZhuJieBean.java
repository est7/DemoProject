package com.est7.demoproject.annotation;

/**
 * Created by Administrator on 2017/2/8.
 *
 * 注解的作用：
 */



public @interface ZhuJieBean {
    @Deprecated
    String value();
    String name();
}
/*Java内置注解

@Deprecated 被弃用

@Override 复写

@SuppressWarnings 当我们的一个方法调用了弃用的方法或者进行不安全的类型转换，编译器会生成警告。我们可以为这个方法增加@SuppressWarnings注解，来抑制编译器生成警告

*/





