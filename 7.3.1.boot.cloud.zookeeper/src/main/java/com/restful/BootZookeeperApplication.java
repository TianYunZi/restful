package com.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Admin on 2017/6/5.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BootZookeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootZookeeperApplication.class, args);
    }
}
