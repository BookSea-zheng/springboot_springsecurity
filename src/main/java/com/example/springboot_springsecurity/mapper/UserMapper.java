package com.example.springboot_springsecurity.mapper;

import com.example.springboot_springsecurity.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @date 2020/10/24 - 16:18
 */
@Mapper
@Repository
public interface UserMapper {
    // 插入用户
    @Insert("insert into user(username, password, role) value(#{username}, #{password}, #{role})")
    int insertUserInfo(UserInfo userInfo);
}