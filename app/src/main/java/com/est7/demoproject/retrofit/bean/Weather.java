package com.est7.demoproject.retrofit.bean;

import java.util.List;

/**
 * Created by tao.
 * <p>
 * Created Time : 2016/12/6 14:10.
 * <p>
 * Description : File in  com.est7.demoproject.retrofit, Project in DemoProject.
 * <p>
 * Content:天气实体bean
 */
public class Weather {

    /**
     * wendu : 9
     * ganmao : 昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。
     * forecast : [{"fengxiang":"南风","fengli":"微风级","high":"高温 10℃","type":"晴","low":"低温 -1℃","date":"6日星期二"},{"fengxiang":"北风","fengli":"微风级","high":"高温 12℃","type":"晴","low":"低温 1℃","date":"7日星期三"},{"fengxiang":"南风","fengli":"微风级","high":"高温 13℃","type":"晴","low":"低温 -2℃","date":"8日星期四"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 7℃","type":"多云","low":"低温 -2℃","date":"9日星期五"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 8℃","type":"多云","low":"低温 -1℃","date":"10日星期六"}]
     * yesterday : {"fl":"3-4级","fx":"北风","high":"高温 10℃","type":"多云","low":"低温 -3℃","date":"5日星期一"}
     * city : 济宁
     */
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private String city;
        private List<ForecastBean> forecast;

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }
    }

