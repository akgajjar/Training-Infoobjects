package com.infoobjects.Tuition_Management_System.view;

import com.infoobjects.Tuition_Management_System.DTO.StudentDTO;
import com.infoobjects.Tuition_Management_System.Service.StudentService;
import com.infoobjects.Tuition_Management_System.ServiceImpl.StudentServiceImpl;
import com.infoobjects.Tuition_Management_System.Utils.Projectutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ProjectMainView {
    private static StudentService studentService = null;
    private static BufferedReader br = null;

    public ProjectMainView() {
        studentService = new StudentServiceImpl();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void insertStudent() throws IOException {
        StudentDTO student = new StudentDTO();
        System.out.println("Student Details : ");
        student.setStudentId(Integer.parseInt(Projectutils.scan("Student Id")));
        student.setStudentName(Projectutils.scan("Student Name"));
        student.setStudentAddress(Projectutils.scan("Student Address"));
        student.setStudentEmailId(Projectutils.scan("Email Id",Projectutils.emailRejex));
        student.setStudentGender(Projectutils.scanGender());
        student.setStudentMobile(Projectutils.scan("Mobile No",Projectutils.mobileRejex));
        System.out.println("Parent Details : \n");
        student.setStudentParentName(Projectutils.scan("Student Parent Name"));
        student.setStudentParentMobile(Projectutils.scan("Mobile No",Projectutils.mobileRejex));
        student.setStudentParentEmailId(Projectutils.scan("Email Id",Projectutils.emailRejex));
        student.setStudentReferenceName(Projectutils.scan("Reference Name"));
        studentService.insert(student);
    }

    public void deleteStudent() throws NumberFormatException, IOException {
        System.out.println("\nEnter a Student Id : ");
        int id = Integer.parseInt(Projectutils.scan("Student Id"));
        studentService.delete(id);
    }

    public void updateStudent() throws IOException {
        System.out.println("\nEnter a Student Id : ");
        int id = Integer.parseInt(br.readLine());
        findStudent(id);
        StudentDTO student = new StudentDTO();
        student.setStudentId(id);
        System.out.println("\nStudent Details : ");
        student.setStudentName(Projectutils.scan("Name"));
        student.setStudentAddress(Projectutils.scan("Address");
        student.setStudentEmailId(Projectutils.scan("Email Id",Projectutils.emailRejex));
        student.setStudentGender(Projectutils.scanGender());
        student.setStudentMobile(Projectutils.scan("Mobile no ",Projectutils.mobileRejex));
        System.out.println("Parent Details : \n");
        student.setStudentParentName(Projectutils.scan("Parent Name"));
        student.setStudentParentMobile(Projectutils.scan("Mobile no ",Projectutils.mobileRejex));
        student.setStudentParentEmailId(Projectutils.scan("Email Id",Projectutils.emailRejex));
        student.setStudentReferenceName(Projectutils.scan(("Reference Name"));
        studentService.update(student);
    }

    public void findStudent(int studentId) {
        StudentDTO student = studentService.find(studentId);
        if (student == null) {
            System.out.println("\n\nNot Found !!!!!!!!!!!!\n\n");
            return;
        }
        System.out.println("\n" + student);
    }

    public void findAllStudent() {
        List<StudentDTO> students = studentService.findAll();
        if (students.size() == 0) {
            System.out.println("\n\nNo Students !!!!!!!!!!!!\n\n");
            return;
        }
        System.out.println("Students : \n\n");
        for (int i = 0; i < students.size(); i++) {
            StudentDTO student = students.get(i);
            System.out.println(student + "\n");
        }
    }
}
