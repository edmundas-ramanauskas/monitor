package com.marketplace.app.services.impl;

import com.marketplace.app.domain.entities.Application;
import com.marketplace.app.domain.repositories.ApplicationRepository;
import com.marketplace.app.services.ApplicationService;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author edmundas
 */
public class ApplicationServiceImpl implements ApplicationService {
    
    @Resource
    private ApplicationRepository applicationRepository;
    
    @Override
    public Page<Application> getApplications(int page) {
        return applicationRepository.findAll(new PageRequest(page-1, 10));
    }
    
    @Override
    public Application getApplication(long id) {
        return applicationRepository.findOne(id);
    }
}