package com.restful;

import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by Admin on 2017/6/1.
 */
@WebServlet(
        initParams = @WebInitParam(name = "jersey.config.server.provider.packages", value = "com.restful"),
        urlPatterns = "/webapi/*",
        loadOnStartup = 1
)
public class AirServlet extends ServletContainer {
    private static final long serialVersionUID = 1L;
}
