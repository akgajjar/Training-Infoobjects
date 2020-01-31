package com.infoobjects.tms.enums;

public enum OperationType {

    INSERT("Insert"),
    UPDATE("Update"),
    DELETE("Delete"),
    FIND("Find"),
    CHOICE("Choice"),
    FINDALL("Find All"),
    PRINT("Print");

    OperationType(String operationType) {
        this.operationType = operationType;
    }

    private  String operationType;

    }
