package com.example.lifesharingappserver.controller;

import com.example.lifesharingappserver.entity.User;
import com.example.lifesharingappserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getAllUser")
    public List<User> getAllUser(){

        return userService.getAllUser();
    }

//    @GetMapping("/getUser")
//    public String getUser(){
//        User user = new User();
//        user.setUserId(1);
//        user.setUserName("xiaoming");
//        return "userId:"+ user.getUserId() + " userName:"+ user.getUserName();
//    }
}
