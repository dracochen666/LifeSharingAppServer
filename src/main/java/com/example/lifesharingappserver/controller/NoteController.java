package com.example.lifesharingappserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lifesharingappserver.entity.Note;
import com.example.lifesharingappserver.entity.User;
import com.example.lifesharingappserver.service.NoteService;
import com.example.lifesharingappserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Note")
public class NoteController{

    @Autowired
    private NoteService noteService;

    @GetMapping("/getAllNote")
    public List<Note> getAllNote(){
        return noteService.list();
    }

    @PostMapping("/saveNote")
    public boolean saveNote(@RequestBody Note note) {
        return noteService.save(note);
    }

    @GetMapping("/page")
    public IPage<Note> findPage(@RequestParam Integer pageSize,
                                @RequestParam Integer pageNum
    ) {
        IPage<Note> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Note> queryWrapper = new QueryWrapper<>();

        return noteService.page(page, queryWrapper);
    }}
