package com.infoobjects.tms.enums;

/**
 * @author Aniket
 * @description Enum Class - used to hold Gender Value for Student
 */
public enum Gender {

        /**
         * EnumValues
         */
        MALE("Male"),
        FEMALE("Female"),
        NONE("None");

        private  String genderValue;

        /**
         * Default Constructor
         * @param genderValue
         */
        Gender(String genderValue) {
                this.genderValue = genderValue;
        }

        /**
         * getter Method for Enum
         */
        public String getGenderValue() {
                return genderValue;
        }

}
