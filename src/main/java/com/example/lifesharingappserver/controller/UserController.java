package com.example.lifesharingappserver.controller;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lifesharingappserver.common.Constants;
import com.example.lifesharingappserver.common.Result;
import com.example.lifesharingappserver.controller.dto.UserDTO;
import com.example.lifesharingappserver.entity.User;
import com.example.lifesharingappserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    private Log LOG = Log.get();

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        if (userDTO.getUserName() == null || userDTO.getPassword() == null ) {
//            LOG.info("传输实体为空");
            return Result.error(Constants.CODE_400,"传输实体为空");
        }else {
            LOG.info("传输实体不为空");
            return Result.success();
//            return userService.login(userDTO);
        }
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.list();
    }

    @PostMapping("/saveUser")
    public boolean saveUser(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize
                                ) {
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        return userService.page(page, queryWrapper);
    }
}
