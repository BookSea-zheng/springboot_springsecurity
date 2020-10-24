package com.example.springboot_springsecurity.service;

import com.example.springboot_springsecurity.entity.UserInfo;
import com.example.springboot_springsecurity.mapper.UserInfoMapper;
import com.example.springboot_springsecurity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @date 2020/10/24 - 15:54
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserInfo getUserInfoByUsername(String username){

        return userInfoMapper.getUserInfoByUsername(username);
    }
    public int insertUserInfo(UserInfo userInfo){
        // 加密密码
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return userMapper.insertUserInfo(userInfo);
    }
}