package com.ccit.configuration;

import java.io.Serializable;

public class SNAT implements Serializable {

    private String original_src_cidr;

    private String dst_cidr;

    private String protocol;

    private String dst_port;

    private String target_src_ip;

    public String getOriginal_src_cidr() {
        return original_src_cidr;
    }

    public void setOriginal_src_cidr(String original_src_cidr) {
        this.original_src_cidr = original_src_cidr;
    }

    public String getDst_cidr() {
        return dst_cidr;
    }

    public void setDst_cidr(String dst_cidr) {
        this.dst_cidr = dst_cidr;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDst_port() {
        return dst_port;
    }

    public void setDst_port(String dst_port) {
        this.dst_port = dst_port;
    }

    public String getTarget_src_ip() {
        return target_src_ip;
    }

    public void setTarget_src_ip(String target_src_ip) {
        this.target_src_ip = target_src_ip;
    }

    public SNAT() {
    }

    public SNAT(String original_src_cidr, String dst_cidr, String protocol, String dst_port, String target_src_ip) {
        this.original_src_cidr = original_src_cidr;
        this.dst_cidr = dst_cidr;
        this.protocol = protocol;
        this.dst_port = dst_port;
        this.target_src_ip = target_src_ip;
    }
}
