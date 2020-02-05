package com.infoobjects.tms.view;

import com.infoobjects.tms.dto.StudentDTO;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.enums.Gender;
import com.infoobjects.tms.enums.OperationType;
import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.service.interfaces.Service;
import com.infoobjects.tms.view.interfaces.View;

import java.io.IOException;
import java.util.List;

import static com.infoobjects.tms.utils.TmsUtils.*;

public class StudentViewImpl implements View<Integer, StudentDTO> {

    private static Service<Integer, StudentDTO> studentService = null;

    public StudentViewImpl(StudentServiceImpl serviceImpl) {
        studentService = serviceImpl;
    }

    @Override
    public void insert() throws IOException {
        StudentDTO student = new StudentDTO();
        System.out.println("\nEnter Student Details : ");
        student.setStudentId(Integer.parseInt(scan("Student Id", digitRegex + "+", integerOnlyErrorMsg, OperationType.INSERT)));
        if (studentService.find(student.getStudentId()) != null) {
            printErrors(duplicatePrimaryKeyErrorMsg);
            return;
        }
        student.setStudentName(scan("Student Name", stringRegex, stringOnlyErrorMsg, OperationType.INSERT));
        student.setStudentAddress(scan("Student Address", null, null, OperationType.INSERT));
        student.setStudentEmailId(scan("Email Id", emailRegex, String.format(scanningErrorMsg, "Email Id"), OperationType.INSERT));
        student.setStudentGender(scanGender(OperationType.INSERT));
        student.setStudentMobile(scan("Mobile No", mobileRegex, String.format(scanningErrorMsg, "Mobile No"), OperationType.INSERT));
        System.out.println("\nEnter Parent Details : ");
        student.setStudentParentName(scan("Student Parent Name", stringRegex, stringOnlyErrorMsg, OperationType.INSERT));
        student.setStudentParentMobile(scan("Mobile No", mobileRegex, String.format(scanningErrorMsg, "Mobile No"), OperationType.INSERT));
        student.setStudentParentEmailId(scan("Email Id", emailRegex, String.format(scanningErrorMsg, "Email Id"), OperationType.INSERT));
        student.setStudentReferenceName(scan("Reference Name", stringRegex, stringOnlyErrorMsg, OperationType.INSERT));
        studentService.insert(student);
    }

    @Override
    public void delete() throws NumberFormatException, IOException {
        int studentId = Integer.parseInt(scan("Student Id", digitRegex + "+", integerOnlyErrorMsg, OperationType.DELETE));
        if (studentService.find(studentId) == null) {
            printErrors(String.format(findErrorMsg, "Student"));
            return;
        }
        studentService.delete(studentId);
    }

    @Override
    public void update() throws IOException {
        int studentId = Integer.parseInt(scan("Student Id", digitRegex + "+", integerOnlyErrorMsg, OperationType.FIND));
        StudentDTO studentDTO = find(studentId);
        if (studentDTO == null) {
            printErrors(String.format(findErrorMsg, "Student"));
            return;
        }
        String tempScanning;
        StudentDTO student = new StudentDTO();
        student.setStudentId(studentId);
        System.out.println("\nEnter Student Details : ");
        tempScanning = scan("Student Name", stringRegex, stringOnlyErrorMsg, OperationType.UPDATE);
        if(tempScanning == null)
            student.setStudentName(studentDTO.getStudentName());
        else
            student.setStudentName(tempScanning);
        tempScanning = scan("Student Address", null, null, OperationType.UPDATE);
        if(tempScanning == null)
            student.setStudentAddress(studentDTO.getStudentAddress());
        else
            student.setStudentAddress(tempScanning);
        tempScanning = scan("Email Id", emailRegex, String.format(scanningErrorMsg, "Email Id"), OperationType.UPDATE);
        if(tempScanning == null)
            student.setStudentEmailId(studentDTO.getStudentEmailId());
        else
            student.setStudentEmailId(tempScanning);
        student.setStudentGender(scanGender(OperationType.UPDATE));
        if(student.getStudentGender() == Gender.NONE)
            student.setStudentGender(studentDTO.getStudentGender());
        tempScanning = scan("Mobile No", mobileRegex, String.format(scanningErrorMsg, "Mobile No"), OperationType.UPDATE);
        if(tempScanning == null)
            student.setStudentMobile(studentDTO.getStudentMobile());
        else
            student.setStudentMobile(tempScanning);
        System.out.println("\nEnter Parent Details : \n");
        tempScanning = scan("Student Parent Name", stringRegex, stringOnlyErrorMsg, OperationType.UPDATE);
        if(tempScanning == null)
            student.setStudentParentName(studentDTO.getStudentParentName());
        else
            student.setStudentParentName(tempScanning);
        tempScanning = scan("Mobile No", mobileRegex, String.format(scanningErrorMsg, "Mobile No"), OperationType.UPDATE);
        if(tempScanning == null)
            student.setStudentParentMobile(studentDTO.getStudentParentMobile());
        else
            student.setStudentParentMobile(tempScanning);
        tempScanning = scan("Email Id", emailRegex, String.format(scanningErrorMsg, "Email Id"), OperationType.UPDATE);
        if(tempScanning == null)
            student.setStudentParentEmailId(studentDTO.getStudentParentEmailId());
        else
            student.setStudentParentEmailId(tempScanning);
        tempScanning = scan("Reference Name", stringRegex, stringOnlyErrorMsg, OperationType.UPDATE);
        if(tempScanning == null)
            student.setStudentReferenceName(studentDTO.getStudentReferenceName());
        else
            student.setStudentReferenceName(tempScanning);
        student.updateDTOCheck(studentDTO);
        studentService.update(student);
    }

    @Override
    public StudentDTO find(Integer id) {
        StudentDTO student = studentService.find(id);
        if (student == null) {
            printErrors(String.format(findErrorMsg, "Student"));
            return null;
        }
        System.out.println(student + "\n");
        return student;
    }

    @Override
    public void findAll() {
        List<StudentDTO> students = studentService.findAll();
        if (students.size() == 0) {
            printErrors(String.format(findErrorMsg, "Student"));
            return;
        }
        System.out.println("Students : \n\n");
        for (DTO studentDTO : students) {
            System.out.println(studentDTO + "\n");
        }
    }

    public void mainView() throws Exception {
        int choice;
        StringBuilder functionalityOptions = new StringBuilder();

        functionalityOptions.append("%n %n1) Insert Student %n");
        functionalityOptions.append("2) Update Student %n");
        functionalityOptions.append("3) Delete Student %n");
        functionalityOptions.append("4) Find Student %n");
        functionalityOptions.append("5) Find all Student %n");
        functionalityOptions.append("6) Exit");

        while (true) {
            System.out.println(String.format(functionalityOptions.toString()));
            choice = Integer.parseInt(scan("Choice", digitRegex + "+", integerOnlyErrorMsg, OperationType.CHOICE));
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
                    int studentId = Integer.parseInt(scan("Student Id", digitRegex + "+", integerOnlyErrorMsg, OperationType.FIND));
                    find(studentId);
                    break;
                case 5:
                    findAll();
                    break;
                case 6:
                    return;
                default:
                    printErrors(String.format(scanningErrorMsg, "Choice"));
                    break;
            }
        }
    }

}
