package com.infoobjects.tms.view;

import com.infoobjects.tms.dto.StudentDTO;
import com.infoobjects.tms.service.interfaces.Service;
import com.infoobjects.tms.service.StudentServiceImpl;
import static com.infoobjects.tms.utils.ProjectUtils.*;
import com.infoobjects.tms.view.interfaces.View;

import java.io.IOException;
import java.util.List;

public class StudentViewImpl implements View<Integer, StudentDTO> {

    private static Service<Integer, StudentDTO> studentService = null;

    public StudentViewImpl() {
        studentService = new StudentServiceImpl();
    }

    @Override
    public void insert() throws IOException {
        StudentDTO student = new StudentDTO();
        System.out.println("\nEnter Student Details : ");
        student.setStudentId(scanInteger("Student Id"));
        if(studentService.find(student.getStudentId()) != null){
            System.out.println(duplicatePrimaryKeyErrorMsg);
            return ;
        }
        student.setStudentName(scanString("Student Name"));
        student.setStudentAddress(scan("Student Address"));
        student.setStudentEmailId(scan("Email Id", emailRegex));
        student.setStudentGender(scanGender());
        student.setStudentMobile(scan("Mobile No", mobileRegex));
        System.out.println("\nEnter Parent Details : \n");
        student.setStudentParentName(scanString("Student Parent Name"));
        student.setStudentParentMobile(scan("Mobile No", mobileRegex));
        student.setStudentParentEmailId(scan("Email Id", emailRegex));
        student.setStudentReferenceName(scanString("Reference Name"));
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
        System.out.println("\nEnter Student Details : ");
        student.setStudentName(scanString("Name"));
        student.setStudentAddress(scan("Address"));
        student.setStudentEmailId(scan("Email Id", emailRegex));
        student.setStudentGender(scanGender());
        student.setStudentMobile(scan("Mobile no ", mobileRegex));
        System.out.println("\nEnter Parent Details : \n");
        student.setStudentParentName(scanString("Parent Name"));
        student.setStudentParentMobile(scan("Mobile no ", mobileRegex));
        student.setStudentParentEmailId(scan("Email Id", emailRegex));
        student.setStudentReferenceName(scanString(("Reference Name")));
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
            choice = scanInteger("Choice");
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
                    int studentId = scanInteger("Student Id");
                    find(studentId);
                    break;
                case 5:
                    findAll();
                    break;
                case 6:
                    return;
                default:
                    System.out.printf(scanningErrorMsg,"Choice");
                    break;
            }
        }
    }

}
