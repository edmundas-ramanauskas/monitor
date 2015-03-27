package com.marketplace.monitor.api.impl;

import com.marketplace.monitor.api.PublicApi;
import com.marketplace.monitor.domain.beans.SiteStatusBean;
import com.marketplace.monitor.domain.beans.StatusBean;
import com.marketplace.monitor.services.WebClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

/**
 *
 * @author edmundas
 */
public class PublicApiImpl implements PublicApi {
    
    private static final Logger logger = LoggerFactory.getLogger(PublicApiImpl.class);
    
    private WebClientService webClientService;
    
    @Override
    public SiteStatusBean checkStatus(String url) {
        url = url.trim();
        StatusBean status = webClientService.getSiteStatus(formatUrl(url));
        return new SiteStatusBean(url, status);
    }
    
    private String formatUrl(String url) {
        return (url.startsWith("http://") || url.startsWith("https://")) ? url : "http://"+url;
    }
    
    public void setWebClientService(WebClientService webClientService) {
        this.webClientService = webClientService;
    }
}