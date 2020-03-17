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

            StringBuilder outputString = new StringBuilder();
            outputString.append(TmsUtils.getJqueryString())
                    .append(TmsUtils.getCommonCssJavascriptString())
                    .append("<div data-include=\"header\"></div>")
                    .append("<div class=\"heading\"><h1>Insert Teacher Student Mapping</h1></div>")
                    .append("<div class=\"container\" ><div class=\"form\"><form method=\"get\" action=\"teacherStudentController\">")
                    .append(" <div class=\"clear\"></div><div class=\"form-options1\"><label class=\"head\">Student</label><select name=\"studentId\" class=\"category1\">")
                    .append("<option value=\"\">---Select Student---</option>");
            if (students.size() > 0) {
                for (Student student : students) {
                    List<Teacher> teachers = teacherStudentService.getTeacherName(student.getStudentId());
                    if (teachers.size() == allTeachers.size()) {
                        continue;
                    }
                    outputString.append("<option value=\"")
                            .append(student.getStudentId())
                            .append("\">")
                            .append(student.getStudentName())
                            .append("(")
                            .append(student.getStudentId())
                            .append(")")
                            .append("</option>");
                }
            }
            outputString.append("</select></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"submit\" name=\"action\" value=\"Next\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"reset\" name=\"action\" value=\"Reset\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"button\" name=\"action\" value=\"Back\" onclick=\"document.location = 'index.html'\"></div>")
                    .append("</select></div>")
                    .append("</form></div></div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("next")) {
            String studentId = httpServletRequest.getParameter("studentId");
            List<Teacher> teachers = teacherStudentService.getTeacherName(studentId);
            List<Teacher> allTeachers = teacherService.findAll();
            List<String> teachersId = new ArrayList<String>();
            if (teachers.size() > 0) {
                for (Teacher teacher : teachers) {
                    teachersId.add(teacher.getTeacherId());
                }
            }
            StringBuilder outputString = new StringBuilder();
            outputString.append(TmsUtils.getJqueryString())
                    .append(TmsUtils.getCommonCssJavascriptString())
                    .append("<div data-include=\"header\"></div>")
                    .append("<div class=\"heading\"><h1>Insert Teacher Student Mapping</h1></div>")
                    .append("<div class=\"container\" ><div class=\"form\"><form method=\"post\" action=\"teacherStudentController\">")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Student Id</label><input type=\"text\" name=\"studentId\"  readonly value=\"").append(studentId).append("\"></div>")
                    .append(" <div class=\"clear\"></div><div class=\"form-options1\"><label class=\"head\">Teacher</label><select name=\"teacherId\" class=\"category1\">")
                    .append("<option value=\"\">---Select Teacher---</option>");
            if (allTeachers.size() > 0) {
                for (Teacher teacher : allTeachers) {
                    if (teachersId.contains(teacher.getTeacherId())) {
                        continue;
                    }
                    outputString.append("<option value=\"")
                            .append(teacher.getTeacherId())
                            .append("\">").append(teacher.getTeacherName())
                            .append("(")
                            .append(teacher.getTeacherId())
                            .append(")")
                            .append("</option>");
                }
            }
            outputString.append("</select></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"submit\" name=\"action\" value=\"Insert Teacher Student\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"reset\" name=\"action\" value=\"Reset\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"button\" name=\"action\" value=\"Back\" onclick=\"document.location = 'index.html'\"></div>")
                    .append("</select></div>")
                    .append("</form></div></div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("Insert Teacher Student")) {
            doPost(httpServletRequest, httpServletResponse);
        } else if (action.equalsIgnoreCase("ShowAllStudentsforSpecificTeacherId")) {
            List<Teacher> allTeachers = teacherService.findAll();
            StringBuilder outputString = new StringBuilder();
            outputString.append(TmsUtils.getJqueryString())
                    .append(TmsUtils.getCommonCssJavascriptString())
                    .append("<div data-include=\"header\"></div>")
                    .append("<div class=\"heading\"><h1>Insert Teacher Student Mapping</h1></div>")
                    .append("<div class=\"container\" ><div class=\"form\"><form method=\"get\" action=\"teacherStudentController\">")
                    .append(" <div class=\"clear\"></div><div class=\"form-options1\"><label class=\"head\">Teacher</label><select name=\"teacherId\" class=\"category1\">")
                    .append("<option value=\"\">---Select Teacher---</option>");
            if (allTeachers.size() > 0) {
                for (Teacher teacher : allTeachers) {
                    outputString.append("<option value=\"").append(teacher.getTeacherId()).append("\">").append(teacher.getTeacherName() + "(" + teacher.getTeacherId() + ")").append("</option>");
                }
            }
            outputString.append("</select></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"submit\" name=\"action\" value=\"Show Students\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"reset\" name=\"action\" value=\"Reset\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"button\" name=\"action\" value=\"Back\" onclick=\"document.location = 'index.html'\"></div>")
                    .append("</select></div>")
                    .append("</form></div></div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("Show Students")) {
            String teacherId = httpServletRequest.getParameter("teacherId");
            StringBuilder outputString = new StringBuilder();
            List<Student> students = teacherStudentService.showAllStudent(teacherId);
            outputString.append(TmsUtils.getJqueryString())
                    .append(TmsUtils.getCommonCssJavascriptString())
                    .append(TmsUtils.getShowAllDetailsCssString())
                    .append("<div data-include=\"header\"></div>")
                    .append("<div class=\"heading\"><h1>Show Students</h1></div>")
                    .append("<div class=\"container1\"><center><table align=\"center\">")
                    .append("<tr><td class=\"head\">Student Id</td><td class=\"head\">Name</td></tr>");
            if (students.size() > 0) {
                for (Student student : students) {
                    outputString.append("<tr><td class=\"data\" style=\"padding-left: 15em;\">").append(student.getStudentId()).append("</td><td class=\"data\"> ").append(student.getStudentName()).append("</td></tr>");
                }
            }
            outputString.append("</table>")
                    .append("<form action=\"index.html\">")
                    .append("<div class=\"btn\"><input type=\"submit\" name=\"action\" id=\"btnform\" value=\"BACK\"/></div>")
                    .append("</form>")
                    .append("</center>")
                    .append("</div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("ShowAllTeacherStudent")) {
            List<TeacherStudent> teacherStudents = teacherStudentService.findAll();
            StringBuilder outputString = new StringBuilder();
            outputString.append(TmsUtils.getDataTablesCssJavascriptString())
                    .append(TmsUtils.getCommonCssJavascriptString())
                    .append("<div data-include=\"header\"></div><br/><br/><h1 align=\"center\";margin =\"1 em\";color: #141414;\"><b>Show All Students</b></h1><br/><br/><center><b><font color=\"blue\" size=\"5\">").append("").append("</font></b></center>")
                    .append("<table cellpadding=\"10\"  id=\"example\" class=\"display\">")
                    .append("<thead><tr><th>Student Id</th>")
                    .append("<th>Student Name</th>")
                    .append("<th>Teacher Id</th>")
                    .append("<th>Teacher Name</th>")
                    .append("<th>Delete</th></thead><tbody>");

            List<Student> students = studentService.findAll();
            if (students.size() > 0) {
                for (TeacherStudent teacherStudent : teacherStudents) {
                    outputString.append("<tr><td>")
                            .append(teacherStudent.getStudentId())
                            .append("</td><td>")
                            .append(studentService.find(teacherStudent.getStudentId()).getStudentName())
                            .append("</td><td>")
                            .append(teacherStudent.getTeacherId())
                            .append("</td><td>")
                            .append(teacherService.find(teacherStudent.getTeacherId()).getTeacherName())
                            .append("</td><td>")
                            .append("<form method=\"delete\" action=\"teacherStudentController\"><input type = \"hidden\" name=\"teacherId\" value =\"")
                            .append(teacherStudent.getTeacherId())
                            .append("\"><input type = \"hidden\" name=\"studentId\" value =\"")
                            .append(teacherStudent.getStudentId())
                            .append("\"><input type=\"submit\" name=\"action\"  class=\"btn btn-success\" value=\"Delete\">")
                            .append("</form>")
                            .append("</td></tr>");
                }
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
            printWriter.println("window.location = 'teacherStudentController?action=ShowAllTeacherStudent'");
            printWriter.println("alert('Deleted Successfully!!!!!!')");
            printWriter.println("</script>");
        }
    }

}
