package com.ccit.configuration;

import java.io.Serializable;

public class SecurityRule implements Serializable {

    private String src_cidr;

    private String src_port;

    private String dst_cidr;

    private String dst_port;

    private String protocol;

    private String action;

    public String getSrc_cidr() {
        return src_cidr;
    }

    public void setSrc_cidr(String src_cidr) {
        this.src_cidr = src_cidr;
    }

    public String getSrc_port() {
        return src_port;
    }

    public void setSrc_port(String src_port) {
        this.src_port = src_port;
    }

    public String getDst_cidr() {
        return dst_cidr;
    }

    public void setDst_cidr(String dst_cidr) {
        this.dst_cidr = dst_cidr;
    }

    public String getDst_port() {
        return dst_port;
    }

    public void setDst_port(String dst_port) {
        this.dst_port = dst_port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public SecurityRule() {
    }

    public SecurityRule(String src_cidr, String src_port, String dst_cidr, String dst_port, String protocol, String action) {
        this.src_cidr = src_cidr;
        this.src_port = src_port;
        this.dst_cidr = dst_cidr;
        this.dst_port = dst_port;
        this.protocol = protocol;
        this.action = action;
    }
}
