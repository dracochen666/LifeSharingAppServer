package com.example.lifesharingappserver.service;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifesharingappserver.common.Constants;
import com.example.lifesharingappserver.controller.dto.UserDTO;
import com.example.lifesharingappserver.entity.User;
import com.example.lifesharingappserver.exception.ServiceException;
import com.example.lifesharingappserver.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    private Log LOG = Log.get();

    public UserDTO login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userDTO.getUserName());
        queryWrapper.eq("user_password", userDTO.getPassword());
        try {
            User user = getOne(queryWrapper);
            if (user != null) {
                LOG.info("登录成功");
                BeanUtils.copyProperties(user,userDTO);
                return userDTO;
            }
            LOG.info("用户名或密码错误");
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        } catch (Exception e) {
            LOG.error("数据重复!");
            throw new ServiceException(Constants.CODE_500,"数据错误");
        }
    }


}
