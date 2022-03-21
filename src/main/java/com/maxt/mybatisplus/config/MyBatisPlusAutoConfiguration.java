package com.maxt.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.handlers.MybatisEnumTypeHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.*;
import com.maxt.mybatisplus.config.sql.injector.MyLogicSqlInjector;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Random;

/**
 * @Author Maxt
 * @Date 2022/3/21 上午11:37
 * @Version 1.0
 * @Description
 */
@Configuration
public class MyBatisPlusAutoConfiguration {

    /**
     * 新的分页插件，一缓和二缓遵循mybatis的规则，需要设置MybatisConfiguration#useDeprecatedExecutor = false
     * 避免缓存出现问题，(该属性会在旧插件移除后一同移除)
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //多租户
        /*interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new TenantLineHandler() {
            @Override
            public Expression getTenantId() {
                return new LongValue();
            }
            //这是default方法，默认返回false表示所有表都需要拼多租户条件
            @Override
            public boolean ignoreTable(String tableName) {
                return !"user".equalsIgnoreCase(tableName);
            }
        }));*/
        //如果使用了分页插件，必须先add租户插件在add分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //乐观锁
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
        dynamicTableNameInnerInterceptor.setTableNameHandler((sql, tableName) -> {
            // 获取参数方法
            Map<String, Object> paramMap = RequestDataHelper.getRequestData();
            paramMap.forEach((k, v) -> System.err.println(k + "----" + v));

            String year = "_2018";
            int random = new Random().nextInt(10);
            if (random % 2 == 1) {
                year = "_2019";
            }
            return tableName + year;
        });
        interceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);
        return interceptor;
    }

    @Bean
    public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer(){
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultEnumTypeHandler(MybatisEnumTypeHandler.class);
        return properties -> properties.setConfiguration(configuration).getGlobalConfig().setBanner(false);
    }
    @Bean
    public MyLogicSqlInjector myLogicSqlInjector(){
        return new MyLogicSqlInjector();
    }
}
