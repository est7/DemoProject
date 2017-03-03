package com.est7.demoproject.annotation;

import android.support.annotation.UiThread;

import com.orhanobut.logger.Logger;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/2/8.
 */

public class MainClass {

    @SuppressWarnings("")
    @ZhuJieBean(name = "lihang", value = "hahaahh")
    public void startTest() {
        Method[] methods = getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ZhuJieBean.class)) {
                ZhuJieBean zhuJieBean = method.getAnnotation(ZhuJieBean.class);
                Logger.d(zhuJieBean.name() + zhuJieBean.value());
            }
        }
    }


    public void startAndoridAnnotation() {


        //  相对于Int静态常量来说，枚举最大的作用是提供了类型安全。
        UserI userI = new UserI();
        /*正确调用*/
        userI.setUserType(userI.childe);

        /*错误调用
        * 因为调用者可以在setUserType()传递任何整数，那么导致出现了非男非女非儿童的性别，而使用枚举可以有效避免上述情况。
        * */
        userI.setUserType(100);


        doSomething();
    }


//在activity中可以表示uithread中才能调用该方法
    @UiThread
    public void doSomething() {

    }

    public void Eunm的好处() {

        // 读取当天的信息
        WeekDayEnum today = readToday();

        // 根据日期来选择进行活动
        switch (today) {
            case Mon:
                System.out.println("do something;");
                break;
            case Tue:
                System.out.println("do something;");
                break;
            case Wed:
                System.out.println("do something;");
                break;
            case Thu:
                System.out.println("do something;");
                break;
            case Fri:
                System.out.println("do something;");
                break;
            case Sat:
                System.out.println(" play sports game");
                break;
            case Sun:
                System.out.println(" have a rest");
                break;
        }
    }

    public void Eunm的好处1() {
        // 读取彩虹信息
        RainbowColorEnum RainbowColorEnum = getRainbowColorEnum();
        String color = RainbowColorEnum.getColor();
        Logger.d(color);
    }

    private WeekDayEnum readToday() {
        return WeekDayEnum.Sat;
    }

    public RainbowColorEnum getRainbowColorEnum() {
        return RainbowColorEnum.ORANGE;
    }
}
