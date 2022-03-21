package com.maxt.mybatisplus.config.sql.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @Author Maxt
 * @Date 2022/3/21 下午5:03
 * @Version 1.0
 * @Description
 */
@Slf4j
public class MyInsertAll extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = "insert into %s %s values %s";
        StringBuffer fieldSql = new StringBuffer();
        fieldSql.append(tableInfo.getKeyColumn()).append(",");
        StringBuffer valueSql = new StringBuffer();
        valueSql.append("#{").append(tableInfo.getKeyProperty()).append("},");
        tableInfo.getFieldList().forEach(x ->{
            fieldSql.append(x.getColumn()).append(",");
            valueSql.append("#{").append(x.getProperty()).append("},");
        });
        fieldSql.delete(fieldSql.length()-1, fieldSql.length());
        fieldSql.insert(0, "(");
        fieldSql.append(")");
        valueSql.insert(0, "(");
        valueSql.delete(valueSql.length()-1, valueSql.length());
        valueSql.append(")");
        log.info("fieldSql:"+fieldSql.toString());
        log.info("valueSql:"+valueSql.toString());
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(sql, tableInfo.getTableName(), fieldSql.toString(), valueSql.toString()), modelClass);
        return this.addInsertMappedStatement(mapperClass, modelClass, "myInsertAll", sqlSource, new NoKeyGenerator(), null, null);
    }
}
