package com.llz.mp.mapper;

import com.llz.mp.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author llz
 * @since 2018-10-10
 */
public interface UserMapper extends BaseMapper<User> {
    int deleteAll();
}
