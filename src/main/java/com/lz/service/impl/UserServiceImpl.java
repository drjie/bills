package com.lz.service.impl;

import com.lz.dao.UserMapper;
import com.lz.entity.User;
import com.lz.entity.UserExample;
import com.lz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> login(String loginname, String pwd) {
        UserExample tbUserExample = new UserExample();

        UserExample.Criteria criteria = tbUserExample.createCriteria();

        criteria.andLoginnameEqualTo(loginname);
        criteria.andPwdEqualTo(pwd);

        List<User> users = userMapper.selectByExample(tbUserExample);

        return users;
    }
}
