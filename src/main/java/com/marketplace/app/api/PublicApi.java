package com.marketplace.app.api;

import com.marketplace.app.domain.beans.SiteStatusBean;
import com.marketplace.app.domain.entities.Application;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.data.domain.Page;

/**
 *
 * @author edmundas
 */
@Path("/public")
@Produces("application/json")
public interface PublicApi {
    @GET
    @Path("/applications")
    Page<Application> getApplications(@DefaultValue("1") @QueryParam("page") int page);
    @GET
    @Path("/application/{id}")
    Application getApplication(@PathParam("id") long id);
    @GET
    @Path("/monitor/status")
    SiteStatusBean checkStatus(@QueryParam("url") String url);
}