package com.example.lifesharingappserver.service;

import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifesharingappserver.entity.User;
import com.example.lifesharingappserver.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public List<User> getAllUser() {
        return list();
    }

    public boolean saveUser(User user) {
//        if (user.getUserid() == null) {
//            return save(user);
//        } else {
//            return UpdateById(user);
//        }
        return saveOrUpdate(user);
    }
}
