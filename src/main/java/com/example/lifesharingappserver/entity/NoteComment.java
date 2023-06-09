package com.example.lifesharingappserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "Comment")
public class NoteComment {

    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    @TableField("comment_userid")
    private int commentUserId;

    @TableField("comment_noteid")
    private int commentNoteId;

    @TableField("comment_content")
    private String commentContent;

    @TableField("create_time")
    private Date createTime;

}
