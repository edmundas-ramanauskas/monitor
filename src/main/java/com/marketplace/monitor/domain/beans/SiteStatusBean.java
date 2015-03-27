package com.marketplace.monitor.domain.beans;

/**
 *
 * @author edmundas
 */
public class SiteStatusBean {
    private String url;
    private boolean state;
    private StatusBean status;
    
    public SiteStatusBean(String url, StatusBean status) {
        setUrl(url);
        setStatus(status);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = (url.startsWith("http://")) ? 
                url.substring("http://".length()) : (
                    (url.startsWith("https://")) ? url.substring("https://".length()) : url
                );
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        if(status.getCode() >= 200 && status.getCode() < 300) {
            state = true;
        }
        this.status = status;
    }
    
    public boolean getState() {
        return state;
    }
}