package com.maxt.mybatisplus.test;

import com.maxt.mybatisplus.config.RequestDataHelper;
import com.maxt.mybatisplus.entity.User;
import com.maxt.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * @Author Maxt
 * @Date 2022/3/21 下午11:09
 * @Version 1.0
 * @Description
 */
@SpringBootTest
class DynamicTableNameTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void test() {
        RequestDataHelper.setRequestData(new HashMap<String, Object>() {{
            put("id", 123);
            put("hello", "tomcat");
            put("name", "汤姆凯特");
        }});
        // 自己去观察打印 SQL 目前随机访问 user_2018  user_2019 表
        for (int i = 0; i < 6; i++) {
            User user = userMapper.selectById(1);
            System.err.println(user.getName());
        }
    }
}
