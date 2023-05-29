package com.example.lifesharingappserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lifesharingappserver.controller.dto.NoteCommentDTO;
import com.example.lifesharingappserver.entity.NoteComment;
import com.example.lifesharingappserver.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comment")
public class CommentController {
    @Autowired
    private CommentService noteCommentService;

    //获取全部笔记评论
    @GetMapping("/getCommentsByNoteId")
    public List<NoteComment> getAllComments(@RequestParam int noteId){
        QueryWrapper<NoteComment> queryWrapper = new QueryWrapper<>();
        System.out.println(noteId);
        queryWrapper.like("comment_noteid", noteId);
        return noteCommentService.list(queryWrapper);
    }

    //发送笔记评论
    @PostMapping("/sendComment")
    public boolean sendComment(@RequestBody NoteCommentDTO noteCommentDTO){
        System.out.println("noteCommentDTO "+noteCommentDTO);
        NoteComment noteComment = new NoteComment();
        BeanUtils.copyProperties(noteCommentDTO, noteComment);
        System.out.println("noteComment "+noteComment);
        return noteCommentService.save(noteComment);

    }
}
