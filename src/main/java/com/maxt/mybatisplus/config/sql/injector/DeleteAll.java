package com.maxt.mybatisplus.config.sql.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @Author Maxt
 * @Date 2022/3/21 下午4:55
 * @Version 1.0
 * @Description
 */
public class DeleteAll extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        /* 执行SQL，动态SQL参考类 SqlMethod*/
        String sql = "delete from " + tableInfo.getTableName();
        /*mapper接口方法名一致*/
        String method = "deleteAll";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addDeleteMappedStatement(mapperClass, method, sqlSource);
    }
}
