package com.maxt.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum GradeEnum {
    PRIMARY(1, "小学"),
    SECONDORY(2, "中学"),
    HIGH(3, "高中");

    GradeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    @EnumValue
    private int code;
    private String desc;
}
