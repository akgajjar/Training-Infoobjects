package com.infoobjects.tms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.entity.Teacher;
import com.infoobjects.tms.service.interfaces.TeacherStudentServiceIncrement;

public class TeacherStudentServiceImpl implements TeacherStudentServiceIncrement<TeacherStudent> {

	@Autowired
	private TeacherServiceImpl teacherService;
	
	@Autowired
	private StudentServiceImpl studentService;

	public TeacherServiceImpl getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherServiceImpl teacherService) {
		this.teacherService = teacherService;
	}

	public StudentServiceImpl getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Teacher> getTeachersForMapping(String studentId){
		Student student = studentService.find(studentId);
		Hibernate.initialize(student.getTeachers());
		 List<Teacher> teachersOfStudent = student.getTeachers();
         List<Teacher> allTeachers = teacherService.findAll();
         List<String> teachersId = new ArrayList<String>();
         List<Teacher> teachers = new ArrayList<Teacher>();
         
         if (teachersOfStudent.size() > 0) {
             for (Teacher teacher : teachersOfStudent) {
                 teachersId.add(teacher.getTeacherId());
             }
         }
         
         if (allTeachers.size() > 0) {
             for (Teacher teacher : allTeachers) {
                 if (teachersId.contains(teacher.getTeacherId())) {
                     continue;
                 }
                teachers.add(teacher);
             }
         }
		return teachers;
	}

	@Transactional
	@Override
	public List<Student> getStudentsForMapping(){
		List<Teacher> allTeachers = teacherService.findAll();
		List<Student> allStudents = studentService.findAll();
        List<Student> responseStudents = new ArrayList<Student>();
        if (allStudents.size() > 0) {
            for (Student student : allStudents) {
                Hibernate.initialize(student.getTeachers());
                List<Teacher> teachers = student.getTeachers();
                if (teachers.size() == allTeachers.size()) {
                    continue;
                }
                responseStudents.add(student);
            }
        }
        return responseStudents;
	}

	@Transactional
	@Override
	public void insert(TeacherStudent teacherStudent) {
		Teacher teacher = teacherService.find(teacherStudent.getTeacherId());
		Hibernate.initialize(teacher.getStudents());
		teacher.getStudents().add(studentService.find(teacherStudent.getStudentId()));
		teacherService.update(teacher);
	}

	@Override
	@Deprecated
	public void delete(String id) {
	}

	@Override
	@Deprecated
	public TeacherStudent find(String id) {
		return null;
	}

	@Override
	@Deprecated
	public void update(TeacherStudent teacherstudent) {
		
		
	}

	@Override
	@Transactional
	public List<TeacherStudent> findAll() {
		List<Student> allStudents = studentService.findAll();
		List<TeacherStudent> allTeacherStudents = new ArrayList<TeacherStudent>();
		for(Student student : allStudents) {
			Hibernate.initialize(student.getTeachers());
			for(Teacher teacher : student.getTeachers()) {
				TeacherStudent teacherStudent = new TeacherStudent();
				teacherStudent.setStudentId(student.getStudentId());
				teacherStudent.setTeacherId(teacher.getTeacherId());
				teacherStudent.setStudentName(student.getStudentName());
				teacherStudent.setTeacherName(teacher.getTeacherName());
				
				allTeacherStudents.add(teacherStudent);
			}
		}
		return allTeacherStudents;
	}

	@Override
	@Transactional
	public List<Student> getStudentsByTeacherId(String teacherId) {
		Teacher teacher = teacherService.find(teacherId);
		Hibernate.initialize(teacher.getStudents());
		return teacher.getStudents();
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherService.findAll();
	}

	@Override
	@Transactional
	public void delete(String teacherId, String studentId) {
		Teacher teacher = teacherService.find(teacherId);
		Hibernate.initialize(teacher.getStudents());
		List<Student> students = teacher.getStudents();
		ListIterator<Student> studentsIterator = students.listIterator();
		
		// Traversing elements
		while(studentsIterator.hasNext()){
			Student student = studentsIterator.next();
			if(student.getStudentId().equalsIgnoreCase(studentId)) {
				studentsIterator.remove();
				break;
			}
		}	
		teacher.setStudents(students);
		teacherService.update(teacher);
	}
	
}
