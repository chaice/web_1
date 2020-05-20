package com.ccit;

import java.util.concurrent.TimeUnit;

public class GameRefresh {
    public static void main(String[] args) {
        type1006();
    }

    //游戏刷表
    private static void type1003() {
        String time = String.valueOf(System.currentTimeMillis());
        String type = "1003";
        String realKey = "e$742(^%DGTD)!D2*#*7kg%&g13";

        String sign = MD5Util.encrypt("type=" + type + "&key=" + realKey + "&time=" + time);

        StringBuilder url = new StringBuilder();

        url.append("http://101.132.106.162:8081/gmservlet");
        url.append("?type="+ type);
        url.append("&time="+ time);
        url.append("&sign="+ sign);

        System.out.println(url.toString());
    }

    //游戏封号
    private static void type1006(){
        String time = String.valueOf(System.currentTimeMillis());
        String sealTime = String.valueOf(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(365));
        String type = "1006";
        String realKey = "e$742(^%DGTD)!D2*#*7kg%&g13";

        String sign = MD5Util.encrypt("type=" + type + "&key=" + realKey + "&time=" + time);

        StringBuilder url = new StringBuilder();

        url.append("http://101.132.106.162:8081/gmservlet");
        url.append("?characterIds=100102939");
        url.append("&sealTime="+ sealTime);
        url.append("&type="+ type);
        url.append("&time="+ time);
        url.append("&sign="+ sign);

        System.out.println(url.toString());
    }
}
