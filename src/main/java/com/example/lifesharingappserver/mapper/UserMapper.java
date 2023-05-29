package com.example.lifesharingappserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lifesharingappserver.controller.dto.UserDTO;
import com.example.lifesharingappserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {

    @Update("update User set user_password = #{newPassword} where user_name = #{userName} and user_password = #{password}")
    int updatePassword(UserDTO userDTO);

    @Select("Select * from User")
    List<User> findAllUser();
}
