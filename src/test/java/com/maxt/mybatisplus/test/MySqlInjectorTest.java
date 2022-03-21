package com.maxt.mybatisplus.test;

import com.maxt.mybatisplus.entity.User;
import com.maxt.mybatisplus.mapper.MyBaseMapper;
import com.maxt.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Maxt
 * @Date 2022/3/21 下午5:40
 * @Version 1.0
 * @Description
 */
@SpringBootTest
public class MySqlInjectorTest {

    @Autowired
    UserMapper userMapper;

    /**
     * 删除所有
     */
    @Test
    public void testDeleteAll(){
        userMapper.deleteAll();
    }

    /**
     * 批量插入所有
     */
    @Test
    public void testInsertAllBatch(){
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setId(100L);
        user1.setName("aa");
        user1.setAge(20);
        user1.setEmail("11@qq.com");
        list.add(user1);
        User user2 = new User();
        user1.setId(101L);
        user1.setName("bb");
        user1.setAge(20);
        user1.setEmail("22@qq.com");
        list.add(user2);
        int count = userMapper.mysqlInsertAllBatch(list);
        System.out.println(count);
    }

    @Test
    void myInsertAll() {
        long id = 1008888L;
        User user = new User();
        user.setId(id);
        user.setName("aa");
        user.setAge(20);
        user.setEmail("11@qq.com");
        int count = userMapper.myInsertAll(user);
        System.out.println(count);
    }
}
