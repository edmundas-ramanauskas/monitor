package com.marketplace.app.api.impl;

import com.marketplace.app.api.PublicApi;
import com.marketplace.app.domain.beans.SiteStatusBean;
import com.marketplace.app.domain.beans.StatusBean;
import com.marketplace.app.domain.entities.Application;
import com.marketplace.app.services.ApplicationService;
import com.marketplace.app.services.WebClientService;
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
    
    private ApplicationService applicationService;

    @Override
    public Page<Application> getApplications(int page) {
        return applicationService.getApplications(page);
    }
    
    @Override
    public Application getApplication(long id) {
        return applicationService.getApplication(id);
    }
    
    @Override
    public SiteStatusBean checkStatus(String url) {
        url = url.trim();
        StatusBean status = webClientService.getSiteStatus(formatUrl(url));
        return new SiteStatusBean(url, status);
    }
    
    private String formatUrl(String url) {
        return (url.startsWith("http://") || url.startsWith("https://")) ? url : "http://"+url;
    }
    
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    
    public void setWebClientService(WebClientService webClientService) {
        this.webClientService = webClientService;
    }
}