package com.restful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by Admin on 2017/6/5.
 */
@Provider
@PreMatching
public class CorsFilter implements ContainerResponseFilter {

    private static final Log LOGGER = LogFactory.getLog(CorsFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().add("Access-Control-Allow-Headers",
                "X-HTTP-Method-Override, Content-Type, x-requested-with");
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET");
        LOGGER.debug(responseContext.getHeaders().get("Access-Control-Allow-Origin"));
    }
}
