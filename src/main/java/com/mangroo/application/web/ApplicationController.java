package com.mangroo.application.web;

import com.mangroo.application.ApplicationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationConfiguration config;

    private Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @RequestMapping(method={RequestMethod.GET},value={"/version"})
    public String getVersion() {
        logger.info("Application: {}", config.getName());
        return "1.0";
    }

}