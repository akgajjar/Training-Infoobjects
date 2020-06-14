package com.infoobjects.tms.utils;

import com.infoobjects.tms.dto.Data;
import com.infoobjects.tms.dto.DisplayAllData;
import com.infoobjects.tms.dto.SubmitButton;
import com.infoobjects.tms.entity.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.infoobjects.tms.utils.TmsUtils.*;
import static com.infoobjects.tms.utils.ConfigurationAndGenericConstants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.infoobjects.tms.utils.ShowAllDataConstants.*;
import static com.infoobjects.tms.utils.ShowAllDataConstants.showAllTeachersHeading;

public class TeacherUtils {

    /**
     * Logger for Logging Events
     */
    private static final Logger logger = LoggerFactory.getLogger(TeacherUtils.class);

    // Teacher Mapping Constants
    public final static String insertTeacherMapping = "/insertTeacher";
    public final static String updateTeacherMapping = "/updateTeacher";
    public final static String deleteTeacherMapping = "/teacher/delete/";
    public final static String showAllTeachersMapping = "/showAllTeachers";
    public final static String viewTeacherFullDetailsMapping = "/teacher/viewFullDetails/";
    public final static String updateTeacherFormMapping = "/teacher/updateTeacherForm/";

    //Jsp File Name Constants Related to Teacher
    public final static String insertTeacherFile = "insertTeacher";
    public final static String showTeacherFullDetailsFile = "showTeacherFullDetails";
    public final static String updateTeacherFile = "updateTeacher";

    /**
     * used to convert List of Teacher Data into DisplayALlData which are used for
     * render using generic show all page
     *
     * @param teachers List of Teachers
     * @return DisplayAllData
     */
    public static DisplayAllData teacherToDisplayAllData(List<Teacher> teachers) {
        DisplayAllData displayAllData = new DisplayAllData();
        List<Data> dataToDisplay = new ArrayList<Data>();

        for (Teacher teacher : teachers) {

            Data dataOfTeacher = new Data();

            Map<String, SubmitButton> submitButtons = new HashMap<String, SubmitButton>();

            submitButtons.put(viewFullDetailsText, createSubmitButton(stringConcat(viewTeacherFullDetailsMapping, teacher.getTeacherId()), getMethod, viewFullDetailsText));
            submitButtons.put(updateHeaderText, createSubmitButton(stringConcat(updateTeacherFormMapping, teacher.getTeacherId()), getMethod, updateHeaderText));
            submitButtons.put(deleteHeaderText, createSubmitButton(stringConcat(deleteTeacherMapping, teacher.getTeacherId()), postMethod, deleteHeaderText));

            Map<String, String> data = new HashMap<String, String>();
            data.put(teacherIdHeaderText, teacher.getTeacherId());
            data.put(teacherNameHeaderText, teacher.getTeacherName());
            data.put(designationHeaderText, teacher.getTeacherDesignation().toString());

            dataOfTeacher.setData(data);
            dataOfTeacher.setSubmitButtons(submitButtons);

            dataToDisplay.add(dataOfTeacher);
        }

        displayAllData.setDataHeaders(createHeaderList(teacherIdHeaderText, teacherNameHeaderText, designationHeaderText));
        displayAllData.setButtonsHeaders(createHeaderList(viewFullDetailsText, updateHeaderText, deleteHeaderText));
        displayAllData.setDataToDisplay(dataToDisplay);
        displayAllData.setDisplayAllDataHeading(showAllTeachersHeading);

        logger.info("SuccessFully Converted from List of Teachers to DisplayAllData");

        return displayAllData;
    }

}