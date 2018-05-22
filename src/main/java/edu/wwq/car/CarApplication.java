package edu.wwq.car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"edu.wwq.car"}) // 指定spring管理的bean所在的包
@MapperScan("edu.wwq.car.mapper") // 指定mybatis的mapper接口所在的包
public class CarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }
}
