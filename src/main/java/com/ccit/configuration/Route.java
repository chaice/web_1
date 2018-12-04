package com.ccit.configuration;

import java.io.Serializable;

public class Route implements Serializable {

    private String ip;

    private String netmask;

    private String next_hop;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public String getNext_hop() {
        return next_hop;
    }

    public void setNext_hop(String next_hop) {
        this.next_hop = next_hop;
    }

    public Route() {
    }

    public Route(String ip, String netmask, String next_hop) {
        this.ip = ip;
        this.netmask = netmask;
        this.next_hop = next_hop;
    }
}
