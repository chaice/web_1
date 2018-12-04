package com.ccit.configuration;

import java.io.Serializable;

public class BGPCIDR implements Serializable {

    private String cidr;

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public BGPCIDR() {
    }

    public BGPCIDR(String cidr) {
        this.cidr = cidr;
    }
}