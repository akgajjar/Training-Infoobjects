package com.infoobjects.tms.view.interfaces;

import com.infoobjects.tms.dto.Teacher;

import java.io.IOException;

public interface TeacherViewIncrement<Integer, DTO> extends View<Integer, Teacher>{

    void insertStudent() throws Exception;

    void showAllStudent() throws IOException;

}
