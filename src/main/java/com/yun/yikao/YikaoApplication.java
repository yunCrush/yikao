package com.yun.yikao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author: Crush
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class YikaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(YikaoApplication.class, args);
    }
}
