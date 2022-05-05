package com.lz.service;

import com.lz.entity.User;

import java.util.List;

public interface UserService {
    List<User> login(String loginname, String pwd);
}
