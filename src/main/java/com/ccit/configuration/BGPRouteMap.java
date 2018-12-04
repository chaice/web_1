package com.ccit.configuration;

import java.io.Serializable;

public class BGPRouteMap implements Serializable {

    private String name;

    private String action;

    private String action_value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BGPRouteMap() {
    }

    public BGPRouteMap(String name, String action, String action_value) {
        this.name = name;
        this.action = action;
        this.action_value = action_value;
    }
}
