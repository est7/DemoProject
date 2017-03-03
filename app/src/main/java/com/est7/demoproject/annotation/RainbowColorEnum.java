package com.est7.demoproject.annotation;

/**
 * Created by Administrator on 2017/2/8.
 *
 *  Java 语言规范赋予枚举类型的功能非常的强大，它不仅是简单地将整形数值转换成对象，而是将枚举类型定义转变成一个完整功能的类定义。
 *  这种类型定义的扩展允许开发者给枚举类型增加任何方法和属性，也可以实现任意的接口。
 *  另外，Java 平台也为 Enum 类型提供了高质量的实现，比如默认实现 Comparable 和 Serializable 接口，让开发者一般情况下不用关心这些细节。
 *  回到本文的主题上来，引入枚举类型到底能够给我们开发带来什么样好处呢？
 *  一个最直接的益处就是扩大 switch 语句使用范围。5.0 之前，Java 中 switch 的值只能够是简单类型，比如 int、byte、short、char, 有了枚举类型之后，就可以使用对象了。
 */

public enum RainbowColorEnum {
    RED("red"), ORANGE("orange"), YELLOW("yellow"), GREEN("green"), CYAN("cyan"), BLUE("blue"), PURPLE("purple");

    // 定义私有变量
    private String mColor;

    RainbowColorEnum(String color) {
        mColor = color;
    }

    public String getColor() {
        return mColor;
    }
}