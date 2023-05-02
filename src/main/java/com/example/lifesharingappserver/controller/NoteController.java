package com.example.lifesharingappserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lifesharingappserver.entity.Note;
import com.example.lifesharingappserver.service.NoteService;
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
    }
    @DeleteMapping("/delete")
    public boolean deleteNoteById(@RequestParam Integer noteId) {
        return noteService.removeById(noteId);
    }
    @DeleteMapping("/{noteId}")
    public boolean deleteNoteById2(@PathVariable Integer noteId) {
        return noteService.removeById(noteId);
    }
    //test 模糊搜索
    @GetMapping("/pageTest")
    public IPage<Note> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String topics) {
        IPage<Note> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
        System.out.println(topics);
        if (!topics.toString().equals("")) {
            queryWrapper.like("note_topics", topics);
        }
        return noteService.page(page, queryWrapper);
    }
}

