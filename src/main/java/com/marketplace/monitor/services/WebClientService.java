package com.marketplace.monitor.services;

import com.marketplace.monitor.domain.beans.StatusBean;

/**
 *
 * @author edmundas
 */
public interface WebClientService {

    StatusBean getSiteStatus(String url);
}
