package com.ccit.configuration;

import java.io.Serializable;
import java.util.List;

public class Bond implements Serializable {

    private String name;

    private String mode;

    private String enable_lacp;

    private List<String> lan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getEnable_lacp() {
        return enable_lacp;
    }

    public void setEnable_lacp(String enable_lacp) {
        this.enable_lacp = enable_lacp;
    }

    public List<String> getLan() {
        return lan;
    }

    public void setLan(List<String> lan) {
        this.lan = lan;
    }

    public Bond() {
    }

    public Bond(String name, String mode, String enable_lacp, List<String> lan) {
        this.name = name;
        this.mode = mode;
        this.enable_lacp = enable_lacp;
        this.lan = lan;
    }
}
