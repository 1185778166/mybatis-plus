package com.maxt.mybatisplus.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maxt.mybatisplus.entity.User;
import com.maxt.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Maxt
 * @Date 2022/3/19 下午7:43
 * @Version 1.0
 * @Description  用户测试类
 */
@SpringBootTest
public class UserTest {
    @Autowired
    UserMapper userMapper;

    /**
     * 查询所有
     */
    @Test
    public void testSelectAll(){
        System.out.println("selectAll method test");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 插入操作
     * 插入时根据主键策略来判断时候需要插入主键值，
     * 默认为ASSIGN_ID(分布式ID，根据雪花算法生成)
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("Lucy");
        user.setAge(20);
        user.setEmail("1234@163.com");
        //insert为插入数据影响的数据行数
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    /**
     * 根据id更新操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1L);
        user.setName("LucyUpdateTime");
        user.setAge(20);
        user.setEmail("1234@163.com");
        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    /**
     * 根据id删除操作
     */
    @Test
    public void testDelete(){
        User user = new User();
        user.setId(1505230152404123650L);
        int count = userMapper.deleteById(user);
        System.out.println(count);
    }

    /**
     * 逻辑删除测试
     */
    @Test
    public void testLogicDelete(){
        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }

    /**
     * 测试分页
     */
    @Test
    public void testSelectByPage(){
        Page<User> page = new Page(1, 3);
        Page<User> userPage = userMapper.selectPage(page, null);
        ////总页数
        long pages = userPage.getPages();
        //当前页
        long current = userPage.getCurrent();
        //查询数据集合
        List<User> records = userPage.getRecords();
        //总记录数
        long total = userPage.getTotal();
        //下一页
        boolean hasNext = userPage.hasNext();
        //上一页
        boolean hasPrevious = userPage.hasPrevious();
        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);
    }
}
