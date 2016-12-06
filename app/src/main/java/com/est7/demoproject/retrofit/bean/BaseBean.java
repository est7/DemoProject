package com.est7.demoproject.retrofit.bean;

/**
 * Created by tao.
 * <p>
 * Created Time : 2016/12/6 16:42.
 * <p>
 * Description : File in  com.est7.demoproject.retrofit, Project in DemoProject.
 * <p>
 * Content:基础bean
 */



/**
 * wendu : 9
 * ganmao : 昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。
 * forecast : [{"fengxiang":"南风","fengli":"微风级","high":"高温 10℃","type":"晴","low":"低温 -1℃","date":"6日星期二"},{"fengxiang":"北风","fengli":"微风级","high":"高温 12℃","type":"晴","low":"低温 1℃","date":"7日星期三"},{"fengxiang":"南风","fengli":"微风级","high":"高温 13℃","type":"晴","low":"低温 -2℃","date":"8日星期四"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 7℃","type":"多云","low":"低温 -2℃","date":"9日星期五"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 8℃","type":"多云","low":"低温 -1℃","date":"10日星期六"}]
 * yesterday : {"fl":"3-4级","fx":"北风","high":"高温 10℃","type":"多云","low":"低温 -3℃","date":"5日星期一"}
 * city : 济宁
 */
public class BaseBean<T> {

    private String desc;
    private int status;
    private T data;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



}
