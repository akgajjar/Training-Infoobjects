package com.infoobjects.tms.controller;

import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.service.interfaces.Service;
import com.infoobjects.tms.utils.TmsUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/ShowAllData")
public class ShowAllData extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");//setting the content type
        StudentServiceImpl studentService = new StudentServiceImpl();
        PrintWriter printWriter = httpServletResponse.getWriter();//get the stream to write the data
        HttpSession session = httpServletRequest.getSession();
        Service serviceReference = (Service) session.getAttribute("serviceReference");

            StringBuffer outputString = new StringBuffer();
            outputString.append(TmsUtils.getDataTablesCssJavascriptString());
            outputString.append("<center><b><font color=\"blue\" size=\"5\">").append("").append("</font></b></center>");
            outputString.append("<table cellpadding=\"10\"  id=\"example\" class=\"display\">");
            outputString.append("<thead><tr><th>Student Id</th>");
            outputString.append("<th>Student Name</th>");
            outputString.append("<th>Class</th>");
            outputString.append("<th>View Full Details</th>");
            outputString.append("<th>View Teacher Name </th>");
            outputString.append("<th>Update</th>");
            outputString.append("<th>Delete</th></thead><tbody>");

            List<DTO> data =serviceReference.findAll();
            for(DTO dataReference : data){
                Student studentReference = (Student) dataReference;
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
