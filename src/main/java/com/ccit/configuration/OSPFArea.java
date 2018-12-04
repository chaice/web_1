package com.ccit.configuration;

import java.io.Serializable;

public class OSPFArea implements Serializable {

    private String cidr;

    private String area;

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public OSPFArea() {
    }

    public OSPFArea(String cidr, String area) {
        this.cidr = cidr;
        this.area = area;
    }
}
