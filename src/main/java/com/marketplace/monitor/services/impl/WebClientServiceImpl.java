package com.marketplace.monitor.services.impl;

import com.marketplace.monitor.domain.beans.StatusBean;
import com.marketplace.monitor.services.WebClientService;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author edmundas
 */
public class WebClientServiceImpl implements WebClientService {
    
    private static final int MILI = 1000;
    
    private static final Logger logger = LoggerFactory.getLogger(WebClientServiceImpl.class);

    @Override
    public StatusBean getSiteStatus(final String url) {
        
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(15 * MILI).build();
        CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
        
        long start = System.currentTimeMillis();
        float time = 0;
        try {
            HttpHead httpHead = new HttpHead(url);

            ResponseHandler<StatusBean> responseHandler = new ResponseHandler<StatusBean>() {

                public StatusBean handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int code = response.getStatusLine().getStatusCode();
                    String text = response.getStatusLine().getReasonPhrase();
                    return new StatusBean(code, text, 0);
                }

            };
            StatusBean status = httpclient.execute(httpHead, responseHandler);
            time = System.currentTimeMillis() - start;
            status.setTime(time/MILI);
            return status;
        } catch (IOException ex) {
            logger.error("Can't connect to remote resource", ex);
        } finally {
            try {
                httpclient.close();
            } catch (IOException ex) {
                // ignore
            }
        }
        time = System.currentTimeMillis() - start;
        return new StatusBean(0, "DOWN", time/MILI);
    }
}