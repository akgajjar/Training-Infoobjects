package com.infoobjects.tms.enums;

/**
 * @author Aniket
 * @description Enum Class - used to hold Designation Value for Teacher
 */
public enum Designation {

    /**
     * EnumValues
     */
    PROFESSOR("PROFESSOR"),
    TEACHING_ASSISTANCE("TEACHING_ASSISTANCE"),
    LAB_STAFF("LAB_STAFF"),
    NONE("NONE");

    private String designationValue;

    /**
     * Default Constructor
     * @param designationValue
     */
    Designation(String designationValue) {
        this .designationValue = designationValue;
    }

    /**
     * getter Method for Enum
     */
    public String getDesignationValue() {
        return designationValue;
    }

}
