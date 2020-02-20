package com.infoobjects.tms.controller;

import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.utils.TmsUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.infoobjects.tms.utils.TmsUtils.uuidGeneration;

@WebServlet("/studentController")
public class studentController extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");//setting the content type
        PrintWriter printWriter=httpServletResponse.getWriter();//get the stream to write the data


    }


    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException,IOException  {
        httpServletResponse.setContentType("text/html");//setting the content type
        PrintWriter printWriter=httpServletResponse.getWriter();//get the stream to write the data
        StudentServiceImpl  studentService = new StudentServiceImpl();
        String action = httpServletRequest.getParameter("action");

        if(action.equalsIgnoreCase("Insert Student")){


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
