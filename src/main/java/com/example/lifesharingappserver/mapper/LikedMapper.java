package com.example.lifesharingappserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lifesharingappserver.entity.Liked;
import com.example.lifesharingappserver.entity.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LikedMapper extends BaseMapper<Liked> {

    @Select("SELECT * FROM Note WHERE note_id IN (SELECT note_id FROM Liked WHERE user_id = #{userId})")
    List<Note> getLikedNotesByUserId(@Param("userId") int userId);

    @Select("SELECT COUNT(*) FROM Liked WHERE note_id = #{noteId}")
    int getLikeCountByNoteId(@Param("noteId") int noteId);

    @Update("UPDATE Note SET note_likednumber = (SELECT COUNT(*) FROM Liked WHERE Liked.note_id = Note.note_id)")
    void updateNoteLikeCount();

    @Insert("INSERT INTO Liked (user_id, note_id) VALUES (#{userId}, #{noteId})")
    void likeNote(@Param("userId") int userId, @Param("noteId") int noteId);

    @Delete("DELETE FROM Liked WHERE user_id = #{userId} AND note_id = #{noteId}")
    void dislikeNote(@Param("userId") int userId, @Param("noteId") int noteId);

}
