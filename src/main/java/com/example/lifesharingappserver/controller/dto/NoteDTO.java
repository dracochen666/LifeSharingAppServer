package com.example.lifesharingappserver.controller.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.BlobTypeHandler;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NoteDTO {

    private Integer noteId;
    private byte[] noteCoverPhoto;
    private byte[] notePhotos;
    private String noteTitle;
    private String noteContent;
    private String noteTopics;
    private String noteSubTopics;
    private String notePositions;
    private String noteComments;
    private Date create_time;

    private String noteOwner;
    private String noteLikedNumber;
    private String noteCollectedNumber;
}
