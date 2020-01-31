package com.infoobjects.tms.view.interfaces;

import com.infoobjects.tms.dto.TeacherDTO;

import java.io.IOException;

public interface TeacherViewIncrement<Integer, DTO> extends View<Integer, TeacherDTO>{

    public void insertStudent() throws Exception;

    public void showAllStudent() throws IOException;

}
