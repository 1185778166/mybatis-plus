package com.maxt.mybatisplus.config.sql.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;

import java.util.List;

/**
 * @Author Maxt
 * @Date 2022/3/21 下午4:50
 * @Version 1.0
 * @Description
 */
public class MyLogicSqlInjector extends DefaultSqlInjector {

    /**
     * 如果只需要增加方法，保留MP自带方法
     * 可以使用super.getMethodList()再add
     * @return
     */
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        methodList.add(new DeleteAll());
        methodList.add(new MyInsertAll());
        methodList.add(new MysqlInsertAllBatch());
        return methodList;
    }
}
