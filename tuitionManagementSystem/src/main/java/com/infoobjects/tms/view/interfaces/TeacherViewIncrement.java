package com.infoobjects.tms.view.interfaces;

import com.infoobjects.tms.dto.TeacherDTO;

import java.io.IOException;

public interface TeacherViewIncrement<Integer, DTO> extends View<Integer, TeacherDTO>{

    void insertStudent() throws Exception;

    void showAllStudent() throws IOException;

}
