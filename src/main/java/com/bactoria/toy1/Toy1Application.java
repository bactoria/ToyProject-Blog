package com.bactoria.toy1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Toy1Application {

    //local
/*

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Toy1Application.class,args);
    }
*/

    //ec2d

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "/home/ec2-user/app/config/myBlog/real-application.yml";


    public static void main(String[] args) {
        new SpringApplicationBuilder(Toy1Application.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}