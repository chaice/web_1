package com.ccit.utils;


public enum AgencyRole {

    WHOLESALER("wholesaler"),

    RETAILER("retailer");

    private String name;

    AgencyRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
