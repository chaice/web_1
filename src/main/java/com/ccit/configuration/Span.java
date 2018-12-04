package com.ccit.configuration;

import java.io.Serializable;
import java.util.List;

public class Span implements Serializable {

    private List<String> src_lan_list;

    private List<Long> src_vlan_list;

    private String span_type;

    private String target_lan;

    private Long target_vlan;

    public List<String> getSrc_lan_list() {
        return src_lan_list;
    }

    public void setSrc_lan_list(List<String> src_lan_list) {
        this.src_lan_list = src_lan_list;
    }

    public List<Long> getSrc_vlan_list() {
        return src_vlan_list;
    }

    public void setSrc_vlan_list(List<Long> src_vlan_list) {
        this.src_vlan_list = src_vlan_list;
    }

    public String getSpan_type() {
        return span_type;
    }

    public void setSpan_type(String span_type) {
        this.span_type = span_type;
    }

    public String getTarget_lan() {
        return target_lan;
    }

    public void setTarget_lan(String target_lan) {
        this.target_lan = target_lan;
    }

    public Long getTarget_vlan() {
        return target_vlan;
    }

    public void setTarget_vlan(Long target_vlan) {
        this.target_vlan = target_vlan;
    }
}
