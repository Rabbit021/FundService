package com.rabbit.fundservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author wangheng
 */
@SpringBootApplication
public class FundServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundServiceApplication.class, args);
    }

}
