package com.infoobjects.tms.utils;

import com.infoobjects.tms.dto.Data;
import com.infoobjects.tms.dto.DisplayAllData;
import com.infoobjects.tms.dto.SubmitButton;
import com.infoobjects.tms.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import  static  com.infoobjects.tms.utils.TmsUtils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.infoobjects.tms.utils.ShowAllDataConstants.*;

public class StudentUtils {

    /**
     * Logger for Logging Events
     */
    private static final Logger logger = LoggerFactory.getLogger(StudentUtils.class);

    // Common mapping
    public final static String startupMapping = "/";
    public final static String homeMapping = "/home";

    // Student Mapping Constants
    public final static String insertStudentMapping = "/insertStudent";
    public final static String updateStudentMapping = "/updateStudent";
    public final static String deleteStudentMapping = "/student/delete/";
    public final static String showAllStudentsMapping = "/showAllStudents";
    public final static String viewStudentFullDetailsMapping = "/student/viewFullDetails/";
    public final static String updateStudentFormMapping = "/student/updateStudentForm/";
    public final static String viewTeacherNameMapping = "/student/viewTeacherName/";

    //Jsp File Name Constants
    public final static String insertStudentFile = "insertStudent";
    public final static String showStudentFullDetailsFile = "showStudentFullDetails";
    public final static String showTeacherNameFile = "showTeacherName";
    public final static String updateStudentFile = "updateStudent";

    /**
     * used to convert List of Student Data into DisplayALlData which are used for
     * render using generic show all page
     *
     * @param students List of Students
     * @return DisplayAllData
     */
    public static DisplayAllData studentToDisplayAllData(List<Student> students) {
        DisplayAllData displayAllData = new DisplayAllData();
        List<Data> dataToDisplay = new ArrayList<Data>();

        for (Student student : students) {

            Data dataOfStudent = new Data();

            Map<String, SubmitButton> submitButtons = new HashMap<String, SubmitButton>();
            submitButtons.put(viewFullDetailsText, createSubmitButton(stringConcat(viewStudentFullDetailsMapping, student.getStudentId()), getMethod, viewFullDetailsText));
            submitButtons.put(viewTeacherNameText, createSubmitButton(stringConcat(viewTeacherNameMapping, student.getStudentId()), getMethod, viewTeacherNameText));
            submitButtons.put(updateHeaderText, createSubmitButton(stringConcat(updateStudentFormMapping, student.getStudentId()), getMethod, updateHeaderText));
            submitButtons.put(deleteHeaderText, createSubmitButton(stringConcat(deleteStudentMapping, student.getStudentId()), postMethod, deleteHeaderText));

            Map<String, String> data = new HashMap<String, String>();
            data.put(studentIdHeaderText, student.getStudentId());
            data.put(studentNameHeaderText, student.getStudentName());
            data.put(classHeaderText, String.valueOf(student.getStudentClass()));

            dataOfStudent.setData(data);
            dataOfStudent.setSubmitButtons(submitButtons);

            dataToDisplay.add(dataOfStudent);
        }

        displayAllData.setDataHeaders(createHeaderList(studentIdHeaderText, studentNameHeaderText, classHeaderText));
        displayAllData.setButtonsHeaders(createHeaderList(viewFullDetailsText, viewTeacherNameText, updateHeaderText, deleteHeaderText));
        displayAllData.setDataToDisplay(dataToDisplay);
        displayAllData.setDisplayAllDataHeading(showAllStudentsHeading);

        logger.info("SuccessFully Converted from List of Students to DisplayAllData");

        return displayAllData;
    }


}
