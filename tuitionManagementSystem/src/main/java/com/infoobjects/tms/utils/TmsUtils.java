package com.infoobjects.tms.utils;

import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.enums.Designation;
import com.infoobjects.tms.enums.Gender;
import com.infoobjects.tms.enums.OperationType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class TmsUtils {

    public static String emailRegex = "[a-zA_Z0-9]+[@]{1}[a-zA_Z0-9]+[.]{1}[a-zA_Z0-9]{2,3}";
    public static String mobileRegex = "(0/91)?[7-9][0-9]{9}";
    public static String digitRegex = "\\d";
    public static String doubleRegex ="[0-9]{1,13}(\\\\.[0-9]+)?";
    public static String stringRegex = "[a-zA-Z ]+";
    public static String exclamationMark = "!!!!!!!!!!";
    public static String scanningErrorMsg = "\nInvalid %s " + exclamationMark + "\n\n";
    public static String findErrorMsg = "\nNo %s Found " + exclamationMark + "\n\n";
    public static String nullErrorMsg = "\nNull Value Found Please Enter Correct Value" + exclamationMark + "\n\n";
    public static String duplicatePrimaryKeyErrorMsg = "\nDuplicate Value for Primary Key" + exclamationMark + "\n\n";
    public static String selectErrorMsg = "\nEnter Single Digit as Input " + exclamationMark + "\n\n";
    public static String integerOnlyErrorMsg = "\nplease Enter integer Value only" + exclamationMark + "\n\n";
    public static String doubleOnlyErrorMsg = "\nplease Enter double Value only" + exclamationMark + "\n\n";
    public static String stringOnlyErrorMsg = "\nplease Enter Character only" + exclamationMark + "\n\n";
    public static String insertSuccessmsg = "\nInserted SuccessFully" + exclamationMark+ "\n\n";
    public static String deleteSuccessmsg = "\nDeleted SuccessFully" + exclamationMark+ "\n\n";
    public static String updateSuccessmsg = "\nUpdated SuccessFully" + exclamationMark+ "\n\n";

    public static boolean patternMatch(String pattern, String value, String errorMsg) {
        Pattern patternRef = Pattern.compile(pattern);
        boolean checkResult = patternRef.matcher(value).matches();
        if (checkResult == false) {
            printErrors(errorMsg);
            return false;
        }
        return true;
    }

    public static void printErrors(String errorMsg) {
        System.out.println(errorMsg);
    }

    public static boolean checkNull(String value, OperationType operationType) {
        if(operationType == OperationType.UPDATE)
            return false;
        if (value == null) {
            printErrors(nullErrorMsg);
            return true;
        } else {
            return false;
        }
    }

    public static String scan(String msg, String regex, String errorMsg, OperationType operationType) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String returnValue = null;
        while (true) {
            System.out.println("\nEnter " + msg + " : ");
            returnValue = br.readLine();
            if (checkNull(returnValue, operationType)) {
                continue;
            }
            else if (regex != null) {
                if (patternMatch(regex, returnValue, errorMsg)) {
                    break;
                }
            }
            else{
                break;
            }
        }
        return returnValue;
    }

    public static Gender scanGender(OperationType operationType) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gender gender = null;
        int loopBreak = 0;
        String inputValue = null;
        while (true) {
            System.out.println("\nSelect Student Gender : \n1. Male\n2. Female\n");
            inputValue = br.readLine();
            if (checkNull(inputValue,operationType)) {
                continue;
            } else if (patternMatch(digitRegex, inputValue, selectErrorMsg)) {
                if(inputValue == null){
                    gender = Gender.NONE;
                    break;
                }
                int choice = Integer.parseInt(inputValue);
                switch (choice) {
                    case 1:
                        gender = Gender.MALE;
                        loopBreak = 1;
                        break;
                    case 2:
                        gender = Gender.FEMALE;
                        loopBreak = 1;
                        break;

                    default:
                        printErrors(String.format(scanningErrorMsg, "Gender"));
                }
            }
            if (loopBreak == 1)
                break;
        }
        return gender;
    }

    public static Designation scanDesignation(OperationType operationType) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Designation designation = null;
        int loopBreak = 0;
        String inputValue = null;
        while (true) {
            System.out.println("\nSelect Teacher Designation: \n1. Professor\n2. Teaching Assistance\n3. Lab Staff");
            inputValue = br.readLine();
            if (checkNull(inputValue,operationType)) {
                continue;
            } else if (patternMatch(digitRegex, inputValue, selectErrorMsg)) {
                if(inputValue == null){
                    designation = Designation.NONE;
                    break;
                }
                int choice = Integer.parseInt(inputValue);
                switch (choice) {
                    case 1:
                        designation = Designation.PROFESSOR;
                        loopBreak = 1;
                        break;
                    case 2:
                        designation = Designation.TEACHINGASSISTANCE;
                        loopBreak = 1;
                        break;
                    case 3:
                        designation = Designation.LABSTAFF;
                        loopBreak = 1;
                        break;
                    default:
                        printErrors(String.format(scanningErrorMsg, "Designation"));
                }
            }
            if (loopBreak == 1)
                break;
        }
        return designation;
    }

    public static String genericToString(DTO reference) {
        StringBuffer returnValue = new StringBuffer();
        Class classReference = reference.getClass();
        Field[] fields = classReference.getDeclaredFields();
        for (int loopCounter = 0; loopCounter < fields.length; loopCounter++) {
            try {
                returnValue.append(fields[loopCounter].getName());
                returnValue.append(" : ");
                returnValue.append(String.valueOf(fields[loopCounter].get(reference)));
                returnValue.append("\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnValue.toString();
    }

}
