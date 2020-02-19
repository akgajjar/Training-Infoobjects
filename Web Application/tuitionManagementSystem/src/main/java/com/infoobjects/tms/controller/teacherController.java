package com.infoobjects.tms.controller;

import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.enums.Designation;
import com.infoobjects.tms.service.TeacherServiceImpl;
import com.infoobjects.tms.utils.TmsUtils;

import javax.naming.InsufficientResourcesException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.infoobjects.tms.utils.TmsUtils.uuidGeneration;

/*
  <servlet>
  <servlet-name>teacherController</servlet-name>
  <servlet-class>teacherController</servlet-class>
</servlet>

<servlet-mapping>
  <servlet-name>teacherController</servlet-name>
  <url-pattern>/teacherController</url-pattern>
</servlet-mapping>
  */
@WebServlet("/teacherController")
public class teacherController extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");//setting the content type
        PrintWriter printWriter=httpServletResponse.getWriter();//get the stream to write the data


    }


    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException,IOException  {
        httpServletResponse.setContentType("text/html");//setting the content type
        PrintWriter printWriter=httpServletResponse.getWriter();//get the stream to write the data
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        String action = httpServletRequest.getParameter("action");

        if(action.equalsIgnoreCase("Insert Teacher")){
            Teacher teacher = new Teacher();
            teacher.setTeacherId(TmsUtils.uuidGeneration());
            while (teacherService.find(teacher.getTeacherId()) != null) {
                teacher.setTeacherId(uuidGeneration());
            }
            teacher.setTeacherAddress(httpServletRequest.getParameter("teacherAddress"));
            teacher.setTeacherDesignation(Designation.valueOf(httpServletRequest.getParameter("teacherDesignation")));
            teacher.setTeacherEmailId(httpServletRequest.getParameter("teacherEmailId"));
            teacher.setTeacherMobile(httpServletRequest.getParameter("teacherMobile"));
            teacher.setTeacherName(httpServletRequest.getParameter("teacherName"));
            teacher.setTeacherSalary(Double.parseDouble(httpServletRequest.getParameter("teacherSalary")));

        /*    teacherService.insert(teacher);
        */
        printWriter.println("<html><script>alert('Inserted Successfully!!!!!!');</script></html>");

            httpServletRequest.getRequestDispatcher("index.html").forward(httpServletRequest,httpServletResponse);
        }
    }
    protected void doPut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException,IOException  {
        httpServletResponse.setContentType("text/html");//setting the content type
        PrintWriter printWriter=httpServletResponse.getWriter();//get the stream to write the data

    }
    protected void doDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException,IOException  {
        httpServletResponse.setContentType("text/html");//setting the content type
        PrintWriter printWriter=httpServletResponse.getWriter();//get the stream to write the data

    }
}
