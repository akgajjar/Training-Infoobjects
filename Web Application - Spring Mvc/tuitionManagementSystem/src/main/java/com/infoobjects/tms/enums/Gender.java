package com.infoobjects.tms.enums;

public enum Gender {

        MALE("Male"),
        FEMALE("Female"),
        NONE("None");

        private  String genderValue;
        Gender(String genderValue) {
                this.genderValue = genderValue;
        }

}
