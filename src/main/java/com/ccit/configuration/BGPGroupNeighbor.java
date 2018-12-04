package com.ccit.configuration;

import java.io.Serializable;

public class BGPGroupNeighbor implements Serializable {

    private String ip;

    private String route_map;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRoute_map() {
        return route_map;
    }

    public void setRoute_map(String route_map) {
        this.route_map = route_map;
    }

    public BGPGroupNeighbor() {
    }

    public BGPGroupNeighbor(String ip, String route_map) {
        this.ip = ip;
        this.route_map = route_map;
    }
}
