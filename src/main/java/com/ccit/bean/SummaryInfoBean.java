package com.ccit.bean;

public class SummaryInfoBean {

    private String area;

    private String shopNo;

    private String maxBandwidth;

    private String averageBandwidth;

    private String averageLatency;

    public SummaryInfoBean(String area, String shopNo, String maxBandwidth, String averageBandwidth, String averageLatency) {
        this.area = area;
        this.shopNo = shopNo;
        this.maxBandwidth = maxBandwidth;
        this.averageBandwidth = averageBandwidth;
        this.averageLatency = averageLatency;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getMaxBandwidth() {
        return maxBandwidth;
    }

    public void setMaxBandwidth(String maxBandwidth) {
        this.maxBandwidth = maxBandwidth;
    }

    public String getAverageBandwidth() {
        return averageBandwidth;
    }

    public void setAverageBandwidth(String averageBandwidth) {
        this.averageBandwidth = averageBandwidth;
    }

    public String getAverageLatency() {
        return averageLatency;
    }

    public void setAverageLatency(String averageLatency) {
        this.averageLatency = averageLatency;
    }
}
