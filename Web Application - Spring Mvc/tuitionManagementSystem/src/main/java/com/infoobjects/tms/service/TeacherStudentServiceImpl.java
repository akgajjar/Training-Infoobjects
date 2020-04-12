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

/**
 * @author Aniket
 * @description Service Class - used to Perform Data Transformation on  TeacherStudent Data
 */
public class TeacherStudentServiceImpl implements TeacherStudentServiceIncrement<TeacherStudent> {

    /**
     * TeacherService Reference to Perform Database Operation on Teacher and it's TeacherStudent Mapping records
     */
    @Autowired
    private TeacherServiceImpl teacherService;

    /**
     * StudentService Reference to Perform Database Operation on Student and it's TeacherStudent Mapping records
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
        Hibernate.initialize(student.getTeachers());
        List<Teacher> teachersOfStudent = student.getTeachers();
        List<Teacher> allTeachers = teacherService.findAll();
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
        return teachers;
    }

	/**
	 * used to all student record which are not mapped with all Teacher record
	 * @return List<Student>
	 */
	@Transactional
    @Override
    public List<Student> getStudentsForMapping() {
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

	/**
	 * used to insert teacherStudent record
	 * @param teacherStudent TeacherStudent Data
	 */
	@Transactional
    @Override
    public void insert(TeacherStudent teacherStudent) {
        Teacher teacher = teacherService.find(teacherStudent.getTeacherId());
        Hibernate.initialize(teacher.getStudents());
        teacher.getStudents().add(studentService.find(teacherStudent.getStudentId()));
        teacherService.update(teacher);
    }

	/**
	 * Deprecated Method which are not useful for this table
	 * @param id
	 */
	@Override
    @Deprecated
    public void delete(String id) {
    }

	/**
	 * Deprecated Method which are not useful for this table
	 * @param id
	 * @return TeacherStudent
	 */
	@Override
    @Deprecated
    public TeacherStudent find(String id) {
        return null;
    }

	/**
	 * Deprecated Method which are not useful for this table
	 * @param teacherstudent
	 */
	@Override
    @Deprecated
    public void update(TeacherStudent teacherstudent) {
    }

	/**
	 * used to get all TeacherStudent Mapping records
	 * @return List<TeacherStudent>
	 */
	@Override
    @Transactional
    public List<TeacherStudent> findAll() {
        List<Student> allStudents = studentService.findAll();
        List<TeacherStudent> allTeacherStudents = new ArrayList<TeacherStudent>();
        for (Student student : allStudents) {
            Hibernate.initialize(student.getTeachers());
            for (Teacher teacher : student.getTeachers()) {
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

	/**
	 * used to get all Student'ss records for specific Teacher Id
	 * @param teacherId Teacher's Id
	 * @return List<Student>
	 */
	@Override
    @Transactional
    public List<Student> getStudentsByTeacherId(String teacherId) {
        Teacher teacher = teacherService.find(teacherId);
        Hibernate.initialize(teacher.getStudents());
        return teacher.getStudents();
    }

	/**
	 * used to get all Teacher's records
	 * @return
	 */
	@Override
    public List<Teacher> getAllTeachers() {
        return teacherService.findAll();
    }

	/**
	 * used to delete specific TeacherStudent record from Database
	 * @param teacherId Teacher's Id
	 * @param studentId Student's Id
	 */
	@Override
    @Transactional
    public void delete(String teacherId, String studentId) {
        Teacher teacher = teacherService.find(teacherId);
        Hibernate.initialize(teacher.getStudents());
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
    }

}
