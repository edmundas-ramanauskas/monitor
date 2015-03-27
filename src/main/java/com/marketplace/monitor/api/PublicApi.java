package com.marketplace.monitor.api;

import com.marketplace.monitor.domain.beans.SiteStatusBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author edmundas
 */
@Path("/public")
@Produces("application/json")
public interface PublicApi {
    @GET
    @Path("/monitor/status")
    SiteStatusBean checkStatus(@QueryParam("url") String url);
}