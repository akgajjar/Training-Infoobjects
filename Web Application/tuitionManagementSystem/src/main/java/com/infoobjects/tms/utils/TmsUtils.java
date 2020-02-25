package com.infoobjects.tms.utils;

import com.fasterxml.uuid.Generators;
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

    public static String camelCaseRegex = "([a-z])([A-Z]+)";
    public static String camelCaseReplacementRegex = "$1_$2";
    public static String emailRegex = "[a-zA_Z0-9]+[@]{1}[a-zA_Z0-9]+[.]{1}[a-zA_Z0-9]{2,3}";
    public static String mobileRegex = "(0/91)?[7-9][0-9]{9}";
    public static String digitRegex = "\\d";
    public static String doubleRegex = "[0-9]{1,13}(\\\\.[0-9]+)?";
    public static String stringRegex = "[a-zA-Z ]+";
    private static String exclamationMark = "!!!!!!!!!!";
    public static String scanningErrorMsg = "\nInvalid %s " + exclamationMark + "\n\n";
    public static String findErrorMsg = "\nNo %s Found " + exclamationMark + "\n\n";
    private static String nullErrorMsg = "\nNull Value Found Please Enter Correct Value" + exclamationMark + "\n\n";
    public static String duplicatePrimaryKeyErrorMsg = "\nDuplicate Value for Primary Key" + exclamationMark + "\n\n";
    private static String selectErrorMsg = "\nEnter Single Digit as Input " + exclamationMark + "\n\n";
    public static String integerOnlyErrorMsg = "\nplease Enter integer Value only" + exclamationMark + "\n\n";
    public static String doubleOnlyErrorMsg = "\nplease Enter double Value only" + exclamationMark + "\n\n";
    public static String stringOnlyErrorMsg = "\nplease Enter Character only" + exclamationMark + "\n\n";
    public static String insertSuccessMsg = "\nInserted SuccessFully" + exclamationMark + "\n\n";
    public static String deleteSuccessMsg = "\nDeleted SuccessFully" + exclamationMark + "\n\n";
    public static String updateSuccessMsg = "\nUpdated SuccessFully" + exclamationMark + "\n\n";

    private static boolean patternMatch(String pattern, String value, String errorMsg) {
        Pattern patternRef = Pattern.compile(pattern);
        boolean checkResult = patternRef.matcher(value).matches();
        if (!checkResult) {
            printErrors(errorMsg);
            return false;
        }
        return true;
    }

    public static void printErrors(String errorMsg) {
        System.out.println(errorMsg);
    }

    public static boolean checkNull(String value) {
        return (value == null) || (value.length() == 0);
    }

    public static String scan(String msg, String regex, String errorMsg, OperationType operationType) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String returnValue;
        while (true) {
            System.out.println("\nEnter " + msg + " : ");
            returnValue = br.readLine();
            if (!checkNull(returnValue)) {
                if (regex != null) {
                    if (patternMatch(regex, returnValue, errorMsg))
                        break;
                } else
                    break;

            } else {
                if (operationType == OperationType.UPDATE)
                    return null;
                printErrors(nullErrorMsg);
            }
        }
        return returnValue;
    }

    public static Gender scanGender(OperationType operationType) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gender gender = null;
        int loopBreak = 0;
        String inputValue;
        while (true) {
            System.out.println("\nSelect Student Gender : \n1. Male\n2. Female\n");
            inputValue = br.readLine();
            if (checkNull(inputValue)) {
                if (operationType == OperationType.UPDATE)
                    return Gender.NONE;
                System.out.println(nullErrorMsg);
                continue;
            } else if (patternMatch(digitRegex, inputValue, selectErrorMsg)) {
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
            } else
                break;
            if (loopBreak == 1)
                break;
        }
        return gender;
    }

    public static Designation scanDesignation(OperationType operationType) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Designation designation = null;
        int loopBreak = 0;
        String inputValue;
        while (true) {
            System.out.println("\nSelect Teacher Designation: \n1. Professor\n2. Teaching Assistance\n3. Lab Staff");
            inputValue = br.readLine();
            if (!checkNull(inputValue)) {
                if (patternMatch(digitRegex, inputValue, selectErrorMsg)) {
                    int choice = Integer.parseInt(inputValue);
                    switch (choice) {
                        case 1:
                            designation = Designation.PROFESSOR;
                            loopBreak = 1;
                            break;
                        case 2:
                            designation = Designation.TEACHING_ASSISTANCE;
                            loopBreak = 1;
                            break;
                        case 3:
                            designation = Designation.LAB_STAFF;
                            loopBreak = 1;
                            break;
                        default:
                            printErrors(String.format(scanningErrorMsg, "Designation"));
                    }
                }
            } else {
                if (operationType == OperationType.UPDATE)
                    return Designation.NONE;
                System.out.println(nullErrorMsg);
                continue;
            }
            if (loopBreak == 1)
                break;
        }
        return designation;
    }

    public static String genericToString(DTO reference) {
        StringBuilder returnValue = new StringBuilder();
        Class classReference = reference.getClass();
        Field[] fields = classReference.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                returnValue.append(field.getName());
                returnValue.append(" : ");
                returnValue.append(field.get(reference));
                returnValue.append("\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnValue.toString();
    }

    public static String updateCheck(DTO reference, String fieldName, String scannedValue) {
        Class classReference = reference.getClass();
        try {
            if (checkNull(scannedValue)) {
                Field declaredField = classReference.getDeclaredField(fieldName);
                declaredField.setAccessible(true);
                return String.valueOf(declaredField.get(reference));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scannedValue;
    }

    public static String uuidGeneration() {
        return Generators.randomBasedGenerator().generate().toString();
    }
    public static String getJqueryString(){
        return String.format("<script type=\"text/javascript\" src=\"%s\"></script>%n","js/jquery.min.js");
    }
    public static String getCommonCssJavascriptString(){
        String jsLinking = "<script type=\"text/javascript\" src=\"%s\"></script>%n";
        String cssLinking = "<link href=\"%s\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />%n";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format(jsLinking,"js/style.js"));
        stringBuffer.append(String.format(cssLinking,"css/style.css"));
        return stringBuffer.toString();
    }
    public static String getDataTablesCssJavascriptString() {
        String jsLinking = "<script type=\"text/javascript\" src=\"%s\"></script>%n";
        String cssLinking = "<link href=\"%s\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />%n";

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format(jsLinking,"js/datatable/jquery.dataTables.min.js"));
        stringBuffer.append(String.format(jsLinking,"js/tablejs/datatables.min.js"));
        stringBuffer.append(String.format(jsLinking,"js/datatable/dataTables.bootstrap.min.js"));
        stringBuffer.append(String.format(jsLinking,"js/datatable/dataTables.buttons.min.js"));
        stringBuffer.append(String.format(jsLinking,"js/datatable/buttons.bootstrap.min.js"));
        stringBuffer.append(String.format(jsLinking,"js/datatable/jszip.min.js"));
        stringBuffer.append(String.format(jsLinking,"js/datatable/pdfmake.min.js"));
        stringBuffer.append(String.format(jsLinking,"js/datatable/vfs_fonts.js"));
        stringBuffer.append(String.format(jsLinking,"js/datatable/buttons.html5.min.js"));
        stringBuffer.append(String.format(jsLinking,"js/datatable/buttons.print.min.js"));
        stringBuffer.append(String.format(jsLinking,"js/datatable/buttons.colVis.min.js"));

        stringBuffer.append(String.format(cssLinking,"css/tablecss/css1.css"));
        stringBuffer.append(String.format(cssLinking,"css/bootstrap.css"));
        stringBuffer.append(String.format(cssLinking,"js/datatable/dataTables.bootstrap.min.css"));
        stringBuffer.append(String.format(cssLinking,"js/datatable/buttons.bootstrap.min.css"));
        stringBuffer.append(String.format(jsLinking,"https://kit.fontawesome.com/b61ede621e.js"));

        stringBuffer.append("<script>\n");
        stringBuffer.append("$(document).ready(function(){var table = $('#example').DataTable({buttons: [ 'copy', 'excel', 'pdf', 'print', 'colvis' ]});\n");
        stringBuffer.append("    table.buttons().container().appendTo( '#example_wrapper .col-sm-6:eq(0)' );});</script>\n");
        stringBuffer.append("<script type=\"text/javascript\">\n");
        stringBuffer.append("var request=new XMLHttpRequest();\n");
        stringBuffer.append("$(document).ready(function(){\n");
        stringBuffer.append("$('#ab').DataTable();});</script>\n");

        return stringBuffer.toString();
    }

}
