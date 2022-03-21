/*
package com.maxt.mybatisplus.test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

*/
/**
 * @Author Maxt
 * @Date 2022/3/20 下午4:13
 * @Version 1.0
 * @Description
 *//*

@SpringBootTest
public class CodeGeneratorTest {

    @Test
    public void testCodeGenerator(){
        //代码生成器
        new AutoGenerator(
                new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/mybatis-plus", "root", "root1234")
                        .build())
                //全局配置
        .global(new GlobalConfig.Builder()
                //作者
                .author("Maxt")
                //输出位置
                .outputDir("generator")
                //打开文件
                .openDir(false)
                //开启swagger模式
                .enableSwagger()
                .build())
        //包配置
        .packageInfo(new PackageConfig.Builder()
                //父模块名称
                .moduleName("system")
                //父包名
                .parent("com.maxt.mybatisplus")
                .build()
        )
        //自定义配置
        //.injection(new InjectionConfig())
        //模板引擎
        .template(new TemplateConfig.Builder()
                //指定自定义模板路径，会根据使用的模板引擎自动识别
                .entity("")
                .controller("")
                .service("", "")
                .mapper("")
                .build()
        )
        //策略配置
        .strategy(new StrategyConfig.Builder()
                //设置需要生成对表名
                .addInclude("")
                .addFieldPrefix("")
                //设置过滤表前缀
                .addTablePrefix("")
                .build()
        ).execute();
    }
}
*/
