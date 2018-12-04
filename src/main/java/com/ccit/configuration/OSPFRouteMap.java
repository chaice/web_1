package com.ccit.configuration;

import java.io.Serializable;

public class OSPFRouteMap implements Serializable {

    private String name;

    private int seq;

    private String prefix_list;

    private String action;

    private String action_value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getPrefix_list() {
        return prefix_list;
    }

    public void setPrefix_list(String prefix_list) {
        this.prefix_list = prefix_list;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction_value() {
        return action_value;
    }

    public void setAction_value(String action_value) {
        this.action_value = action_value;
    }

    public OSPFRouteMap() {
    }

    public OSPFRouteMap(String name, int seq, String prefix_list, String action, String action_value) {
        this.name = name;
        this.seq = seq;
        this.prefix_list = prefix_list;
        this.action = action;
        this.action_value = action_value;
    }
}
