package com.maxt.mybatisplus.test;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Maxt
 * @Date 2022/3/20 下午3:23
 * @Version 1.0
 * @Description  代码快速生成与代码交互式生成测试
 */

@SpringBootTest
public class FastAutoGeneratorTest {

    /**
     *快速生成
     */

    @Test
    public void testFastGenerator(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis-plus", "root", "root1234")
                .globalConfig(builder -> {
                            //设置作者
                    builder.author("Maxt")
                            //开启swagger模式
                            .enableSwagger()
                            //覆盖已生成文件
                            .fileOverride()
                            //指定输出目录
                            .outputDir("generator");
                })
                .packageConfig(builder -> {
                            //设置父包名
                     builder.parent("com.maxt.mybatisplus.samples.generator")
                             //设置父包模块名
                             .moduleName("system")
                             //设置mapperXml生成路径
                             .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "generator"));
                })
                .strategyConfig(builder -> {
                            //设置需要生成对表名
                    builder.addInclude("user");
                            //设置过滤表前缀
                            //.addTablePrefix("t_", "c_");
                })
                //使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    /**
     * 交互式生成
     */

    @Test
    public void testScannerGenerator(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis-plus", "root", "root1234")
                .globalConfig((scanner, builder) ->
                        builder.author(scanner.apply("请输入作者名称？"))
                        .fileOverride()
                )
                .packageConfig((scanner, builder) ->
                        builder.parent(scanner.apply("请输入包名？"))
                )
                .strategyConfig((scanner, builder) ->
                        builder.addInclude(getTables(scanner.apply("请输入表名，多个表用英文逗号分割，所有表输入all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).build()
                )
                //模板引擎配置，默认Velocity 可选模板引擎Beetl或Freemarker
                //.templateEngine(new BeetlTemplateEngine())
                //.templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    private List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
