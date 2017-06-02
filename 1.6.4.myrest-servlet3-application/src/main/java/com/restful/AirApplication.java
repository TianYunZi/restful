package com.restful;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 2017/6/1.
 */
@ApplicationPath("/webapi/*")
public class AirApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(MyResource.class);
        return classes;
    }
}
