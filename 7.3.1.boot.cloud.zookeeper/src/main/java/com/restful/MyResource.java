package com.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Admin on 2017/6/5.
 */
@Component
@Path("/")
public class MyResource {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring.application.name:bootZookeeper}")
    private String appName;

    @Path("hi")
    @GET
    public String hi() {
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        return localServiceInstance.getHost() + " : " + localServiceInstance.getPort();
    }

    @Path("hi2")
    @GET
    public String hi2() {
        List<ServiceInstance> service = getService();
        final StringBuilder builder = new StringBuilder("      ");
        service.forEach(s -> {
            builder.append("server ").append(s.getHost()).append(" : ").append(s.getPort()).append(";");
        });
        return builder.toString();
    }

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ServiceInstance> getService() {
        return discoveryClient.getInstances(appName);
    }
}
