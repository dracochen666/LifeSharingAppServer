package com.example.lifesharingappserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifesharingappserver.entity.Note;
import com.example.lifesharingappserver.mapper.NoteMapper;
import org.springframework.stereotype.Service;

@Service
public class NoteService extends ServiceImpl<NoteMapper, Note> {

}
