package com.example.lifesharingappserver.controller;

import com.example.lifesharingappserver.entity.Note;
import com.example.lifesharingappserver.service.LikedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Liked")
public class LikedController {

    @Autowired
    private LikedService noteLikedService;

    //获取用户点赞的笔记
    @GetMapping("/getLikedNoteByUserId")
    public List<Note> getLikedNoteByUserId(@RequestParam int userId){
        return noteLikedService.getLikedNotesByUserId(userId);
    }

    @GetMapping("/updateLikedNumber")
    public void updateLikedNumber(){
        noteLikedService.updateNoteLikeCount();
    }

    //根据noteId进行点赞操作
    @GetMapping("/likeNote")
    public void likeNote(@RequestParam int userId,
                         @RequestParam int noteId){
        noteLikedService.likeNote(userId,noteId);
    }

    //根据noteId进行取消点赞操作
    @GetMapping("/dislikeNote")
    public void dislikeNote(@RequestParam int userId,
                         @RequestParam int noteId){
        noteLikedService.dislikeNote(userId, noteId);
    }

}
