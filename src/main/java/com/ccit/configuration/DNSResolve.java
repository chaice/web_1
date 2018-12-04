package com.ccit.configuration;

import java.io.Serializable;

public class DNSResolve implements Serializable {

    private String domain;

    private String ip;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public DNSResolve() {
    }

    public DNSResolve(String domain, String ip) {
        this.domain = domain;
        this.ip = ip;
    }

}
