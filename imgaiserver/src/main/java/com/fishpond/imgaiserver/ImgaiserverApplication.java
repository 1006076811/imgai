package com.fishpond.imgaiserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fishpond.imgaiserver.mapper")
public class ImgaiserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImgaiserverApplication.class, args);
    }

}
