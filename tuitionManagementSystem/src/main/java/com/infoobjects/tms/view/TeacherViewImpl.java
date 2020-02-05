package com.infoobjects.tms.view;

import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.dto.StudentDTO;
import com.infoobjects.tms.dto.TeacherDTO;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.enums.Designation;
import com.infoobjects.tms.enums.OperationType;
import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.service.TeacherServiceImpl;
import com.infoobjects.tms.view.interfaces.TeacherViewIncrement;

import java.io.IOException;
import java.util.List;

import static com.infoobjects.tms.utils.TmsUtils.*;

public class TeacherViewImpl implements TeacherViewIncrement<Integer, TeacherDTO> {

    private TeacherServiceImpl teacherService;
    private StudentServiceImpl studentService;

    public TeacherViewImpl(TeacherServiceImpl teacherService, StudentServiceImpl studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @Override
    public void insert() throws IOException {

        TeacherDTO teacher = new TeacherDTO();
        System.out.println("\nEnter Teacher Details : ");
        teacher.setTeacherId(Integer.parseInt(scan("Teacher Id", digitRegex + "+", integerOnlyErrorMsg, OperationType.INSERT)));
        if (teacherService.find(teacher.getTeacherId()) != null) {
            printErrors(duplicatePrimaryKeyErrorMsg);
            return;
        }
        teacher.setTeacherSalary(Double.parseDouble(scan("Salary", doubleRegex, doubleOnlyErrorMsg, OperationType.INSERT)));
        teacher.setTeacherName(scan("Teacher Name", stringRegex, stringOnlyErrorMsg, OperationType.INSERT));
        teacher.setTeacherMobile(scan("Mobile No", mobileRegex, String.format(scanningErrorMsg, "Mobile No"), OperationType.INSERT));
        teacher.setTeacherEmailId(scan("Email Id", emailRegex, String.format(scanningErrorMsg, "Email Id"), OperationType.INSERT));
        teacher.setTeacherDesignation(scanDesignation(OperationType.INSERT));
        teacher.setTeacherAddress(scan("Teacher Address", null, null, OperationType.INSERT));
        teacherService.insert(teacher);
    }

    @Override
    public void delete() throws NumberFormatException, IOException {
        int teacherId = Integer.parseInt(scan("Teacher Id", digitRegex + "+", integerOnlyErrorMsg, OperationType.DELETE));
        if (teacherService.find(teacherId) == null) {
            printErrors(String.format(findErrorMsg, "Teacher"));
            return;
        }
        teacherService.delete(teacherId);
    }

    @Override
    public void update() throws IOException {
        String tempScanning;
        TeacherDTO teacher = new TeacherDTO();
        System.out.println("\nEnter Teacher Details : ");
        teacher.setTeacherId(Integer.parseInt(scan("Teacher Id", digitRegex + "+", integerOnlyErrorMsg, OperationType.UPDATE)));
        TeacherDTO teacherDTO = find(teacher.getTeacherId());
        if (teacherDTO == null) {
            printErrors(String.format(findErrorMsg, "Teacher"));
            return;
        }
        tempScanning = scan("Salary", doubleRegex, doubleOnlyErrorMsg, OperationType.UPDATE);
        if (checkNull(tempScanning))
            teacher.setTeacherSalary(0.0);
        else
            teacher.setTeacherSalary(Double.parseDouble(tempScanning));
        tempScanning = scan("Teacher Name", stringRegex, stringOnlyErrorMsg, OperationType.UPDATE);
        if (checkNull(tempScanning))
            teacher.setTeacherName(teacherDTO.getTeacherName());
        else
            teacher.setTeacherName(tempScanning);
        tempScanning = scan("Mobile No", mobileRegex, String.format(scanningErrorMsg, "Mobile No"), OperationType.UPDATE);
        if (checkNull(tempScanning))
            teacher.setTeacherMobile(teacherDTO.getTeacherMobile());
        else
            teacher.setTeacherMobile(tempScanning);
        tempScanning = scan("Email Id", emailRegex, String.format(scanningErrorMsg, "Email Id"), OperationType.UPDATE);
        if (checkNull(tempScanning))
            teacher.setTeacherEmailId(teacherDTO.getTeacherEmailId());
        else
            teacher.setTeacherEmailId(tempScanning);
        teacher.setTeacherDesignation(scanDesignation(OperationType.UPDATE));
        if (teacher.getTeacherDesignation() == Designation.NONE)
            teacher.setTeacherDesignation(teacherDTO.getTeacherDesignation());
        tempScanning = scan("Teacher Address", null, null, OperationType.UPDATE);
        if (!checkNull(tempScanning)) teacher.setTeacherAddress(tempScanning);
        else teacher.setTeacherAddress(teacherDTO.getTeacherAddress());
        teacherService.update(teacher);
    }

    @Override
    public TeacherDTO find(Integer id) {
        TeacherDTO teacherDTO = teacherService.find(id);
        if (teacherDTO == null) {
            printErrors(String.format(findErrorMsg, "Teacher"));
            return null;
        }
        System.out.println(teacherDTO + "\n");
        return teacherDTO;
    }

    @Override
    public void findAll() {
        List<TeacherDTO> teachers = teacherService.findAll();
        if (teachers.size() == 0) {
            printErrors(String.format(findErrorMsg, "Teacher"));
            return;
        }
        System.out.println("Teachers : \n\n");
        for (DTO teacherDTO : teachers) {
            System.out.println(teacherDTO + "\n");
        }
    }

    @Override
    public void insertStudent() throws Exception {
        int teacherId = Integer.parseInt(scan("Teacher Id", digitRegex + "+", integerOnlyErrorMsg, OperationType.INSERT));
        int studentId = Integer.parseInt(scan("Student Id", digitRegex + "+", integerOnlyErrorMsg, OperationType.INSERT));
        if (studentService.find(studentId) == null) {
            printErrors(String.format(findErrorMsg, "Student"));
            return;
        }
        if (teacherService.find(teacherId) == null) {
            printErrors(String.format(findErrorMsg, "Teacher"));
            return;
        }
        teacherService.insertStudent(studentId, teacherId);
    }

    @Override
    public void showAllStudent() throws IOException {
        int teacherId = Integer.parseInt(scan("Teacher Id", digitRegex + "+", integerOnlyErrorMsg, OperationType.INSERT));
        if (teacherService.find(teacherId) == null) {
            printErrors(String.format(findErrorMsg, "Teacher"));
            return;
        }
        List<StudentDTO> students = teacherService.showAllStudent(teacherId, (StudentDAOImpl) studentService.getStudentDao());
        if (students.size() == 0) {
            printErrors(String.format(findErrorMsg, "Student"));
            return;
        }
        System.out.println("\n\nStudents : ");
        for (DTO studentDTO : students) {
            System.out.println(studentDTO + "\n");
        }
    }

    @Override
    public void mainView() throws Exception {

        int choice;
        StringBuilder functionalityOptions = new StringBuilder();
        functionalityOptions.append("%n %n1) Insert Teacher %n");
        functionalityOptions.append("2) Update Teacher %n");
        functionalityOptions.append("3) Delete Teacher %n");
        functionalityOptions.append("4) Find Teacher %n");
        functionalityOptions.append("5) Find all Teacher %n");
        functionalityOptions.append("6) Insert Student %n");
        functionalityOptions.append("7) Show all Students %n");
        functionalityOptions.append("8) Exit");

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
                    int teacherId = Integer.parseInt(scan("Teacher Id", digitRegex + "+", integerOnlyErrorMsg, OperationType.FIND));
                    find(teacherId);
                    break;
                case 5:
                    findAll();
                    break;
                case 6:
                    insertStudent();
                    break;
                case 7:
                    showAllStudent();
                    break;
                case 8:
                    return;
                default:
                    printErrors(String.format(scanningErrorMsg, "Choice"));
                    break;
            }
        }
    }

}
