package com.example.lifesharingappserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.BlobTypeHandler;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "Note")
public class Note {

    @TableId(value = "note_id", type = IdType.AUTO)
    private Integer noteId;

    @TableField(value = "note_coverphoto", typeHandler = BlobTypeHandler.class)
    private byte[] noteCoverPhoto;
    @TableField(value = "note_photos", typeHandler = BlobTypeHandler.class)
    private byte[] notePhotos;
    @TableField("note_title")
    private String noteTitle;
    @TableField("note_content")
    private String noteContent;
    @TableField("note_topics")
    private String noteTopics;
    @TableField("note_subtopics")
    private String noteSubTopics;
    @TableField("note_positions")
    private String notePositions;
    @TableField("note_comments")
    private String noteComments;
    @TableField("create_time")
    private Date createTime;

    @TableField("note_owner")
    private String noteOwner;
    @TableField("note_likednumber")
    private String noteLikedNumber;

}
