package com.example.lifesharingappserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifesharingappserver.common.Constants;
import com.example.lifesharingappserver.controller.dto.UserDTO;
import com.example.lifesharingappserver.entity.NoteComment;
import com.example.lifesharingappserver.exception.ServiceException;
import com.example.lifesharingappserver.mapper.CommentMapper;
import com.example.lifesharingappserver.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentService extends ServiceImpl<CommentMapper, NoteComment> {

    @Resource
    CommentMapper commentMapper;

}
