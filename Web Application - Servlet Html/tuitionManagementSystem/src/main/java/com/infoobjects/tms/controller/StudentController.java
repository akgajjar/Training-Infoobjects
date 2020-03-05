package com.infoobjects.tms.controller;

import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.enums.Gender;
import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.service.TeacherStudentServiceImpl;
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
public class StudentController extends HttpServlet {


    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        StudentServiceImpl studentService = new StudentServiceImpl();
        TeacherStudentServiceImpl teacherStudentService = new TeacherStudentServiceImpl();
        PrintWriter printWriter = httpServletResponse.getWriter();
        String action = httpServletRequest.getParameter("action");

        if (action.equalsIgnoreCase("showallstudents")) {
            StringBuilder outputString = new StringBuilder();
            outputString.append(TmsUtils.getDataTablesCssJavascriptString())
                    .append(TmsUtils.getCommonCssJavascriptString())
                    .append("<div data-include=\"header\"></div><br/><br/><h1 align=\"center\";margin =\"1 em\";color: #141414;\"><b>Show All Students</b></h1><br/><br/><center><b><font color=\"blue\" size=\"5\">").append("").append("</font></b></center>")
                    .append("<table cellpadding=\"10\"  id=\"example\" class=\"display\">")
                    .append("<thead><tr><th>Student Id</th>")
                    .append("<th>Student Name</th>")
                    .append("<th>Class</th>")
                    .append("<th>View Full Details</th>")
                    .append("<th>View Teacher Name </th>")
                    .append("<th>Update</th>")
                    .append("<th>Delete</th></thead><tbody>");

            List<Student> students = studentService.findAll();
            if (students.size() > 0) {
                for (Student studentReference : students) {
                    outputString.append("<tr><td>").append(studentReference.getStudentId())
                            .append("</td><td>").append(studentReference.getStudentName())
                            .append("</td><td>").append(studentReference.getStudentClass())
                            .append("</td><td>").append("<form method=\"get\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\" class=\"btn btn-success\" value=\"Show Full Details\">").append("</form>")
                            .append("</td><td>").append("<form method=\"get\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\"  class=\"btn btn-success\" value=\"View Teacher Name\">").append("</form>")
                            .append("</td><td>").append("<form method=\"put\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\"  class=\"btn btn-success\" value=\"Update\">").append("</form>")
                            .append("</td><td>").append("<form method=\"delete\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\"  class=\"btn btn-success\" value=\"Delete\">").append("</form>")
                            .append("</td></tr>");
                }
            }
            outputString.append("</tbody></table>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("Show Full Details")) {
            String studentId = httpServletRequest.getParameter("id");
            Student student = studentService.find(studentId);
            StringBuilder outputString = new StringBuilder();
            outputString.append(TmsUtils.getJqueryString())
                    .append(TmsUtils.getCommonCssJavascriptString())
                    .append(TmsUtils.getShowAllDetailsCssString())
                    .append("<div data-include=\"header\"></div>")
                    .append("<div class=\"heading\"><h1>Show Full Details</h1></div>")
                    .append("<div class=\"container1\"><center><table align=\"center\">")
                    .append("<tr><td colspan=\"2\"  class=\"head\">Student Personal Details</td></tr>")
                    .append("<tr><td class=\"b\">Student Id : </td><td class=\"data\"> ").append(student.getStudentId()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Name : </td><td class=\"data\"> ").append(student.getStudentName()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Class : </td><td class=\"data\"> ").append(student.getStudentClass()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Address:</td> <td class=\"data\">").append(student.getStudentAddress()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Mobile :</td> <td class=\"data\"> ").append(student.getStudentMobile()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Email : </td><td class=\"data\">").append(student.getStudentEmailId()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Gender : </td><td class=\"data\"> ").append(student.getStudentGender()).append("</td></tr>")
                    .append("<tr></tr>")
                    .append("<tr><td colspan=\"2\"  class=\"head\">Student Parents & Reference Details</td></tr>")
                    .append("<tr><td class=\"b\">Parents Name :</td> <td class=\"data\"> ").append(student.getStudentParentName()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Parents Mobile : </td><td class=\"data\"> ").append(student.getStudentParentMobile()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Parents Email :</td> <td class=\"data\"> ").append(student.getStudentParentEmailId()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Reference Name :</td> <td class=\"data\">").append(student.getStudentReferenceName()).append("</td></tr>")
                    .append("</table>")
                    .append("<form action=\"studentController\">")
                    .append("<input type=\"hidden\" name=\"action\" value=\"showallstudents\">")
                    .append("<div class=\"btn\"><input type=\"submit\" name=\"button\" id=\"btnform\" value=\"BACK\"/></div>")
                    .append("</form>")
                    .append("</center>")
                    .append("</div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("View Teacher Name")) {
            String studentId = httpServletRequest.getParameter("id");
            StringBuilder outputString = new StringBuilder();
            List<Teacher> teachers = teacherStudentService.getTeacherName(studentId);
            outputString.append(TmsUtils.getJqueryString())
                    .append(TmsUtils.getCommonCssJavascriptString())
                    .append(TmsUtils.getShowAllDetailsCssString())
                    .append("<div data-include=\"header\"></div>")
                    .append("<div class=\"heading\"><h1>Teacher's Name</h1></div>")
                    .append("<div class=\"container1\"><center><table align=\"center\">")
                    .append("<tr><td class=\"head\">Teacher Id</td><td class=\"head\">Name</td></tr>");
            if (teachers != null) {
                for (Teacher teacher : teachers) {
                    outputString.append("<tr><td class=\"data\" style=\"padding-left: 15em;\">").append(teacher.getTeacherId()).append("</td><td class=\"data\"> ").append(teacher.getTeacherName()).append("</td></tr>");
                }
            }
            outputString.append("</table>")
                    .append("<form action=\"studentController\">")
                    .append("<input type=\"hidden\" name=\"action\" value=\"showallstudents\">")
                    .append("<div class=\"btn\"><input type=\"submit\" name=\"button\" id=\"btnform\" value=\"BACK\"/></div>")
                    .append("</form>")
                    .append("</center>")
                    .append("</div>");
            printWriter.println(outputString);

        } else if (action.equalsIgnoreCase("update")) {
            doPut(httpServletRequest, httpServletResponse);
        } else if (action.equalsIgnoreCase("delete")) {
            doDelete(httpServletRequest, httpServletResponse);
        } else if (action.equalsIgnoreCase("Update Student")) {
            doPut(httpServletRequest, httpServletResponse);
        }
    }


    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter = httpServletResponse.getWriter();
        StudentServiceImpl studentService = new StudentServiceImpl();
        String action = httpServletRequest.getParameter("action");

        if (action.equalsIgnoreCase("Insert Student")) {
            Student student = new Student();
            student.setStudentClass(Integer.parseInt(httpServletRequest.getParameter("studentClass")));
            student.setStudentGender(Gender.valueOf(httpServletRequest.getParameter("studentGender")));
            student.setStudentId(TmsUtils.uuidGeneration());
            while (studentService.find(student.getStudentId()) != null) {
                student.setStudentId(TmsUtils.uuidGeneration());
            }
            student.setStudentAddress(httpServletRequest.getParameter("studentAddress"));
            student.setStudentEmailId(httpServletRequest.getParameter("studentEmailId"));
            student.setStudentMobile(httpServletRequest.getParameter("studentMobile"));
            student.setStudentName(httpServletRequest.getParameter("studentName"));
            student.setStudentParentEmailId(httpServletRequest.getParameter("studentParentEmailId"));
            student.setStudentParentMobile(httpServletRequest.getParameter("studentParentMobile"));
            student.setStudentParentName(httpServletRequest.getParameter("studentParentName"));
            student.setStudentReferenceName(httpServletRequest.getParameter("studentReferenceName"));
            studentService.insert(student);
            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("window.location = 'index.html'");
            printWriter.println("alert('Inserted Successfully!!!!!!')");
            printWriter.println("</script>");
        }
    }

