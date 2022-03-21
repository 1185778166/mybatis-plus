package com.maxt.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.javers.core.metamodel.annotation.PropertyName;

import java.time.LocalDateTime;

/**
 * @Author Maxt
 * @Date 2022/3/19 下午7:31
 * @Version 1.0
 * @Description 用户类
 */
//set、get方法
@Data
//所有参数构造函数
@AllArgsConstructor
//无参构造函数
@NoArgsConstructor
@TableName("user")
@Accessors(chain = true)
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("name")
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private Integer deleted;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
