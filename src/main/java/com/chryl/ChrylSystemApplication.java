package com.chryl;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.chryl"})
@MapperScan("com.chryl.mapper")
public class ChrylSystemApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ChrylSystemApplication.class, args);
        log.info("==============已启动=================");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        System.out.println("aa");

        return builder.sources(this.getClass());
    }
}
