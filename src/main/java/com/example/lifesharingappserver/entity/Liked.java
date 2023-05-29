package com.example.lifesharingappserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "Liked")
public class Liked {

    @TableId(value = "liked_id", type = IdType.AUTO)
    private Integer likedId;
    @TableField(value = "user_name")
    private Integer userId;
    @TableField(value = "user_name")
    private Integer noteId;

}
