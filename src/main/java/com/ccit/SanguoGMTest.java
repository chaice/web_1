package com.ccit;

import java.util.concurrent.TimeUnit;

public class SanguoGMTest {
    public static void main(String[] args) {

        String time = String.valueOf(System.currentTimeMillis());
        String sealTime = String.valueOf(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(365));
        String type = "1006";
        String realKey = "e$742(^%DGTD)!D2*#*7kg%&g13";

        String sign = MD5Util.encrypt("type=" + type + "&key=" + realKey + "&time=" + time);

        StringBuilder url = new StringBuilder();

        url.append("http://112.64.35.149:8088/gmservlet");
        url.append("?characterIds=10000001");
        url.append("&sealTime="+ sealTime);
        url.append("&type="+ type);
        url.append("&time="+ time);
        url.append("&sign="+ sign);

        System.out.println(url.toString());
    }
}
