package com.example.lifesharingappserver.service;

import com.example.lifesharingappserver.entity.User;
import com.example.lifesharingappserver.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.findAllUser();
    }

}
