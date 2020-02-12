package com.laoxing.chip.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: Chip_Parent
 * @description:
 * @author: Feri
 * @create: 2020-02-12 11:35
 */
@SpringBootApplication
@MapperScan("com.laoxing.chip.provider.dao") //扫描持久层
@EnableDubbo //扫描要发布的服务
public class CardProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CardProviderApplication.class,args);
    }
}
