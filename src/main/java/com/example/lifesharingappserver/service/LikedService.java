package com.example.lifesharingappserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifesharingappserver.entity.Liked;
import com.example.lifesharingappserver.entity.Note;
import com.example.lifesharingappserver.mapper.LikedMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LikedService extends ServiceImpl<LikedMapper, Liked> {

    @Resource
    private LikedMapper likedMapper;

    public List<Note> getLikedNotesByUserId(int userId) {
        return likedMapper.getLikedNotesByUserId(userId);
    }

    public int getLikeCountByNoteId(int noteId) {
        return likedMapper.getLikeCountByNoteId(noteId);
    }

    public void updateNoteLikeCount() {
        likedMapper.updateNoteLikeCount();
    }

    public void likeNote(int userId, int noteId) {
        likedMapper.likeNote(userId, noteId);
    }

    public void dislikeNote(int userId, int noteId) {
        likedMapper.dislikeNote(userId, noteId);
    }

}
