package com.example.lifesharingappserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lifesharingappserver.controller.dto.NoteDTO;
import com.example.lifesharingappserver.entity.Note;
import com.example.lifesharingappserver.mapper.NoteMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class NoteService extends ServiceImpl<NoteMapper, Note> {

    public NoteDTO saveNote(NoteDTO noteDTO) {
        Note note = new Note();
        BeanUtils.copyProperties(noteDTO, note);
        save(note);
        BeanUtils.copyProperties(note, noteDTO);
        return noteDTO;
    }
}
