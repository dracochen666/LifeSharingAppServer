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
import com.example.lifesharingappserver.utils.TokenUtil;
import org.springframework.beans.BeanUtils;
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
//        User user = TokenUtil.getCurrentUser();
//        if (user == null)  {
//            System.out.println("user为空");
//        }else  {
//            System.out.println(user);
//        }
        if (userDTO.getUserName() == "" || userDTO.getPassword() == "" ) {
            LOG.info("用户实体为空");
            return Result.error(Constants.CODE_400,"登录用户实体为空");
        }else {
            userDTO = userService.login(userDTO);//若login服务返回userDTO则返回成功结果
            return Result.success(userDTO);
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO) {
        if (userDTO.getUserName() == "" || userDTO.getPassword() == "" ) {
            return Result.error(Constants.CODE_400,"注册用户实体为空");
        }else {
            return Result.success(userService.register(userDTO)); //返回注册服务结果
        }
    }
    @GetMapping("/getCurrentUser")
    public Result getCurrentUser(){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(TokenUtil.getCurrentUser(), userDTO);
//        System.out.println(userDTO);
        return Result.success(userDTO);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.list();
    }

    @PostMapping("/saveUser")
    public boolean saveUser(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }
    // 新增或者更新
    @PostMapping("/password")
    public Result password(@RequestBody UserDTO userDTO) {
//        boolean updateResult =
        return Result.success(userService.updatePassword(userDTO));
    }
    @DeleteMapping("/delete")
    public boolean deleteNoteById(@RequestParam Integer userId) {
        return userService.removeById(userId);
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
