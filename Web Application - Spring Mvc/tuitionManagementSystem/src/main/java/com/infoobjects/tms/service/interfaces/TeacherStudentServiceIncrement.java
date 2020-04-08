package com.infoobjects.tms.service.interfaces;

import java.util.List;

import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.dto.interfaces.DTO;

public interface TeacherStudentServiceIncrement<DTO> extends Service<String, DTO> {

	
	List<Teacher> getTeachersForMapping(String studentId);
	
	List<Student> getStudentsForMapping();
	
	List<Student> getStudentsByTeacherId(String teacherId);
	
	List<Teacher> getAllTeachers();
	
	void delete(String teacherId, String studentId);
	
}
