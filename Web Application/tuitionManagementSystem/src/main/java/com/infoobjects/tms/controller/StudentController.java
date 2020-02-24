package com.infoobjects.tms.controller;

import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.utils.TmsUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/studentController")
public class studentController extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");//setting the content type
        StudentServiceImpl studentService = new StudentServiceImpl();
        PrintWriter printWriter = httpServletResponse.getWriter();//get the stream to write the data
        String action = httpServletRequest.getParameter("action");
        if (action.equalsIgnoreCase("showallstudents")) {
            StringBuffer outputString = new StringBuffer();
            outputString.append(TmsUtils.getDataTablesJavascriptString());
            outputString.append("<center><b><font color=\"blue\" size=\"5\">").append("").append("</font></b></center>");
            outputString.append("<table cellpadding=\"10\"  id=\"example\" class=\"display\">");
            outputString.append("<thead><tr><th>Student Id</th>");
            outputString.append("<th>Student Name</th>");
            outputString.append("<th>Class</th>");
            outputString.append("<th>View Full Details</th>");
            outputString.append("<th>View Teacher Name </th>");
            outputString.append("<th>Update</th>");
            outputString.append("<th>Delete</th></thead><tbody>");

            List<DTO> students =studentService.findAll();
            for(DTO student : students){
                Student studentReference = (Student) student;
            outputString.append("<tr><td>").append(studentReference.getStudentId());
            outputString.append("</td><td>").append(studentReference.getStudentName());
                outputString.append("</td><td>").append(studentReference.getStudentClass());
                outputString.append("</td><td>").append("<form method=\"get\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\" value=\"Show Full Details\">").append("</form>");
                outputString.append("</td><td>").append("<form method=\"get\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\" value=\"View Teacher Name\">").append("</form>");
                outputString.append("</td><td>").append("<form method=\"get\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\" value=\"Update\">").append("</form>");
                outputString.append("</td><td>").append("<form method=\"get\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\" value=\"Delete\">").append("</form>");
                outputString.append("</td></tr>");
            }
            outputString.append("</tbody></table>");
            printWriter.println(outputString);
        }
    }


    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");//setting the content type
        PrintWriter printWriter = httpServletResponse.getWriter();//get the stream to write the data
        StudentServiceImpl studentService = new StudentServiceImpl();
        String action = httpServletRequest.getParameter("action");

        if (action.equalsIgnoreCase("Insert Student")) {


            httpServletRequest.getRequestDispatcher("index.html").forward(httpServletRequest, httpServletResponse);
        }
    }

    protected void doPut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");//setting the content type
        PrintWriter printWriter = httpServletResponse.getWriter();//get the stream to write the data

    }

    protected void doDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");//setting the content type
        PrintWriter printWriter = httpServletResponse.getWriter();//get the stream to write the data

    }
}
