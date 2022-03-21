package com.maxt.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.maxt.mybatisplus.entity.User;
import com.maxt.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//全表更新
@SpringBootTest
public class QueryWrapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     + SQL：UPDATE user  SET name=?,email=?;
     */
    @Test
    public void testAllUpdate() {
        User user = new User();
        user.setId(999L);
        user.setName("custom_name");
        user.setEmail("xxx@mail.com");
        // com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Prohibition of table update operation
        userMapper.update(user, null);
    }

    /**
     + SQL：UPDATE user  SET name=?, email=? WHERE id = ?;
     */
    @Test
    public void testSomeUpdate() {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(User::getId, 1);
        User user = new User();
        user.setId(10L);
        user.setName("custom_name");
        user.setEmail("xxx@mail.com");
        userMapper.update(user, wrapper);
    }
}


