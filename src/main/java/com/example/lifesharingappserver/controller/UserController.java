package com.example.lifesharingappserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lifesharingappserver.entity.User;
import com.example.lifesharingappserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.list();
    }

    @PostMapping("/saveUser")
    public boolean saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageSize,
                                @RequestParam Integer pageNum
                                ) {
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        return userService.page(page, queryWrapper);
    }
}
