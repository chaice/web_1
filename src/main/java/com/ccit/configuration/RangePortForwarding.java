package com.ccit.configuration;

import java.io.Serializable;

public class RangePortForwarding implements Serializable {

    private String protocol;

    private int start_port;

    private int end_port;

    private String internal_ip;

    private String external_ip;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getStart_port() {
        return start_port;
    }

    public void setStart_port(int start_port) {
        this.start_port = start_port;
    }

    public int getEnd_port() {
        return end_port;
    }

    public void setEnd_port(int end_port) {
        this.end_port = end_port;
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

    public RangePortForwarding() {
    }

    public RangePortForwarding(String protocol, int start_port, int end_port, String internal_ip, String external_ip) {
        this.protocol = protocol;
        this.start_port = start_port;
        this.end_port = end_port;
        this.internal_ip = internal_ip;
        this.external_ip = external_ip;
    }
}
