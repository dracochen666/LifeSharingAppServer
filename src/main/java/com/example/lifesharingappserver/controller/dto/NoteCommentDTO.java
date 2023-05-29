package com.example.lifesharingappserver.controller.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteCommentDTO {

    private int commentId;
    private int commentUserId;
    private int commentNoteId;
    private String commentContent;
    private Date createTime;

}
