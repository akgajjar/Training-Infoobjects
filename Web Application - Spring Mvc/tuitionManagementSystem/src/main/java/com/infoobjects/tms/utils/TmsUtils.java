package com.infoobjects.tms.utils;

import com.fasterxml.uuid.Generators;
import com.infoobjects.tms.dto.Data;
import com.infoobjects.tms.dto.DisplayAllData;
import com.infoobjects.tms.dto.SubmitButton;
import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.entity.Teacher;

import static com.infoobjects.tms.utils.ShowAllDataConstants.*;
import static com.infoobjects.tms.utils.StudentUtils.*;
import static com.infoobjects.tms.utils.TeacherUtils.*;
import static com.infoobjects.tms.utils.TeacherStudentUtils.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Aniket
 * @description Utility Class used contains of Utility methods and constants
 * common between all classes
 */
public class TmsUtils {

    // Form Method Constants
    public final static String getMethod = "get";
    public final static String postMethod = "post";

    // Link Related Constants
    public final static String linkSeperator = "/";

    // Common Jsp File Name Constants
    public final static String indexFile = "index";
    public final static String headerFile = "header";
    public final static String showAllGenericPageFile = "showAllGenericPage";

    /**
     * Logger for Logging Events
     */
    private static final Logger logger = LoggerFactory.getLogger(TmsUtils.class);


    /**
     * used to generate random uuid String
     *
     * @return String
     */
    public static String uuidGeneration() {
        return Generators.randomBasedGenerator().generate().toString();
    }

    /**
     * used to print dto objects
     *
     * @param reference
     * @return String
     */
    public static String genericToString(DTO reference) {
        StringBuilder returnValue = new StringBuilder();
        Class classReference = reference.getClass();
        Field[] fields = classReference.getDeclaredFields();

        returnValue.append(reference.getClass().getName());
        returnValue.append(" [ ");
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                returnValue.append(field.getName());
                returnValue.append(" = ");
                returnValue.append(field.get(reference));
                returnValue.append(", ");
            } catch (Exception exception) {
                logger.error("%s can not be converted into string ", reference.getClass().getName());
                exception.printStackTrace();
            }
        }
        returnValue.append(" ]");
        return returnValue.toString();
    }

    /**
     * used to create Submit Button Instance
     *
     * @param formAction  Form's Action value
     * @param formMethod  Form's method type
     * @param buttonValue Button's value
     * @return SubmitButton
     */
    public static SubmitButton createSubmitButton(String formAction, String formMethod, String buttonValue) {
        return new SubmitButton(formAction, formMethod, buttonValue);
    }

    /**
     * used to create header List
     *
     * @param values Variable String Arguments
     * @return List<String>
     */
    public static List<String> createHeaderList(String... values) {
        List<String> headerList = new ArrayList<String>();
        for (String value : values) {
            headerList.add(value);
        }
        return headerList;
    }

    /**
     * used to concat String
     *
     * @param values Variable String Arguments
     * @return String
     */
    public static String stringConcat(String... values) {
        StringBuilder concatString = new StringBuilder();

        for (String value : values) {
            concatString.append(value);
        }

        return concatString.toString();
    }


}
