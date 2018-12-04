package com.ccit.configuration;

import java.io.Serializable;
import java.util.List;

public class Vlan implements Serializable {

    private int vlan_id;

    private List<VlanIP> ip;

    public int getVlan_id() {
        return vlan_id;
    }

    public void setVlan_id(int vlan_id) {
        this.vlan_id = vlan_id;
    }

    public List<VlanIP> getIp() {
        return ip;
    }

    public void setIp(List<VlanIP> ip) {
        this.ip = ip;
    }

    public Vlan() {
    }

    public Vlan(int vlan_id, List<VlanIP> ip) {
        this.vlan_id = vlan_id;
        this.ip = ip;
    }
}
