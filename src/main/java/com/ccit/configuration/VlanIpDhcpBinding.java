package com.ccit.configuration;

import java.io.Serializable;

public class VlanIpDhcpBinding implements Serializable {

    private String ip;
    private String mac;

    public String getIp() {
        return ip;
    }

    public VlanIpDhcpBinding() {
    }

    public VlanIpDhcpBinding(String ip, String mac) {
        this.ip = ip;
        this.mac = mac;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
