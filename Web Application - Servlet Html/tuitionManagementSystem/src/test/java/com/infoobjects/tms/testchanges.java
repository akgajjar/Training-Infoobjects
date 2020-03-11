package com.infoobjects.tms;

import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.service.TeacherServiceImpl;
import com.infoobjects.tms.service.TeacherStudentServiceImpl;
import com.infoobjects.tms.utils.TmsUtils;
import org.apache.commons.text.CaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class testchanges {
    public static void main(String[] args) {
        StudentServiceImpl studentService = new StudentServiceImpl();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        TeacherStudentServiceImpl teacherStudentService = new TeacherStudentServiceImpl();







        /*String studentId = "5ecf93d5-9bb1-45be-8f93-d59bb1b5be01";
        List<Teacher> teachers = teacherStudentService.getTeacherName(studentId);
        List<Teacher> allTeachers = teacherService.findAll();
        System.out.println( teachers);
        List<String> teachers1 = new ArrayList<String>();

        for(Teacher teacher : teachers){
            teachers1.add(teacher.getTeacherId());
        }
        for (Teacher teacher : allTeachers) {
            System.out.println(teachers1.contains(teacher.getTeacherId()));


            System.out.println(  teacher);
        }*/

        TeacherStudent teacherStudent = new TeacherStudent();
        teacherStudent.setTeacherId("5b97e0c9-7748-4a56-97e0-c977484a56d5");
        teacherStudent.setStudentId("bd75c80b-7ae5-4ce0-b5c8-0b7ae56ce0cb");

        teacherStudentService.delete(teacherStudent);
    }
}