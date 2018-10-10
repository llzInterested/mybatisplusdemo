package com.llz.mp.service.impl;

import com.llz.mp.entity.User;
import com.llz.mp.mapper.UserMapper;
import com.llz.mp.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author llz
 * @since 2018-10-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
