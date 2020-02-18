package com.infoobjects.tms.view.interfaces;

import com.infoobjects.tms.dto.Teacher;

import java.io.IOException;

public interface TeacherViewIncrement<String, DTO> extends View<String, DTO>{

    void insertStudent() throws Exception;

    void showAllStudent() throws IOException;

}
