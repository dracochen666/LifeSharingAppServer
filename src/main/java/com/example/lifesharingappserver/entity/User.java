package com.example.lifesharingappserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "User")
public class User {
    @TableId(value = "userid")
    private Integer userid;

    private String username;

    private String password;

}
