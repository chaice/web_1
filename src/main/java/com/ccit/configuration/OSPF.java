package com.ccit.configuration;

import java.io.Serializable;
import java.util.List;

public class OSPF implements Serializable {

    private String router_id;

    private String redistribute_bgp;

    private String redistribute_static;

    private List<OSPFArea> network;

    private List<OSPFPrefixList> prefix_list;

    private List<OSPFRouteMap> route_map;

    public String getRouter_id() {
        return router_id;
    }

    public void setRouter_id(String router_id) {
        this.router_id = router_id;
    }

    public String getRedistribute_bgp() {
        return redistribute_bgp;
    }

    public void setRedistribute_bgp(String redistribute_bgp) {
        this.redistribute_bgp = redistribute_bgp;
    }

    public String getRedistribute_static() {
        return redistribute_static;
    }

    public void setRedistribute_static(String redistribute_static) {
        this.redistribute_static = redistribute_static;
    }

    public List<OSPFArea> getNetwork() {
        return network;
    }

    public void setNetwork(List<OSPFArea> network) {
        this.network = network;
    }

    public List<OSPFPrefixList> getPrefix_list() {
        return prefix_list;
    }

    public void setPrefix_list(List<OSPFPrefixList> prefix_list) {
        this.prefix_list = prefix_list;
    }

    public List<OSPFRouteMap> getRoute_map() {
        return route_map;
    }

    public void setRoute_map(List<OSPFRouteMap> route_map) {
        this.route_map = route_map;
    }

    public OSPF() {
    }

    public OSPF(String router_id, String redistribute_bgp, String redistribute_static, List<OSPFArea> network, List<OSPFPrefixList> prefix_list, List<OSPFRouteMap> route_map) {
        this.router_id = router_id;
        this.redistribute_bgp = redistribute_bgp;
        this.redistribute_static = redistribute_static;
        this.network = network;
        this.prefix_list = prefix_list;
        this.route_map = route_map;
    }
}
