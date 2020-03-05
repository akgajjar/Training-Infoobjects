package com.infoobjects.tms.utils;

import com.fasterxml.uuid.Generators;
import com.infoobjects.tms.dto.interfaces.DTO;

import java.lang.reflect.Field;

public class TmsUtils {

    public static String camelCaseRegex = "([a-z])([A-Z]+)";
    public static String camelCaseReplacementRegex = "$1_$2";

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

    public static String uuidGeneration() {
        return Generators.randomBasedGenerator().generate().toString();
    }

    public static String getCssString(String path) {
        return String.format("<link href=\"%s\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />%n", path);
    }

    public static String getJsString(String path) {
        return String.format("<script type=\"text/javascript\" src=\"%s\"></script>%n", path);
    }

    public static String getJqueryString() {
        return getJsString("js/jquery.min.js");
    }

    public static String getCommonCssJavascriptString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getJsString("js/style.js"));
        stringBuffer.append(getCssString("css/style.css"));
        return stringBuffer.toString();
    }

    public static String getShowAllDetailsCssString() {
        return getCssString("css/showfulldetails.css");
    }

    public static String getDataTablesCssJavascriptString() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getJsString("js/datatable/jquery.dataTables.min.js"));
        stringBuffer.append(getJsString("js/tablejs/datatables.min.js"));
        stringBuffer.append(getJsString("js/datatable/dataTables.bootstrap.min.js"));
        stringBuffer.append(getJsString("js/datatable/dataTables.buttons.min.js"));
        stringBuffer.append(getJsString("js/datatable/buttons.bootstrap.min.js"));
        stringBuffer.append(getJsString("js/datatable/jszip.min.js"));
        stringBuffer.append(getJsString("js/datatable/pdfmake.min.js"));
        stringBuffer.append(getJsString("js/datatable/vfs_fonts.js"));
        stringBuffer.append(getJsString("js/datatable/buttons.html5.min.js"));
        stringBuffer.append(getJsString("js/datatable/buttons.print.min.js"));
        stringBuffer.append(getJsString("js/datatable/buttons.colVis.min.js"));

        stringBuffer.append(getCssString("css/tablecss/css1.css"));
        stringBuffer.append(getCssString("css/bootstrap.css"));
        stringBuffer.append(getCssString("js/datatable/dataTables.bootstrap.min.css"));
        stringBuffer.append(getCssString("js/datatable/buttons.bootstrap.min.css"));
        stringBuffer.append(getCssString("https://kit.fontawesome.com/b61ede621e.js"));

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
