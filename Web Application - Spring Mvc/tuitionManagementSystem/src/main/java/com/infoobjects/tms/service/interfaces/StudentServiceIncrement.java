package com.infoobjects.tms.service.interfaces;

import java.util.List;

import com.infoobjects.tms.entity.Teacher;

/**
 * @author Aniket
 * @description Service Interface - Specific Service methods related to Student
 */
public interface StudentServiceIncrement<DTO> extends Service<DTO> {

	List<Teacher> getTeacherName(String studentId);
	 
}
