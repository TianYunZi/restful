package com.restful;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Admin on 2017/6/1.
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    private ConcurrentHashMap<String, MyDomain> map = new ConcurrentHashMap<>();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "获取它！";
    }

    @GET
    @Path("{key}")
    @Produces(MediaType.APPLICATION_XML)
    public MyDomain getMy(@PathParam("key") final String key) {
        final MyDomain domain = map.get("key");
        if (domain == null) {
            return new MyDomain();
        }
        return domain;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void addMy(final MyDomain domain) {
        map.put(domain.getName(), domain);
    }
}
