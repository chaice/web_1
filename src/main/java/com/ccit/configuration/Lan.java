package com.ccit.configuration;

import java.io.Serializable;
import java.util.List;

public class Lan implements Serializable {

    private String interface_name;

    private String mode;

    private List<Integer> vlan;

    private Integer native_vlan;

    public String getInterface_name() {
        return interface_name;
    }

    public void setInterface_name(String interface_name) {
        this.interface_name = interface_name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<Integer> getVlan() {
        return vlan;
    }

    public void setVlan(List<Integer> vlan) {
        this.vlan = vlan;
    }

    public Integer getNative_vlan() {
        return native_vlan;
    }

    public void setNative_vlan(Integer native_vlan) {
        this.native_vlan = native_vlan;
    }

    public Lan() {
    }

    public Lan(String interface_name, String mode, List<Integer> vlan, Integer native_vlan) {
        this.interface_name = interface_name;
        this.mode = mode;
        this.vlan = vlan;
        this.native_vlan = native_vlan;
    }
}
