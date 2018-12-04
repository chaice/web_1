package com.ccit.configuration;

import java.io.Serializable;
import java.util.List;

public class VlanIP implements Serializable {

    private String ip;

    private String netmask;

    private boolean enable_dhcp;

    private String dhcp_start_ip;

    private String dhcp_end_ip;

    private String dhcp_lease;

    private String dhcp_dns1;

    private String dhcp_dns2;

    private String tftp;

    private String domain_name;

    private String dhcp_mode;
    private String remote_server;

    private List<VlanIpDhcpBinding> vlan_ip_binding;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public boolean isEnable_dhcp() {
        return enable_dhcp;
    }

    public void setEnable_dhcp(boolean enable_dhcp) {
        this.enable_dhcp = enable_dhcp;
    }

    public String getDhcp_start_ip() {
        return dhcp_start_ip;
    }

    public void setDhcp_start_ip(String dhcp_start_ip) {
        this.dhcp_start_ip = dhcp_start_ip;
    }

    public String getDhcp_end_ip() {
        return dhcp_end_ip;
    }

    public void setDhcp_end_ip(String dhcp_end_ip) {
        this.dhcp_end_ip = dhcp_end_ip;
    }

    public String getDhcp_lease() {
        return dhcp_lease;
    }

    public void setDhcp_lease(String dhcp_lease) {
        this.dhcp_lease = dhcp_lease;
    }

    public String getDhcp_dns1() {
        return dhcp_dns1;
    }

    public void setDhcp_dns1(String dhcp_dns1) {
        this.dhcp_dns1 = dhcp_dns1;
    }

    public String getDhcp_dns2() {
        return dhcp_dns2;
    }

    public void setDhcp_dns2(String dhcp_dns2) {
        this.dhcp_dns2 = dhcp_dns2;
    }

    public String getTftp() {
        return tftp;
    }

    public void setTftp(String tftp) {
        this.tftp = tftp;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public List<VlanIpDhcpBinding> getVlan_ip_binding() {
        return vlan_ip_binding;
    }

    public void setVlan_ip_binding(List<VlanIpDhcpBinding> vlan_ip_binding) {
        this.vlan_ip_binding = vlan_ip_binding;
    }

    public String getDhcp_mode() {
        return dhcp_mode;
    }

    public void setDhcp_mode(String dhcp_mode) {
        this.dhcp_mode = dhcp_mode;
    }

    public String getRemote_server() {
        return remote_server;
    }

    public void setRemote_server(String remote_server) {
        this.remote_server = remote_server;
    }

    public VlanIP(String ip, String netmask, boolean enable_dhcp, String dhcp_start_ip, String dhcp_end_ip, String dhcp_lease,
                  String dhcp_dns1, String dhcp_dns2, String tftp, String domain_name, String dhcp_mode, String remote_server) {
        this.ip = ip;
        this.netmask = netmask;
        this.enable_dhcp = enable_dhcp;
        this.dhcp_start_ip = dhcp_start_ip;
        this.dhcp_end_ip = dhcp_end_ip;
        this.dhcp_lease = dhcp_lease;
        this.dhcp_dns1 = dhcp_dns1;
        this.dhcp_dns2 = dhcp_dns2;
        this.tftp = tftp;
        this.domain_name = domain_name;
        this.dhcp_mode = dhcp_mode;
        this.remote_server = remote_server;
    }

    public VlanIP() {
    }

}
