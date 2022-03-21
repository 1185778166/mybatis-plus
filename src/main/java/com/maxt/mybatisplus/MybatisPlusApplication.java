package com.maxt.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author Maxt
 * @Date 2022/3/19 下午7:31
 * @Version 1.0
 * @Description 用户类
 */

@SpringBootApplication
//添加mapper注解，扫描Mapper文件夹
@MapperScan("com.maxt.mybatisplus.mapper")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}
