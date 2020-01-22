package com.infoobjects.tuitionManagementSystem.view.impl;

import com.infoobjects.tuitionManagementSystem.dto.StudentDTO;
import com.infoobjects.tuitionManagementSystem.service.impl.StudentServiceImpl;
import com.infoobjects.tuitionManagementSystem.service.StudentService;
import com.infoobjects.tuitionManagementSystem.utils.Projectutils;
import com.infoobjects.tuitionManagementSystem.view.View;

import java.io.IOException;
import java.util.List;

public class StudentViewImpl implements View {

    private static StudentService studentService = null;
    private Projectutils projectUtils = null;
    public StudentViewImpl() {
        studentService = new StudentServiceImpl();
        projectUtils = new Projectutils();
    }

    @Override
    public void insert() throws IOException {
        StudentDTO student = new StudentDTO();
        System.out.println("Student Details : ");
        student.setStudentId(Integer.parseInt(projectUtils.scan("Student Id")));
        student.setStudentName(projectUtils.scan("Student Name"));
        student.setStudentAddress(projectUtils.scan("Student Address"));
        student.setStudentEmailId(projectUtils.scan("Email Id",Projectutils.emailRejex));
        student.setStudentGender(projectUtils.scanGender());
        student.setStudentMobile(projectUtils.scan("Mobile No",Projectutils.mobileRejex));
        System.out.println("Parent Details : \n");
        student.setStudentParentName(projectUtils.scan("Student Parent Name"));
        student.setStudentParentMobile(projectUtils.scan("Mobile No",Projectutils.mobileRejex));
        student.setStudentParentEmailId(projectUtils.scan("Email Id",Projectutils.emailRejex));
        student.setStudentReferenceName(projectUtils.scan("Reference Name"));
        studentService.insert(student);
    }

    @Override
    public void delete() throws NumberFormatException, IOException {
        int studentId = Integer.parseInt(projectUtils.scan("Student Id"));
        studentService.delete(studentId);
    }

    @Override
    public void update() throws IOException {
        int studentId = Integer.parseInt(projectUtils.scan("Student Id"));
        find(studentId);
        StudentDTO student = new StudentDTO();
        student.setStudentId(studentId);
        System.out.println("\nStudent Details : ");
        student.setStudentName(projectUtils.scan("Name"));
        student.setStudentAddress(projectUtils.scan("Address"));
        student.setStudentEmailId(projectUtils.scan("Email Id",Projectutils.emailRejex));
        student.setStudentGender(projectUtils.scanGender());
        student.setStudentMobile(projectUtils.scan("Mobile no ",Projectutils.mobileRejex));
        System.out.println("Parent Details : \n");
        student.setStudentParentName(projectUtils.scan("Parent Name"));
        student.setStudentParentMobile(projectUtils.scan("Mobile no ",Projectutils.mobileRejex));
        student.setStudentParentEmailId(projectUtils.scan("Email Id",Projectutils.emailRejex));
        student.setStudentReferenceName(projectUtils.scan(("Reference Name")));
        studentService.update(student);
    }

    @Override
    public void find(int id) {
        StudentDTO student = studentService.find(id);
        if (student == null) {
            System.out.println(Projectutils.findErrorMsg);
            return;
        }
        System.out.println("\n" + student);
    }

    @Override
    public void findAll() {
        List<StudentDTO> students = studentService.findAll();
        if (students.size() == 0) {
            System.out.println(Projectutils.findErrorMsg);
            return;
        }
        System.out.println("Students : \n\n");
        for (int i = 0; i < students.size(); i++) {
            StudentDTO student = students.get(i);
            System.out.println(student + "\n");
        }
    }

    public void mainView() throws Exception{
        int choice, loopBreak = 0;
        String functionalityOptions = String.format("1) Insert Student %n" +
                                                      "2) Update Student %n" +
                                                      "3) Delete Student %n" +
                                                      "4) Find Student %n" +
                                                      "5) Find All Student %n" +
                                                      "6) Exit");
        String pretty = "--------------------------------------------------------------------\n";
        String systemName = "\t\t\tTuition Management System\t\t\t";

        System.out.printf("%s %s %n %s %n", pretty,systemName, pretty);
        while (true) {
            System.out.println(functionalityOptions);
            choice = Integer.parseInt(projectUtils.scan("Choice"));
            switch (choice) {
                case 1:
                    insert();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    int studentId = Integer.parseInt(projectUtils.scan("Student Id"));
                    find(studentId);
                    break;
                case 5:
                    findAll();
                    break;
                case 6:
                    loopBreak = 1;
                    break;
                default:
                    System.out.println(Projectutils.scanningErrorMsg);
                    break;
            }
            if (loopBreak == 1)
                break;
        }
    }

}
