package com.ccit.configuration;

import java.io.Serializable;
import java.util.List;

public class Wan implements Serializable {

    private String name;

    private List<WanPolicy> policy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WanPolicy> getPolicy() {
        return policy;
    }

    public void setPolicy(List<WanPolicy> policy) {
        this.policy = policy;
    }

    public Wan() {
    }

    public Wan(String name, List<WanPolicy> policy) {
        this.name = name;
        this.policy = policy;
    }
}
