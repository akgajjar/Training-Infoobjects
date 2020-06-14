package com.infoobjects.tms.utils;

import com.fasterxml.uuid.Generators;
import com.infoobjects.tms.dto.interfaces.DTO;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Aniket
 * @description Utility Class used contains of Utility methods and constants
 * common between all classes
 */
public class TmsUtils {

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
