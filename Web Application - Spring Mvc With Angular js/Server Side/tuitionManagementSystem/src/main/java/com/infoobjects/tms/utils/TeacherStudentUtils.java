package com.infoobjects.tms.utils;

import com.infoobjects.tms.dto.Data;
import com.infoobjects.tms.dto.DisplayAllData;
import com.infoobjects.tms.dto.SubmitButton;
import com.infoobjects.tms.dto.TeacherStudent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.infoobjects.tms.utils.TmsUtils.*;
import static com.infoobjects.tms.utils.ConfigurationAndGenericConstants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.infoobjects.tms.utils.ShowAllDataConstants.*;

public class TeacherStudentUtils {

    /**
     * Logger for Logging Events
     */
    private static final Logger logger = LoggerFactory.getLogger(TeacherStudentUtils.class);

    // Teacher Student Mapping Constants
    public final static String insertTeacherStudentMapping = "/insertTeacherStudent";
    public final static String showAllTeacherStudentMapping = "/showAllTeacherStudents";
    public final static String getStudentByTeacherIdFormMapping = "/getStudentsByTeacherIdForm";
    public final static String getStudentByTeacherIdMapping = "/getStudentsByTeacherId";
    public final static String deleteTeacherStudentMapping = "/teacherStudent/delete/";

    // Jsp File Name Constants for TeacherStudent
    public final static String insertTeacherStudentMappingFile = "insertTeacherStudentMapping";
    public final static String showStudentsByTeacherIdFile = "showStudentsByTeacherId";
    public final static String showStudentsByTeacherIdFormFile = "showStudentsByTeacherIdForm";

    /**
     * used to convert List of TeacherStudent Mapping Data into DisplayALlData which
     * are used for render using generic show all page
     *
     * @param teacherStudents List of TeacherStudents
     * @return teacherStudents
     */
    public static DisplayAllData teacherStudentToDisplayAllData(List<TeacherStudent> teacherStudents) {

        DisplayAllData displayAllData = new DisplayAllData();
        List<Data> dataToDisplay = new ArrayList<Data>();

        for (TeacherStudent teacherStudent : teacherStudents) {

            Data dataOfTeacher = new Data();

            Map<String, SubmitButton> submitButtons = new HashMap<String, SubmitButton>();

            submitButtons.put(deleteHeaderText, createSubmitButton(stringConcat(deleteTeacherStudentMapping, teacherStudent.getStudentId(), linkSeperator, teacherStudent.getTeacherId()),
                    postMethod, deleteHeaderText));

            Map<String, String> data = new HashMap<String, String>();
            data.put(studentIdHeaderText, teacherStudent.getStudentId());
            data.put(studentNameHeaderText, teacherStudent.getStudentName());
            data.put(teacherIdHeaderText, teacherStudent.getTeacherId());
            data.put(teacherNameHeaderText, teacherStudent.getTeacherName());

            dataOfTeacher.setData(data);
            dataOfTeacher.setSubmitButtons(submitButtons);

            dataToDisplay.add(dataOfTeacher);
        }

        displayAllData.setDataHeaders(createHeaderList(studentIdHeaderText, studentNameHeaderText, teacherIdHeaderText, teacherNameHeaderText));
        displayAllData.setButtonsHeaders(createHeaderList(deleteHeaderText));
        displayAllData.setDataToDisplay(dataToDisplay);
        displayAllData.setDisplayAllDataHeading(showAllTeacherStudentsHeading);

        logger.info("SuccessFully Converted from List of TeacherStudents to DisplayAllData");

        return displayAllData;
    }

}
