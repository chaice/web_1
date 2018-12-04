package com.ccit.configuration;

import java.io.Serializable;

public class URLIntercept implements Serializable {

    private String src_cidr;

    private String url_keyword;

    public String getSrc_cidr() {
        return src_cidr;
    }

    public void setSrc_cidr(String src_cidr) {
        this.src_cidr = src_cidr;
    }

    public String getUrl_keyword() {
        return url_keyword;
    }

    public void setUrl_keyword(String url_keyword) {
        this.url_keyword = url_keyword;
    }

    public URLIntercept() {
    }

    public URLIntercept(String src_cidr, String url_keyword) {
        this.src_cidr = src_cidr;
        this.url_keyword = url_keyword;
    }
}