    protected void doPut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter = httpServletResponse.getWriter();
        StudentServiceImpl studentService = new StudentServiceImpl();
        String action = httpServletRequest.getParameter("action");

        if (action.equalsIgnoreCase("Update")) {
            String studentId = httpServletRequest.getParameter("id");
            Student student = studentService.find(studentId);
            StringBuilder outputString = new StringBuilder();
            outputString.append(TmsUtils.getCommonCssJavascriptString())
                    .append(TmsUtils.getJqueryString())
                    .append("<div data-include=\"header\"></div>")
                    .append("<div class=\"heading\"><h1>Update Student</h1></div>")
                    .append("<div class=\"container\" ><div class=\"form\"><form method=\"put\" action=\"studentController\">")
                    .append("<input type=\"hidden\" name=\"studentId\" value=\"").append(student.getStudentId()).append("\">")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Name</label><input type=\"text\" name=\"studentName\" placeholder=\"Enter Student Name\" value=\"").append(student.getStudentName()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Class</label><input type=\"text\" name=\"studentClass\" placeholder=\"Enter Student Class\" value=\"").append(student.getStudentClass()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Address</label><input type=\"text\" name=\"studentAddress\" placeholder=\"Enter Student Address\" value=\"").append(student.getStudentAddress()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Mobile</label><input type=\"text\" name=\"studentMobile\" placeholder=\"Enter Student Mobile\" value=\"").append(student.getStudentMobile()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Email</label><input type=\"text\" name=\"studentEmailId\" placeholder=\"Enter Student Email Id\" value=\"").append(student.getStudentEmailId()).append("\"></div>")
                    .append(" <div class=\"clear\"></div><div class=\"form-options1\"><label class=\"head\">Gender</label><select name=\"studentGender\" class=\"category1\"><option value=\"\">---Select Gender---</option><option value=\"MALE\" ");
            if (student.getStudentGender() == Gender.MALE)
                outputString.append("Selected");
            outputString.append(">Male</option><option value=\"FEMALE\" ");
            if (student.getStudentGender() == Gender.FEMALE)
                outputString.append("Selected");
            outputString.append(">Female</option></select></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Parent Name</label><input type=\"text\" name=\"studentParentName\" placeholder=\"Enter Student's Parent Name\" value=\"").append(student.getStudentParentName()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Parent Mobile</label><input type=\"text\" name=\"studentParentMobile\" placeholder=\"Enter Student's Parent Mobile no\" value=\"").append(student.getStudentParentMobile()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Parent Email</label><input type=\"text\" name=\"studentParentEmailId\" placeholder=\"Enter Student's Parent Email Id\" value=\"").append(student.getStudentParentEmailId()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Reference Name</label><input type=\"text\" name=\"studentReferenceName\" placeholder=\"Enter Student's Reference Name\" value=\"").append(student.getStudentReferenceName()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"submit\" name=\"action\" value=\"Update Student\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"reset\" name=\"action\" value=\"Reset\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"button\" name=\"action\" value=\"Back\" onclick=\"document.location = 'studentController?action=showallstudents'\"></div>")
                    .append("</form></div></div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("Update Student")) {
            Student student = new Student();
            student.setStudentId(httpServletRequest.getParameter("studentId"));
            student.setStudentClass(Integer.parseInt(httpServletRequest.getParameter("studentClass")));
            student.setStudentGender(Gender.valueOf(httpServletRequest.getParameter("studentGender")));
            student.setStudentAddress(httpServletRequest.getParameter("studentAddress"));
            student.setStudentEmailId(httpServletRequest.getParameter("studentEmailId"));
            student.setStudentMobile(httpServletRequest.getParameter("studentMobile"));
            student.setStudentName(httpServletRequest.getParameter("studentName"));
            student.setStudentParentEmailId(httpServletRequest.getParameter("studentParentEmailId"));
            student.setStudentParentMobile(httpServletRequest.getParameter("studentParentMobile"));
            student.setStudentParentName(httpServletRequest.getParameter("studentParentName"));
            student.setStudentReferenceName(httpServletRequest.getParameter("studentReferenceName"));
            studentService.update(student);

            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("window.location = 'studentController?action=showallstudents'");
            printWriter.println("alert('Updated Successfully!!!!!!');");
            printWriter.println("</script>");
        }
    }

    protected void doDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter = httpServletResponse.getWriter();
        StudentServiceImpl studentService = new StudentServiceImpl();
        TeacherStudentServiceImpl teacherStudentService = new TeacherStudentServiceImpl();
        String action = httpServletRequest.getParameter("action");
        if (action.equalsIgnoreCase("Delete")) {
            String id = httpServletRequest.getParameter("id");
            studentService.delete(id);
            teacherStudentService.deleteByStudentId(id);
            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("window.location = 'studentController?action=showallstudents'");
            printWriter.println("alert('Deleted Successfully!!!!!!');");
            printWriter.println("</script>");
        }
    }

}