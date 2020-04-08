package com.infoobjects.tms;

import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.utils.TmsUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class testchanges {
    public static void main(String[] args) {


         StudentServiceImpl
         studentService = new StudentServiceImpl();

         
         StringBuilder outputString = new StringBuilder();
         outputString.append(TmsUtils.getJqueryString())
                 .append(TmsUtils.getCommonCssJavascriptString())
                 .append(TmsUtils.getShowAllDetailsCssString())
                 .append("\n<div data-include=\"header\"></div>")
                 .append("\n<div class=\"heading\">\n<h1>Show Full Details</h1>\n</div>")
                 .append("\n<div class=\"container1\">\n<center><table align=\"center\">")
                 .append("\n<tr>\n<td colspan=\"2\"  class=\"head\">Student Personal Details</td>\n</tr>")
                 .append("\n<tr>\n<td class=\"b\">Student Id : </td>\n<td class=\"data\"> ").append("<%=student.getStudentId()%>").append("</td>\n</tr>")
                 .append("\n<tr>\n<td class=\"b\">Name : </td>\n<td class=\"data\"> ").append("<%=student.getStudentName()%>").append("</td>\n</tr>")
                 .append("\n<tr>\n<td class=\"b\">Class : </td>\n<td class=\"data\"> ").append("<%=student.getStudentClass()%>").append("</td>\n</tr>")
                 .append("\n<tr>\n<td class=\"b\">Address:</td> \n<td class=\"data\">").append("<%=student.getStudentAddress()%>").append("</td>\n</tr>")
                 .append("\n<tr>\n<td class=\"b\">Mobile :</td> \n<td class=\"data\"> ").append("<%=student.getStudentMobile()%>").append("</td>\n</tr>")
                 .append("\n<tr>\n<td class=\"b\">Email : </td>\n<td class=\"data\">").append("<%=student.getStudentEmailId()%>").append("</td>\n</tr>")
                 .append("\n<tr>\n<td class=\"b\">Gender : </td>\n<td class=\"data\"> ").append("<%=student.getStudentGender()%>").append("</td>\n</tr>")
                 .append("\n<tr>\n</tr>\n")
                 .append("\n<tr>\n<td colspan=\"2\"  class=\"head\">Student Parents & Reference Details</td>\n</tr>")
                 .append("\n<tr>\n<td class=\"b\">Parents Name :</td>\n <td class=\"data\"> ").append("<%=student.getStudentParentName()%>").append("</td>\n</tr>")
                 .append("\n<tr>\n<td class=\"b\">Parents Mobile : </td>\n<td class=\"data\"> ").append("<%=student.getStudentParentMobile()%>").append("</td>\n</tr>")
                 .append("\n<tr>\n<td class=\"b\">Parents Email :</td> \n<td class=\"data\"> ").append("<%=student.getStudentParentEmailId()%>").append("</td>\n</tr>")
                 .append("\n<tr>\n<td class=\"b\">Reference Name :</td>\n <td class=\"data\">").append("<%=student.getStudentReferenceName()%>").append("</td>\n</tr>")
                 .append("\n</table>")
                 .append("\n<form action=\"studentController\">")
                 .append("\n<input type=\"hidden\" name=\"action\" value=\"showallstudents\">")
                 .append("\n<div class=\"btn\"><input type=\"submit\" name=\"button\" id=\"btnform\" value=\"BACK\"/>\n</div>")
                 .append("\n</form>")
                 .append("\n</center>")
                 .append("\n</div>");
             System.out.println(outputString);
    }
}
