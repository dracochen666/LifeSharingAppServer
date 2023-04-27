package com.example.lifesharingappserver.mapper;

import com.example.lifesharingappserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper {

    @Select("Select * from User")
    List<User> findAllUser();
}
