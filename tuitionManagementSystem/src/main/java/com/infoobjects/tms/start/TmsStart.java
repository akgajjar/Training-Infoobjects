package com.infoobjects.tms.start;

import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.enums.OperationType;
import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.service.TeacherServiceImpl;
import com.infoobjects.tms.view.StudentViewImpl;
import com.infoobjects.tms.view.TeacherViewImpl;
import com.infoobjects.tms.view.interfaces.TeacherViewIncrement;
import com.infoobjects.tms.view.interfaces.View;

import static com.infoobjects.tms.utils.TmsUtils.*;

public class TmsStart {

    public static void main(String[] args) throws Exception {

        String pretty = "\n--------------------------------------------------------------------\n";
        String systemName = "\t\t\tTuition Management System\t\t\t";
        StringBuilder functionalityOptions = new StringBuilder();
        StudentServiceImpl studentService = new StudentServiceImpl();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        int choice, loopBreak = 0;

		teacherService.deleteStudents();

		System.out.printf(" %s %n %s %n %s %n", pretty, systemName, pretty);
        functionalityOptions.append("%n %n1) Student %n");
        functionalityOptions.append("2) Teacher %n");
        functionalityOptions.append("3) Exit %n");
        do {
            System.out.print(String.format(functionalityOptions.toString()));
            choice = Integer.parseInt(scan("Choice", digitRegex + "+", integerOnlyErrorMsg, OperationType.CHOICE));
            switch (choice) {
                case 1:
                    View<Integer, Student> studentView = new StudentViewImpl(studentService);
                    studentView.mainView();
                    break;
                case 2:
                    TeacherViewIncrement<Integer, Teacher> teacherView = new TeacherViewImpl(teacherService, studentService);
                    teacherView.mainView();
                    break;
                case 3:
                    loopBreak = 1;
                    break;
                default:
                    printErrors(String.format(scanningErrorMsg, "Choice"));
                    break;
            }

        } while (loopBreak != 1);

    }

}
