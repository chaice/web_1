package com.ccit.configuration;

import java.io.Serializable;
import java.util.List;

public class BGP implements Serializable {

    private int local_as;

    private String router_id;

    private List<BGPCIDR> network;

    private List<BGPRouteMap> route_map;

    private List<BGPGroup> group;

    public int getLocal_as() {
        return local_as;
    }

    public void setLocal_as(int local_as) {
        this.local_as = local_as;
    }

    public String getRouter_id() {
        return router_id;
    }

    public void setRouter_id(String router_id) {
        this.router_id = router_id;
    }

    public List<BGPCIDR> getNetwork() {
        return network;
    }

    public void setNetwork(List<BGPCIDR> network) {
        this.network = network;
    }

    public List<BGPRouteMap> getRoute_map() {
        return route_map;
    }

    public void setRoute_map(List<BGPRouteMap> route_map) {
        this.route_map = route_map;
    }

    public List<BGPGroup> getGroup() {
        return group;
    }

    public void setGroup(List<BGPGroup> group) {
        this.group = group;
    }

    public BGP() {
    }

    public BGP(int local_as, String router_id, List<BGPCIDR> network, List<BGPRouteMap> route_map, List<BGPGroup> group) {
        this.local_as = local_as;
        this.router_id = router_id;
        this.network = network;
        this.route_map = route_map;
        this.group = group;
    }
}
