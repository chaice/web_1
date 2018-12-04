package com.ccit.bean;

public class StoreInfo {

    private String storeID;
    private String subnet;
    private String gateway;
    private Boolean vlan10;
    private Boolean vlan20;

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getSubnet() {
        return subnet;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public Boolean getVlan10() {
        return vlan10;
    }

    public void setVlan10(Boolean vlan10) {
        this.vlan10 = vlan10;
    }

    public Boolean getVlan20() {
        return vlan20;
    }

    public void setVlan20(Boolean vlan20) {
        this.vlan20 = vlan20;
    }
}

