package com.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/6/5.
 */
@Path("hi")
public class DemoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> hi() {
        List<String> result = new ArrayList<>();
        result.add("hello spring boot");
        result.add("hello micro services");
        return result;
    }
}
