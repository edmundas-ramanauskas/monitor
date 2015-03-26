package com.marketplace.app.services;

import com.marketplace.app.domain.entities.Application;
import org.springframework.data.domain.Page;

/**
 *
 * @author edmundas
 */
public interface ApplicationService {
    Page<Application> getApplications(int page);
    Application getApplication(long id);
}