package com.example.lifesharingappserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lifesharingappserver.common.Constants;
import com.example.lifesharingappserver.common.Result;
import com.example.lifesharingappserver.controller.dto.NoteDTO;
import com.example.lifesharingappserver.entity.Note;
import com.example.lifesharingappserver.mapper.NoteMapper;
import com.example.lifesharingappserver.service.NoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Note")
public class NoteController{

    @Autowired
    private NoteService noteService;

    //获取全部笔记
    @GetMapping("/getAllNotes")
    public List<Note> getAllNote(){
        return noteService.list();
    }


    //获取用户发布的笔记
    @GetMapping("/getUserPublishedNote")
    public List<Note> getUserPublishedNote(@RequestParam int userId){
        QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
        System.out.println(userId);
        queryWrapper.like("note_owner", userId);
        return noteService.list(queryWrapper);
    }

    //根据noteId获取笔记
    @GetMapping("/getNoteById")
    public Note getNoteById(@RequestParam int noteId){
        return noteService.getById(noteId);
    }

    //根据noteId获取笔记评论
    @GetMapping("/getCommentById")
    public Note getCommentById(@RequestParam int noteId){
        return noteService.getById(noteId);
    }


    @PostMapping("/saveNote")
    public boolean saveNote(@RequestBody Note note) {

        return noteService.save(note);
    }

    @PostMapping("/saveNoteResult")
    public Result saveNote(@RequestBody NoteDTO noteDTO) {
//        if (noteDTO.getNoteCoverPhotoStr() == null) {
//            return Result.error();
//        }
//        Note note = new Note();
//        BeanUtils.copyProperties(noteDTO,note);
//        System.out.println("noteDTO cpStr:  --------"+ noteDTO.getNoteCoverPhotoStr().toString());
//        note.setNoteCoverPhoto(noteDTO.getNoteCoverPhotoStr().toString().getBytes(StandardCharsets.UTF_8));
//        System.out.println("note cp:  --------"+ note.getNoteCoverPhoto().toString());
        noteService.saveNote(noteDTO);
        return Result.success(noteDTO);
    }

    @PostMapping("/uploadCoverPhoto")
    public boolean uploadCoverPhoto(@RequestParam Integer noteId,
                                    @RequestParam MultipartFile file) throws IOException {
        if (file != null) {
            Note note = new Note();
            note.setNoteId(noteId);
            note.setNoteCoverPhoto(file.getBytes());
            if (noteService.getById(noteId) != null) {
                noteService.updateById(note);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    @PostMapping("/uploadCoverPhoto2")
    public boolean uploadCoverPhoto(@RequestParam Integer noteId,
                                    @RequestParam byte[] data) throws IOException {
        if (data != null) {
            Note note = new Note();
            note.setNoteId(noteId);
            note.setNoteCoverPhoto(data);
            if (noteService.getById(noteId) != null) {
                noteService.updateById(note);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @GetMapping("/page")
    public IPage<Note> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize) {
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
        if (!topics.equals("")) {
            queryWrapper.like("note_topics", topics);
        }
        return noteService.page(page, queryWrapper);
    }

}

