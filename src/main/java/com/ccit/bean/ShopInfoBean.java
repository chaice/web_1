package com.ccit.bean;

public class ShopInfoBean {

    private String shopIndex;

    private String shopName;

    private String boxTrafficImagePath;

    private String boxTrafficImagePathEncoder;

    private String linkTrafficImagePath;

    private String linkTrafficImagePathEncoder;

    private String latencyImagePath;

    private String latencyImagePathEncoder;

    private String lossRateImagePath;

    private String lossRateImagePathEncoder;

    public ShopInfoBean(String shopIndex, String shopName, String boxTrafficImagePath, String boxTrafficImagePathEncoder, String linkTrafficImagePath, String linkTrafficImagePathEncoder, String latencyImagePath, String latencyImagePathEncoder, String lossRateImagePath, String lossRateImagePathEncoder) {
        this.shopIndex = shopIndex;
        this.shopName = shopName;
        this.boxTrafficImagePath = boxTrafficImagePath;
        this.boxTrafficImagePathEncoder = boxTrafficImagePathEncoder;
        this.linkTrafficImagePath = linkTrafficImagePath;
        this.linkTrafficImagePathEncoder = linkTrafficImagePathEncoder;
        this.latencyImagePath = latencyImagePath;
        this.latencyImagePathEncoder = latencyImagePathEncoder;
        this.lossRateImagePath = lossRateImagePath;
        this.lossRateImagePathEncoder = lossRateImagePathEncoder;
    }

    public String getShopIndex() {
        return shopIndex;
    }

    public void setShopIndex(String shopIndex) {
        this.shopIndex = shopIndex;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getBoxTrafficImagePath() {
        return boxTrafficImagePath;
    }

    public void setBoxTrafficImagePath(String boxTrafficImagePath) {
        this.boxTrafficImagePath = boxTrafficImagePath;
    }

    public String getBoxTrafficImagePathEncoder() {
        return boxTrafficImagePathEncoder;
    }

    public void setBoxTrafficImagePathEncoder(String boxTrafficImagePathEncoder) {
        this.boxTrafficImagePathEncoder = boxTrafficImagePathEncoder;
    }

    public String getLinkTrafficImagePath() {
        return linkTrafficImagePath;
    }

    public void setLinkTrafficImagePath(String linkTrafficImagePath) {
        this.linkTrafficImagePath = linkTrafficImagePath;
    }

    public String getLinkTrafficImagePathEncoder() {
        return linkTrafficImagePathEncoder;
    }

    public void setLinkTrafficImagePathEncoder(String linkTrafficImagePathEncoder) {
        this.linkTrafficImagePathEncoder = linkTrafficImagePathEncoder;
    }

    public String getLatencyImagePath() {
        return latencyImagePath;
    }

    public void setLatencyImagePath(String latencyImagePath) {
        this.latencyImagePath = latencyImagePath;
    }

    public String getLatencyImagePathEncoder() {
        return latencyImagePathEncoder;
    }

    public void setLatencyImagePathEncoder(String latencyImagePathEncoder) {
        this.latencyImagePathEncoder = latencyImagePathEncoder;
    }

    public String getLossRateImagePath() {
        return lossRateImagePath;
    }

    public void setLossRateImagePath(String lossRateImagePath) {
        this.lossRateImagePath = lossRateImagePath;
    }

    public String getLossRateImagePathEncoder() {
        return lossRateImagePathEncoder;
    }

    public void setLossRateImagePathEncoder(String lossRateImagePathEncoder) {
        this.lossRateImagePathEncoder = lossRateImagePathEncoder;
    }
}
