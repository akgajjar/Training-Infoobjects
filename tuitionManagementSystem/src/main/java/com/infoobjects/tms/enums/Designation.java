package com.infoobjects.tms.enums;

public enum Designation {

    PROFESSOR("Professor"),
    TEACHINGASSISTANCE("Teaching Assistance"),
    LABSTAFF("Lab Staff"),
    NONE("None");

    private String designationValue;
    Designation(String designationValue) {
        this .designationValue = designationValue;
    }

    public String getDesignationValue() {
        return designationValue;
    }

}
