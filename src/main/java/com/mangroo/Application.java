package com.mangroo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        final SpringApplication springApplication =
                new SpringApplication(Application.class);
        // it is being added here for LOCAL run ONLY , spring profiles should be be run time parameters when run spring boot jar
        springApplication.setDefaultProperties(Collections.singletonMap("spring.profiles.default","LOCAL"));
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }

}
