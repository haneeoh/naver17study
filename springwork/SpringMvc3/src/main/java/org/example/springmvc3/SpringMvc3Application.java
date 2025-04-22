package org.example.springmvc3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"data.*","*.controller","org.example.springmvc3","naver.storage","naver.aiservice"})
@MapperScan({"data.mapper"})
public class SpringMvc3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvc3Application.class, args);
    }

}
