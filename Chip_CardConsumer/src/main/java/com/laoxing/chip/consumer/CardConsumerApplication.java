package com.laoxing.chip.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: Chip_Parent
 * @description:
 * @author: Feri
 * @create: 2020-02-12 14:05
 */
@SpringBootApplication
@EnableSwagger2 //启用Swagger
public class CardConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CardConsumerApplication.class,args);
    }
}
