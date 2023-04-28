package com.example.lifesharingappserver.entity;

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
@TableName(value = "Note")
public class Note {

    @TableId(value = "note_id")
    private Integer noteId;
    @TableField("note_title")
    private String noteTitle;
    @TableField("note_content")
    private String noteContent;
    @TableField("note_images")
    private String noteImages;
    @TableField("note_topics")
    private String noteTopics;
    @TableField("note_subtopics")
    private String noteSubTopics;
    @TableField("note_positions")
    private String notePositions;
    @TableField("note_comments")
    private String noteComments;
    private Date create_time;

}
