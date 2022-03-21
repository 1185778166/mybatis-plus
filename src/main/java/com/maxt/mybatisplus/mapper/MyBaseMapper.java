package com.maxt.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyBaseMapper<T> extends BaseMapper<T> {
    /**
     * 自定义通用方法
     */
    Integer deleteAll();

    int myInsertAll(T t);

    /**
     * 如果要自动填充 @{@code Param}(xx) xx参数名必须是list/collection/array 3个中的一个
     * @param list
     * @return
     */
    int mysqlInsertAllBatch(@Param("list")List<T> list);
}
