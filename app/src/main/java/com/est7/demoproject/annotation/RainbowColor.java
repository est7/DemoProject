package com.est7.demoproject.annotation;

/**
 * Created by Administrator on 2017/2/8.
 * <p>
 * 这样写常量有以下几个问题
 * 1.类型不安全
 * 由于颜色常量的对应值是整数形，所以程序执行过程中很有可能给颜色变量传入一个任意的整数值，导致出现错误。
 * 2.没有命名空间
 * 由于颜色常量只是类的属性，当你使用的时候不得不通过类来访问。
 * 3.一致性差
 * 因为整形枚举属于编译期常量，所以编译过程完成后，所有客户端和服务器端引用的地方，会直接将整数值写入。这样，当你修改旧的枚举整数值后或者增加新的枚举值后，所有引用地方代码都需要重新编译，否则运行时刻就会出现错误。
 * 4.类型无指意性
 * 由于颜色枚举值仅仅是一些无任何含义的整数值，如果在运行期调试时候，你就会发现日志中有很多魔术数字，但除了程序员本身，其他人很难明白其奥秘。
 */

public class RainbowColor {

    // 红橙黄绿青蓝紫七种颜色的常量定义
    public static final int RED = 0;
    public static final int ORANGE = 1;
    public static final int YELLOW = 2;
    public static final int GREEN = 3;
    public static final int CYAN = 4;
    public static final int BLUE = 5;
    public static final int PURPLE = 6;
}