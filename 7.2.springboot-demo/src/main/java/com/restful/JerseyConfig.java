package com.restful;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 2017/6/5.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(DemoResource.class);
        register(CorsFilter.class);
    }
}
