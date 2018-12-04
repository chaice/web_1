package com.ccit.configuration;

import java.io.Serializable;

public class SinglePortForwarding implements Serializable {

    private String protocol;

    private int internal_port;

    private int external_port;

    private String internal_ip;

    private String external_ip;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getInternal_port() {
        return internal_port;
    }

    public void setInternal_port(int internal_port) {
        this.internal_port = internal_port;
    }

    public int getExternal_port() {
        return external_port;
    }

    public void setExternal_port(int external_port) {
        this.external_port = external_port;
    }

    public String getInternal_ip() {
        return internal_ip;
    }

    public void setInternal_ip(String internal_ip) {
        this.internal_ip = internal_ip;
    }

    public String getExternal_ip() {
        return external_ip;
    }

    public void setExternal_ip(String external_ip) {
        this.external_ip = external_ip;
    }

    public SinglePortForwarding() {
    }

    public SinglePortForwarding(String protocol, int internal_port, int external_port, String internal_ip, String external_ip) {
        this.protocol = protocol;
        this.internal_port = internal_port;
        this.external_port = external_port;
        this.internal_ip = internal_ip;
        this.external_ip = external_ip;
    }
}
