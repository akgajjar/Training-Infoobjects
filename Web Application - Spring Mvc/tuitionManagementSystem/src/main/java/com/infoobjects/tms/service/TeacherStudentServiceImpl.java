package com.infoobjects.tms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.entity.Teacher;
import com.infoobjects.tms.service.interfaces.TeacherStudentServiceIncrement;

/**
 * @author Aniket
 * @description Service Class - used to Perform Data Transformation on
 *              TeacherStudent Data
 */
public class TeacherStudentServiceImpl implements TeacherStudentServiceIncrement<TeacherStudent> {

	/**
	 * Logger for Logging Events
	 */
	private static final Logger logger = LoggerFactory.getLogger(TeacherStudentServiceImpl.class);

	/**
	 * TeacherService Reference to Perform Database Operation on Teacher and it's
	 * TeacherStudent Mapping records
	 */
	@Autowired
	private TeacherServiceImpl teacherService;

	/**
	 * StudentService Reference to Perform Database Operation on Student and it's
	 * TeacherStudent Mapping records
	 */
	@Autowired
	private StudentServiceImpl studentService;

	/**
	 * setters
	 */
	public void setTeacherService(TeacherServiceImpl teacherService) {
		this.teacherService = teacherService;
	}

	public void setStudentService(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}

	/**
	 * used to get all teacher's record which are not mapped with specific Student
	 *
	 * @param studentId Student's Id
	 * @return List<Teacher>
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Teacher> getTeachersForMapping(String studentId) {
		Student student = studentService.find(studentId);
		List<Teacher> allTeachers = teacherService.findAll();
		if (allTeachers == null) {
			logger.warn("(0) Teachers Found");
			return new ArrayList<Teacher>();
		}
		if (student == null) {
			logger.warn("(0) Students Found");
			return allTeachers;
		}
		Hibernate.initialize(student.getTeachers());
		List<Teacher> teachersOfStudent = student.getTeachers();

		List<Teacher> teachers = new ArrayList<Teacher>();

		List<String> teachersId = new ArrayList<String>();
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
		logger.info("Teachers for Mapping are Successfully Found");
		return teachers;
	}

	/**
	 * used to all student record which are not mapped with all Teacher record
	 * 
	 * @return List<Student>
	 */
	@Transactional
	@Override
	public List<Student> getStudentsForMapping() {
		List<Teacher> allTeachers = teacherService.findAll();
		List<Student> allStudents = studentService.findAll();
		if (allStudents == null) {
			logger.warn("(0) Students Found");
			return new ArrayList<Student>();
		}
		if (allTeachers == null) {
			logger.warn("(0) Teachers Found");
			return allStudents;
		}
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
		logger.info("Students for Mapping are Successfully Found");
		return responseStudents;
	}

	/**
	 * used to insert teacherStudent record
	 * 
	 * @param teacherStudent TeacherStudent Data
	 */
	@Transactional
	@Override
	public void insert(TeacherStudent teacherStudent) {
		Teacher teacher = teacherService.find(teacherStudent.getTeacherId());
		try {
				Hibernate.initialize(teacher.getStudents());
				logger.info("Students Successfully Initialized");
			}
		catch(HibernateException hibernateException) {
			logger.info("Students is not Successfully Initialized, Error Occurred : %s", hibernateException.getStackTrace().toString());
		}
		catch(Exception exception) {
			logger.info("Students is not Successfully Initialized, Error Occurred : %s", exception.getStackTrace().toString());
		}
		teacher.getStudents().add(studentService.find(teacherStudent.getStudentId()));
		teacherService.update(teacher);
		logger.info("TeacherStudent Successfully Inserted, Data : %s ", teacherStudent);
	}

	/**
	 * Deprecated Method which are not useful for this table
	 * 
	 * @param id
	 */
	@Override
	@Deprecated
	public void delete(String id) {
		logger.warn("Deperecated Delete Method Called which is no longer useful");
	}

	/**
	 * Deprecated Method which are not useful for this table
	 * 
	 * @param id
	 * @return TeacherStudent
	 */
	@Override
	@Deprecated
	public TeacherStudent find(String id) {
		logger.warn("Deperecated find Method Called which is no longer useful");
		return null;
	}

	/**
	 * Deprecated Method which are not useful for this table
	 * 
	 * @param teacherstudent
	 */
	@Override
	@Deprecated
	public void update(TeacherStudent teacherstudent) {
		logger.warn("Deperecated update Method Called which is no longer useful");
	}

	/**
	 * used to get all TeacherStudent Mapping records
	 * 
	 * @return List<TeacherStudent>
	 */
	@Override
	@Transactional
	public List<TeacherStudent> findAll() {
		List<Student> allStudents = studentService.findAll();
		if (allStudents == null) {
			logger.warn("(0) Students Founds");
			return new ArrayList<TeacherStudent>();
		}
		List<TeacherStudent> allTeacherStudents = new ArrayList<TeacherStudent>();
		for (Student student : allStudents) {
			Hibernate.initialize(student.getTeachers());
			logger.info("Teachers are Successfully Initialized");
			for (Teacher teacher : student.getTeachers()) {
				TeacherStudent teacherStudent = new TeacherStudent();
				teacherStudent.setStudentId(student.getStudentId());
				teacherStudent.setTeacherId(teacher.getTeacherId());
				teacherStudent.setStudentName(student.getStudentName());
				teacherStudent.setTeacherName(teacher.getTeacherName());

				allTeacherStudents.add(teacherStudent);
			}
		}
		logger.info("Teacher Students are Successfully Found");
		return allTeacherStudents;
	}

	/**
	 * used to get all Student'ss records for specific Teacher Id
	 * 
	 * @param teacherId Teacher's Id
	 * @return List<Student>
	 */
	@Override
	@Transactional
	public List<Student> getStudentsByTeacherId(String teacherId) {
		Teacher teacher = teacherService.find(teacherId);
		Hibernate.initialize(teacher.getStudents());
		logger.info("Students are Successfully Initialized");
		logger.info("Students for TeacherId %s is Successfully Found", teacherId);
		return teacher.getStudents();
	}

	/**
	 * used to get all Teacher's records
	 * 
	 * @return
	 */
	@Override
	public List<Teacher> getAllTeachers() {
		List<Teacher> teachers = teacherService.findAll();
		if (teachers == null) {
			logger.info("(0) Teachers Found");
			return new ArrayList<Teacher>();
		}
		else {
			return teachers;
		}
	}

	/**
	 * used to delete specific TeacherStudent record from Database
	 * 
	 * @param teacherId Teacher's Id
	 * @param studentId Student's Id
	 */
	@Override
	@Transactional
	public void delete(String teacherId, String studentId) {
		Teacher teacher = teacherService.find(teacherId);
		Hibernate.initialize(teacher.getStudents());
		logger.info("Students are Successfully Initialized");
		List<Student> students = teacher.getStudents();
		ListIterator<Student> studentsIterator = students.listIterator();

		while (studentsIterator.hasNext()) {
			Student student = studentsIterator.next();
			if (student.getStudentId().equalsIgnoreCase(studentId)) {
				studentsIterator.remove();
				break;
			}
		}
		teacher.setStudents(students);
		teacherService.update(teacher);
		logger.info("Teacher Student Successfully deleted, teacherId : %s , studentId : %s", teacherId, studentId);
	}

}
