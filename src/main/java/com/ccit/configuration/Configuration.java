package com.ccit.configuration;

import java.io.Serializable;
import java.util.List;

public class Configuration implements Serializable {

    private Device device;

    private List<Vlan> vlan;

    private List<Lan> lan;

    private List<Bond> bond;

    private List<Wan> wan;

    private List<Route> route;

    private BGP bgp;

    private OSPF ospf;

    private List<RangePortForwarding> range_port_forwarding;

    private List<SinglePortForwarding> single_port_forwarding;

    private List<SNAT> snat;

    private List<SecurityRule> security_rule;

    private List<URLIntercept> url_intercept;

    private List<DNSResolve> dns_resolve;

    private List<VlanIpDhcpBinding> vlan_ip_binding;

    private List<Span> span;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public List<Vlan> getVlan() {
        return vlan;
    }

    public void setVlan(List<Vlan> vlan) {
        this.vlan = vlan;
    }

    public List<Lan> getLan() {
        return lan;
    }

    public void setLan(List<Lan> lan) {
        this.lan = lan;
    }

    public List<Bond> getBond() {
        return bond;
    }

    public void setBond(List<Bond> bond) {
        this.bond = bond;
    }

    public List<Wan> getWan() {
        return wan;
    }

    public void setWan(List<Wan> wan) {
        this.wan = wan;
    }

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    public BGP getBgp() {
        return bgp;
    }

    public void setBgp(BGP bgp) {
        this.bgp = bgp;
    }

    public OSPF getOspf() {
        return ospf;
    }

    public void setOspf(OSPF ospf) {
        this.ospf = ospf;
    }

    public List<RangePortForwarding> getRange_port_forwarding() {
        return range_port_forwarding;
    }

    public void setRange_port_forwarding(List<RangePortForwarding> range_port_forwarding) {
        this.range_port_forwarding = range_port_forwarding;
    }

    public List<SinglePortForwarding> getSingle_port_forwarding() {
        return single_port_forwarding;
    }

    public void setSingle_port_forwarding(List<SinglePortForwarding> single_port_forwarding) {
        this.single_port_forwarding = single_port_forwarding;
    }

    public List<SNAT> getSnat() {
        return snat;
    }

    public void setSnat(List<SNAT> snat) {
        this.snat = snat;
    }

    public List<SecurityRule> getSecurity_rule() {
        return security_rule;
    }

    public void setSecurity_rule(List<SecurityRule> security_rule) {
        this.security_rule = security_rule;
    }

    public List<URLIntercept> getUrl_intercept() {
        return url_intercept;
    }

    public void setUrl_intercept(List<URLIntercept> url_intercept) {
        this.url_intercept = url_intercept;
    }

    public List<DNSResolve> getDns_resolve() {
        return dns_resolve;
    }

    public void setDns_resolve(List<DNSResolve> dns_resolve) {
        this.dns_resolve = dns_resolve;
    }

    public List<VlanIpDhcpBinding> getVlan_ip_binding() {
        return vlan_ip_binding;
    }

    public void setVlan_ip_binding(List<VlanIpDhcpBinding> vlan_ip_binding) {
        this.vlan_ip_binding = vlan_ip_binding;
    }

    public List<Span> getSpan() {
        return span;
    }

    public void setSpan(List<Span> span) {
        this.span = span;
    }
}
