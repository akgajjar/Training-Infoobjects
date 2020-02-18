package com.infoobjects.tms.enums;

public enum Designation {

    PROFESSOR("PROFESSOR"),
    TEACHING_ASSISTANCE("TEACHING_ASSISTANCE"),
    LAB_STAFF("LAB_STAFF"),
    NONE("NONE");

    private String designationValue;
    Designation(String designationValue) {
        this .designationValue = designationValue;
    }

    public String getDesignationValue() {
        return designationValue;
    }

}
