package com.example.springboot_springsecurity.controller;

import com.example.springboot_springsecurity.entity.UserInfo;
import com.example.springboot_springsecurity.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @date 2020/10/24 - 15:46
 */
@RestController
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/get-user")
    public UserInfo getUser(@RequestParam String username)
    {
        return userInfoService.getUserInfoByUsername(username);
    }
    @PostMapping("/add-user")  //注册用户请求
    public int addUser(@RequestBody UserInfo userInfo){
        return userInfoService.insertUserInfo(userInfo);
    }
}
