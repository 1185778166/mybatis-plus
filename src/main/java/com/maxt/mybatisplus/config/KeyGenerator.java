package com.maxt.mybatisplus.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Maxt
 * @Date 2022/3/20 下午8:36
 * @Version 1.0
 * @Description
 */
/*@Component
public class KeyGenerator {
    @Bean
    public IKeyGenerator keyGenerator(){
        return new H2KeyGenerator();
    }

    @Bean
    public MybatisPlusPropertiesCustomizer plusPropertiesCustomizer(){
        List<IKeyGenerator> objects = new ArrayList<>();
        objects.add(new H2KeyGenerator());
        return properties -> properties.getGlobalConfig().getDbConfig().setKeyGenerators(objects);
    }
}*/
