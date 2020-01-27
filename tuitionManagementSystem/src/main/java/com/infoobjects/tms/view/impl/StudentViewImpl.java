package com.infoobjects.tms.view.impl;

import com.infoobjects.tms.dto.StudentDTO;
import com.infoobjects.tms.service.Service;
import com.infoobjects.tms.service.impl.StudentServiceImpl;
import static  com.infoobjects.tms.utils.Projectutils.*;
import com.infoobjects.tms.view.View;

import java.io.IOException;
import java.util.List;

public class StudentViewImpl implements View<StudentDTO,Integer> {

    private static Service<StudentDTO, Integer> studentService = null;

    public StudentViewImpl() {
        studentService = new StudentServiceImpl();
    }

    @Override
    public void insert() throws IOException {
        StudentDTO student = new StudentDTO();
        System.out.println("Student Details : ");
        student.setStudentId(scanInteger("Student Id"));
        if(studentService.find(student.getStudentId()) != null){
            System.out.println(duplicatePrimaryKeyErrorMsg);
            return ;
        }
        student.setStudentName(scan("Student Name"));
        student.setStudentAddress(scan("Student Address"));
        student.setStudentEmailId(scan("Email Id", emailRegex));
        student.setStudentGender(scanGender());
        student.setStudentMobile(scan("Mobile No", mobileRegex));
        System.out.println("Parent Details : \n");
        student.setStudentParentName(scan("Student Parent Name"));
        student.setStudentParentMobile(scan("Mobile No", mobileRegex));
        student.setStudentParentEmailId(scan("Email Id", emailRegex));
        student.setStudentReferenceName(scan("Reference Name"));
        studentService.insert(student);
    }

    @Override
    public void delete() throws NumberFormatException, IOException {
        int studentId = scanInteger("Student Id");
        if(studentService.find(studentId) == null)
        {
            System.out.println(findErrorMsg);
            return;
        }
        studentService.delete(studentId);
    }

    @Override
    public void update() throws IOException {
        int studentId = scanInteger("Student Id");
        if(studentService.find(studentId) == null)
        {
            System.out.println(findErrorMsg);
            return;
        }
        find(studentId);
        StudentDTO student = new StudentDTO();
        student.setStudentId(studentId);
        System.out.println("\nStudent Details : ");
        student.setStudentName(scan("Name"));
        student.setStudentAddress(scan("Address"));
        student.setStudentEmailId(scan("Email Id", emailRegex));
        student.setStudentGender(scanGender());
        student.setStudentMobile(scan("Mobile no ", mobileRegex));
        System.out.println("Parent Details : \n");
        student.setStudentParentName(scan("Parent Name"));
        student.setStudentParentMobile(scan("Mobile no ", mobileRegex));
        student.setStudentParentEmailId(scan("Email Id", emailRegex));
        student.setStudentReferenceName(scan(("Reference Name")));
        studentService.update(student);
    }

    @Override
    public void find(Integer id) {
        StudentDTO student = studentService.find(id);
        if (student == null) {
            System.out.println(findErrorMsg);
            return;
        }
        System.out.println(student + "\n" );
    }

    @Override
    public void findAll() {
        List<StudentDTO> students = studentService.findAll();
        if (students.size() == 0) {
            System.out.println(findErrorMsg);
            return;
        }
        System.out.println("Students : \n\n");
        for (int loopCounter = 0; loopCounter < students.size(); loopCounter++) {
            StudentDTO student = students.get(loopCounter);
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

        System.out.printf("%s %s %n %s %n", pretty, systemName, pretty);
        while (true) {
            System.out.println(functionalityOptions);
            choice = Integer.parseInt(scan("Choice"));
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
                    int studentId = Integer.parseInt(scan("Student Id"));
                    find(studentId);
                    break;
                case 5:
                    findAll();
                    break;
                case 6:
                    loopBreak = 1;
                    break;
                default:
                    System.out.printf(scanningErrorMsg,"Choice");
                    break;
            }
            if (loopBreak == 1)
                break;
        }
    }

}
