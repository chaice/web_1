package com.ccit.bean;

import java.util.List;

public class PresetReq {

    private String cidr;

    private List<String> masterExitSet;

    private List<String> backupExitList;

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public List<String> getMasterExitSet() {
        return masterExitSet;
    }

    public void setMasterExitSet(List<String> masterExitSet) {
        this.masterExitSet = masterExitSet;
    }

    public List<String> getBackupExitList() {
        return backupExitList;
    }

    public void setBackupExitList(List<String> backupExitList) {
        this.backupExitList = backupExitList;
    }
}
