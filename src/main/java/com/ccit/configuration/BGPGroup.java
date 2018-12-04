package com.ccit.configuration;

import java.io.Serializable;
import java.util.List;

public class BGPGroup implements Serializable {

   private String name;

   private int remote_as;

   private String key;

    private List<BGPGroupNeighbor> neighbor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRemote_as() {
        return remote_as;
    }

    public void setRemote_as(int remote_as) {
        this.remote_as = remote_as;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<BGPGroupNeighbor> getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(List<BGPGroupNeighbor> neighbor) {
        this.neighbor = neighbor;
    }

    public BGPGroup() {
    }

    public BGPGroup(String name, int remote_as, String key, List<BGPGroupNeighbor> neighbor) {
        this.name = name;
        this.remote_as = remote_as;
        this.key = key;
        this.neighbor = neighbor;
    }
}
