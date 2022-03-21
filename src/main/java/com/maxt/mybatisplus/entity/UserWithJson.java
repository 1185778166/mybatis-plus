package com.maxt.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Maxt
 * @Date 2022/3/21 下午2:18
 * @Version 1.0
 * @Description
 */
@Data
@Accessors(chain = true)
//@TableName(value = "user", autoResultMap = true)
public class UserWithJson {
    private Long id;

    /**
     * 注意：必须开启映射注解
     * @TableName(autoResultMap=true)
     * 以下两种类型处理器，二选一 也可以同时存在
     * 注意：选择对应的JSON解析依赖包
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    //@TableField(typeHandler = FastjsonTypeHandler.class)
    private OtherInfo otherInfo;
}
