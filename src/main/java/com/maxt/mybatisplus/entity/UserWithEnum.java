package com.maxt.mybatisplus.entity;

import com.maxt.mybatisplus.enums.AgeEnum;
import com.maxt.mybatisplus.enums.GradeEnum;
import lombok.Data;

/**
 * @Author Maxt
 * @Date 2022/3/21 上午11:22
 * @Version 1.0
 * @Description
 */
@Data
public class UserWithEnum {
    /**
     * 名字
     * 数据库字段：name
     */
    private String name;
    /**
     * 年龄，IEnum接口的枚举处理
     * 数据库字段：age
     */
    private AgeEnum age;
    /**
     * 年级，原生枚举(带{@link com.baomidou.mybatisplus.annotation.EnumValue})
     * 数据库字段：grade
     */
    private GradeEnum grade;
}
