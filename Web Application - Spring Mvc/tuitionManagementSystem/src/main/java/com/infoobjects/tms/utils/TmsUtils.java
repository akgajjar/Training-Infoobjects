package com.infoobjects.tms.utils;

import com.fasterxml.uuid.Generators;
import com.infoobjects.tms.dto.SubmitButton;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aniket
 * @description Utility Class used contains of Utility methods and constants
 * common between all classes
 */
public class TmsUtils {

    /**
     * used to generate random uuid String
     *
     * @return String
     */
    public static String uuidGeneration() {
        return Generators.randomBasedGenerator().generate().toString();
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
