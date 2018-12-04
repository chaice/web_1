package com.ccit.bean;

import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

public class PresetBean {

    private String cidr;

    private CopyOnWriteArraySet<String> masterExitSet;

    private LinkedList<String> backupExitList;

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public CopyOnWriteArraySet<String> getMasterExitSet() {
        return masterExitSet;
    }

    public void setMasterExitSet(CopyOnWriteArraySet<String> masterExitSet) {
        this.masterExitSet = masterExitSet;
    }

    public LinkedList<String> getBackupExitList() {
        return backupExitList;
    }

    public void setBackupExitList(LinkedList<String> backupExitList) {
        this.backupExitList = backupExitList;
    }

    @Override
    public String toString() {
        return "PresetBean{" +
                "cidr='" + cidr + '\'' +
                ", masterExitSet=" + masterExitSet +
                ", backupExitList=" + backupExitList +
                '}';
    }
}
