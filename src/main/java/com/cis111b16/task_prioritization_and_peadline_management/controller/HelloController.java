package com.cis111b16.task_prioritization_and_peadline_management.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * The type Hello controller.
 */
@RestController
//@ConfigurationProperties(prefix = "database")
public class HelloController {
//    @Value("${database.url}")
    private  String dataBaseUrl;

    /**
     * Hello string.
     *
     * @return the string
     */
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    /**
     * Index string.
     *
     * @return the string
     */
    @RequestMapping("/")
    public String index() {
        return "Hello World 20202020202"+dataBaseUrl;
    }
}
