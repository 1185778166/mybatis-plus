package com.maxt.mybatisplus.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author Maxt
 * @Date 2022/3/20 下午8:51
 * @Version 1.0
 * @Description
 */
/*
@Component
public class CustomerIdGenerator implements IdentifierGenerator {
    @Override
    public Number nextId(Object entity) {
        //可以将当前传入的class全类名来作为bizKey，或者提取参数来生成bizKey进行分布式Id调用生成
        String bizKey = entity.getClass().getName();
        //根据bizKey调用分布式ID生成
        long id = 0L;
        return id;
    }

    @Bean
    public IdentifierGenerator identifierGenerator(){
        return new CustomerIdGenerator();
    }

    @Bean
    public MybatisPlusPropertiesCustomizer plusPropertiesCustomizer(){
        return properties -> properties.getGlobalConfig().setIdentifierGenerator(new CustomerIdGenerator());
    }
}
*/
