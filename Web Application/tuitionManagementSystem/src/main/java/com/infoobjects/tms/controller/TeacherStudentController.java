package com.infoobjects.tms.controller;

import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.service.TeacherServiceImpl;
import com.infoobjects.tms.service.TeacherStudentServiceImpl;
import com.infoobjects.tms.utils.TmsUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/teacherStudentController")
public class TeacherStudentController extends HttpServlet {

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter = httpServletResponse.getWriter();
        String action = httpServletRequest.getParameter("action");
        StudentServiceImpl studentService = new StudentServiceImpl();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        TeacherStudentServiceImpl teacherStudentService = new TeacherStudentServiceImpl();

        if (action.equalsIgnoreCase("TeacherStudentForm")) {
            List<Student> students = studentService.findAll();
            List<Teacher> allTeachers = teacherService.findAll();

            StringBuffer outputString = new StringBuffer();
            outputString.append(TmsUtils.getJqueryString());
            outputString.append(TmsUtils.getCommonCssJavascriptString());
            outputString.append("<div data-include=\"header\"></div>");
            outputString.append("<div class=\"heading\"><h1>Insert Teacher Student Mapping</h1></div>");
            outputString.append("<div class=\"container\" ><div class=\"form\"><form method=\"get\" action=\"teacherStudentController\">");
            outputString.append(" <div class=\"clear\"></div><div class=\"form-options1\"><label class=\"head\">Student</label><select name=\"studentId\" class=\"category1\">");
            outputString.append("<option value=\"\">---Select Student---</option>");
            for (Student student : students) {
                List<Teacher> teachers = teacherStudentService.getTeacherName(student.getStudentId());
                if (teachers.size() == allTeachers.size()) {
                    continue;
                }
                outputString.append("<option value=\"").append(student.getStudentId()).append("\">").append(student.getStudentName() + "(" + student.getStudentId() + ")").append("</option>");
            }
            outputString.append("</select></div>");
            outputString.append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"submit\" name=\"action\" value=\"Next\"></div>");
            outputString.append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"reset\" name=\"action\" value=\"Reset\"></div>");
            outputString.append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"button\" name=\"action\" value=\"Back\" onclick=\"document.location = 'index.html'\"></div>");

            outputString.append("</select></div>");
            outputString.append("</form></div></div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("next")) {
            String studentId = httpServletRequest.getParameter("studentId");
            List<Teacher> teachers = teacherStudentService.getTeacherName(studentId);
            List<Teacher> allTeachers = teacherService.findAll();
            List<String> teachersId = new ArrayList<String>();

            for (Teacher teacher : teachers) {
                teachersId.add(teacher.getTeacherId());
            }
            StringBuffer outputString = new StringBuffer();
            outputString.append(TmsUtils.getJqueryString());
            outputString.append(TmsUtils.getCommonCssJavascriptString());
            outputString.append("<div data-include=\"header\"></div>");
            outputString.append("<div class=\"heading\"><h1>Insert Teacher Student Mapping</h1></div>");
            outputString.append("<div class=\"container\" ><div class=\"form\"><form method=\"post\" action=\"teacherStudentController\">");
            outputString.append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Student Id</label><input type=\"text\" name=\"studentId\"  readonly value=\"").append(studentId).append("\"></div>");
            outputString.append(" <div class=\"clear\"></div><div class=\"form-options1\"><label class=\"head\">Teacher</label><select name=\"teacherId\" class=\"category1\">");
            outputString.append("<option value=\"\">---Select Teacher---</option>");
            for (Teacher teacher : allTeachers) {
                if (teachersId.contains(teacher.getTeacherId())) {
                    continue;
                }
                outputString.append("<option value=\"").append(teacher.getTeacherId()).append("\">").append(teacher.getTeacherName() + "(" + teacher.getTeacherId() + ")").append("</option>");
            }
            outputString.append("</select></div>");
            outputString.append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"submit\" name=\"action\" value=\"Insert Teacher Student\"></div>");
            outputString.append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"reset\" name=\"action\" value=\"Reset\"></div>");
            outputString.append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"button\" name=\"action\" value=\"Back\" onclick=\"document.location = 'index.html'\"></div>");
            outputString.append("</select></div>");
            outputString.append("</form></div></div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("Insert Teacher Student")) {
            doPost(httpServletRequest, httpServletResponse);
        } else if (action.equalsIgnoreCase("ShowAllStudentsforSpecificTeacherId")) {
            List<Teacher> allTeachers = teacherService.findAll();
            StringBuffer outputString = new StringBuffer();
            outputString.append(TmsUtils.getJqueryString());
            outputString.append(TmsUtils.getCommonCssJavascriptString());
            outputString.append("<div data-include=\"header\"></div>");
            outputString.append("<div class=\"heading\"><h1>Insert Teacher Student Mapping</h1></div>");
            outputString.append("<div class=\"container\" ><div class=\"form\"><form method=\"get\" action=\"teacherStudentController\">");
            outputString.append(" <div class=\"clear\"></div><div class=\"form-options1\"><label class=\"head\">Teacher</label><select name=\"teacherId\" class=\"category1\">");
            outputString.append("<option value=\"\">---Select Teacher---</option>");
            for (Teacher teacher : allTeachers) {
                outputString.append("<option value=\"").append(teacher.getTeacherId()).append("\">").append(teacher.getTeacherName() + "(" + teacher.getTeacherId() + ")").append("</option>");
            }
            outputString.append("</select></div>");
            outputString.append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"submit\" name=\"action\" value=\"Show Students\"></div>");
            outputString.append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"reset\" name=\"action\" value=\"Reset\"></div>");
            outputString.append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"button\" name=\"action\" value=\"Back\" onclick=\"document.location = 'index.html'\"></div>");
            outputString.append("</select></div>");
            outputString.append("</form></div></div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("Show Students")) {
            String teacherId = httpServletRequest.getParameter("teacherId");
            StringBuffer outputString = new StringBuffer();
            List<Student> students = teacherStudentService.showAllStudent(teacherId);
            outputString.append(TmsUtils.getJqueryString());
            outputString.append(TmsUtils.getCommonCssJavascriptString());
            outputString.append(TmsUtils.getShowAllDetailsCssString());
            outputString.append("<div data-include=\"header\"></div>");
            outputString.append("<div class=\"heading\"><h1>Show Students</h1></div>");
            outputString.append("<div class=\"container1\"><center><table align=\"center\">");
            outputString.append("<tr><td class=\"head\">Student Id</td><td class=\"head\">Name</td></tr>");
            for (Student student : students) {
                outputString.append("<tr><td class=\"data\" style=\"padding-left: 15em;\">").append(student.getStudentId()).append("</td><td class=\"data\"> ").append(student.getStudentName()).append("</td></tr>");
            }
            outputString.append("</table>");
            outputString.append("<form action=\"index.html\">");
            outputString.append("<div class=\"btn\"><input type=\"submit\" name=\"action\" id=\"btnform\" value=\"BACK\"/></div>");
            outputString.append("</form>");
            outputString.append("</center>");
            outputString.append("</div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("ShowAllTeacherStudent")) {
            List<TeacherStudent> teacherStudents = teacherStudentService.findAll();
            StringBuffer outputString = new StringBuffer();
            outputString.append(TmsUtils.getDataTablesCssJavascriptString());
            outputString.append(TmsUtils.getCommonCssJavascriptString());
            outputString.append("<div data-include=\"header\"></div><br/><br/><h1 align=\"center\";margin =\"1 em\";color: #141414;\"><b>Show All Students</b></h1><br/><br/><center><b><font color=\"blue\" size=\"5\">").append("").append("</font></b></center>");
            outputString.append("<table cellpadding=\"10\"  id=\"example\" class=\"display\">");
            outputString.append("<thead><tr><th>Student Id</th>");
            outputString.append("<th>Student Name</th>");
            outputString.append("<th>Teacher Id</th>");
            outputString.append("<th>Teacher Name</th>");
            outputString.append("<th>Delete</th></thead><tbody>");

            List<Student> students = studentService.findAll();
            for (TeacherStudent teacherStudent : teacherStudents) {
                outputString.append("<tr><td>").append(teacherStudent.getStudentId());
                outputString.append("</td><td>").append(studentService.find(teacherStudent.getStudentId()).getStudentName());
                outputString.append("</td><td>").append(teacherStudent.getTeacherId());
                outputString.append("</td><td>").append(teacherService.find(teacherStudent.getTeacherId()).getTeacherName());
                outputString.append("</td><td>").append("<form method=\"delete\" action=\"teacherStudentController\"><input type = \"hidden\" name=\"teacherId\" value =\"").append(teacherStudent.getTeacherId()).append("\"><input type = \"hidden\" name=\"teacherId\" value =\"").append(teacherStudent.getStudentId()).append("\"><input type=\"submit\" name=\"action\"  class=\"btn btn-success\" value=\"Delete\">").append("</form>");
                outputString.append("</td></tr>");
            }
            outputString.append("</tbody></table>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("update")) {
            doPut(httpServletRequest, httpServletResponse);
        } else if (action.equalsIgnoreCase("delete")) {
            doDelete(httpServletRequest, httpServletResponse);
        }
    }

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter = httpServletResponse.getWriter();
        String action = httpServletRequest.getParameter("action");
        TeacherStudentServiceImpl teacherStudentService = new TeacherStudentServiceImpl();
        if (action.equalsIgnoreCase("Insert Teacher Student")) {
            TeacherStudent teacherStudent = new TeacherStudent();
            teacherStudent.setStudentId(httpServletRequest.getParameter("studentId"));
            teacherStudent.setTeacherId(httpServletRequest.getParameter("teacherId"));
            teacherStudentService.insert(teacherStudent);
            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("window.location = 'index.html'");
            printWriter.println("alert('Inserted Successfully!!!!!!')");
            printWriter.println("</script>");
        }
    }

    protected void doDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter = httpServletResponse.getWriter();
        String action = httpServletRequest.getParameter("action");
        TeacherStudentServiceImpl teacherStudentService = new TeacherStudentServiceImpl();

        if (action.equalsIgnoreCase("delete")) {
            TeacherStudent teacherStudent = new TeacherStudent();
            teacherStudent.setStudentId(httpServletRequest.getParameter("studentId"));
            teacherStudent.setTeacherId(httpServletRequest.getParameter("teacherId"));
            teacherStudentService.delete(teacherStudent);
            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("window.location = 'index.html'");
            printWriter.println("alert('Deleted Successfully!!!!!!')");
            printWriter.println("</script>");
        }
    }

}
