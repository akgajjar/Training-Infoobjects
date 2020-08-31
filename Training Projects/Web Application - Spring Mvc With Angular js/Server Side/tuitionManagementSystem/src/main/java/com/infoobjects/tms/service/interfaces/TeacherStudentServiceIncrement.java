package com.infoobjects.tms.service.interfaces;

import java.util.List;

import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.entity.Teacher;

/**
 * @author Aniket
 * @description Service Interface - Specific Service methods related to TeacherStudent Mapping
 */
public interface TeacherStudentServiceIncrement<DTO> extends Service<DTO> {

	
	List<Teacher> getTeachersForMapping(String studentId);
	
	List<Student> getStudentsForMapping();
	
	List<Student> getStudentsByTeacherId(String teacherId);
	
	List<Teacher> getAllTeachers();
	
	void delete(String teacherId, String studentId);
	
	List<Teacher> getTeachersByStudentId(String studentId);
	
}
