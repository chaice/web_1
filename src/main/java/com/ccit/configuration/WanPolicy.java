package com.ccit.configuration;

import java.io.Serializable;

public class WanPolicy implements Serializable {

    private String src_cidr;

    public String getSrc_cidr() {
        return src_cidr;
    }

    public void setSrc_cidr(String src_cidr) {
        this.src_cidr = src_cidr;
    }

    public WanPolicy() {
    }

    public WanPolicy(String src_cidr) {
        this.src_cidr = src_cidr;
    }
}
