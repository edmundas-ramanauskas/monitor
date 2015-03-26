package com.marketplace.app.services;

import com.marketplace.app.domain.beans.StatusBean;

/**
 *
 * @author edmundas
 */
public interface WebClientService {

    StatusBean getSiteStatus(String url);
}
