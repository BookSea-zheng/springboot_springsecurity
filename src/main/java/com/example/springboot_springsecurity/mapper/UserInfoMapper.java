package com.example.springboot_springsecurity.mapper;

import com.example.springboot_springsecurity.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @date 2020/10/24 - 13:46
 */
@Mapper
public interface UserInfoMapper {
    @Select("select * from user where username = #{username}")
     UserInfo getUserInfoByUsername(String username);
}