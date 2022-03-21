package com.maxt.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maxt.mybatisplus.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author Maxt
 * @Date 2022/3/19 下午7:41
 * @Version 1.0
 * @Description
 */
@Repository
public interface UserMapper extends MyBaseMapper<User> {
}
