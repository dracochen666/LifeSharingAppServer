package com.example.lifesharingappserver.service;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifesharingappserver.common.Constants;
import com.example.lifesharingappserver.controller.dto.UserDTO;
import com.example.lifesharingappserver.entity.User;
import com.example.lifesharingappserver.exception.ServiceException;
import com.example.lifesharingappserver.mapper.UserMapper;
import com.example.lifesharingappserver.utils.TokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.rmi.ServerException;
import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    private Log LOG = Log.get();

    @Resource
    UserMapper userMapper;
    public UserDTO login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userDTO.getUserName());
        queryWrapper.eq("user_password", userDTO.getPassword());
        User user;
        try {//捕获数据重复的异常
            user = getOne(queryWrapper);
        } catch (Exception e) {
            LOG.error("数据错误!");
            throw new ServiceException(Constants.CODE_500,"数据错误");
        }
        //若未出现数据重复异常，则进行业务判断
        if (user != null) {
            LOG.info("登录成功");
            BeanUtils.copyProperties(user,userDTO);
            String token = TokenUtil.genToken(user.getUserId().toString(), user.getPassword().toString());
            userDTO.setToken(token);
            System.out.println(token);
            return userDTO;
        }else {
            LOG.info("用户名或密码错误");
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }

    public User register(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userDTO.getUserName());
        User user;
        try {//捕获数据重复的异常
            user = getOne(queryWrapper);
        } catch (Exception e) {
            LOG.error("数据错误!");
            throw new ServiceException(Constants.CODE_500,"数据错误");
        }
        if (user == null) {
            user = new User();
            BeanUtils.copyProperties(userDTO,user);
            save(user);
            return user;
        }else {
            throw new ServiceException(Constants.CODE_600,"用户名已存在");
        }
    }

    public boolean updatePassword(UserDTO userDTO) {
        int update = userMapper.updatePassword(userDTO);
        if(update == 1){
            return true;
        }
        if (update < 1) {
            throw new ServiceException(Constants.CODE_600, "密码错误");
        }
        return false;
    }

}
