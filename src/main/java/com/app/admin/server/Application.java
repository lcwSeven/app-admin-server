package com.app.admin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liucaiwen
 * @date 2019/03/11
 */
@SpringBootApplication
@ComponentScan("com.app.admin.server")
public class Application {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class,args);
    }
}
