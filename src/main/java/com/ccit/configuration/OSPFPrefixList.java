package com.ccit.configuration;

import java.io.Serializable;

public class OSPFPrefixList implements Serializable {

    private String name;

    private Integer seq;

    private String action;

    private String cidr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public OSPFPrefixList() {
    }

    public OSPFPrefixList(String name, Integer seq, String action, String cidr) {
        this.name = name;
        this.seq = seq;
        this.action = action;
        this.cidr = cidr;
    }
}
