package com.infoobjects.tms.controller;

import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.enums.Designation;
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
import java.util.List;

import static com.infoobjects.tms.utils.TmsUtils.uuidGeneration;

@WebServlet("/teacherController")
public class TeacherController extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        PrintWriter printWriter = httpServletResponse.getWriter();
        String action = httpServletRequest.getParameter("action");

        if (action.equalsIgnoreCase("showallteachers")) {
            StringBuilder outputString = new StringBuilder();
            outputString.append(TmsUtils.getDataTablesCssJavascriptString())
                    .append(TmsUtils.getCommonCssJavascriptString())
                    .append("<div data-include=\"header\"></div><br/><br/><h1 align=\"center\";color: #141414;margin =\"1 em\";\"><b>Show All Teachers</b></h1><br/><br/><center><b><font color=\"blue\" size=\"5\">").append("</font></b></center>")
                    .append("<div style = \"margin: 5;\"><table cellpadding=\"10\"  id=\"example\" class=\"display\">")
                    .append("<thead><tr><th>Teacher Id</th>")
                    .append("<th>Teacher Name</th>")
                    .append("<th>Designation</th>")
                    .append("<th>View Full Details</th>")
                    .append("<th>Update</th>")
                    .append("<th>Delete</th></thead><tbody>");

            List<Teacher> teachers = teacherService.findAll();
            if (teachers.size() > 0) {
                for (Teacher teacherReference : teachers) {
                    outputString.append("<tr><td>").append(teacherReference.getTeacherId())
                            .append("</td><td>").append(teacherReference.getTeacherName())
                            .append("</td><td>").append(teacherReference.getTeacherDesignation())
                            .append("</td><td>").append("<form method=\"get\" action=\"teacherController\"><input type = \"hidden\" name=\"id\" value =\"").append(teacherReference.getTeacherId()).append("\"><input type=\"submit\" name=\"action\" class=\"btn btn-success\" value=\"Show Full Details\">").append("</form>")
                            .append("</td><td>").append("<form method=\"put\" action=\"teacherController\"><input type = \"hidden\" name=\"id\" value =\"").append(teacherReference.getTeacherId()).append("\"><input type=\"submit\" name=\"action\" class=\"btn btn-success\" value=\"Update\">").append("</form>")
                            .append("</td><td>").append("<form method=\"delete\" action=\"teacherController\"><input type = \"hidden\" name=\"id\" value =\"").append(teacherReference.getTeacherId()).append("\"><input type=\"submit\" name=\"action\" class=\"btn btn-success\" value=\"Delete\">").append("</form>")
                            .append("</td></tr>");
                }
            }
            outputString.append("</tbody></table></div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("Show Full Details")) {
            String id = httpServletRequest.getParameter("id");
            Teacher teacher = teacherService.find(id);
            StringBuilder outputString = new StringBuilder();
            outputString.append(TmsUtils.getJqueryString())
                    .append(TmsUtils.getCommonCssJavascriptString())
                    .append(TmsUtils.getShowAllDetailsCssString())
                    .append("<div data-include=\"header\"></div>")
                    .append("<div class=\"heading\"><h1>Show Full Details</h1></div>")
                    .append("<div class=\"container1\"><center><table align=\"center\">")
                    .append("<tr><td colspan=\"2\"  class=\"head\">Teacher Personal Details</td></tr>")
                    .append("<tr><td class=\"b\">Teacher Id : </td><td class=\"data\"> ").append(teacher.getTeacherId()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Name : </td><td class=\"data\"> ").append(teacher.getTeacherName()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Address:</td> <td class=\"data\">").append(teacher.getTeacherAddress()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Mobile :</td> <td class=\"data\"> ").append(teacher.getTeacherMobile()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Email : </td><td class=\"data\">").append(teacher.getTeacherEmailId()).append("</td></tr>")
                    .append("<tr><td class=\"b\">Designation : </td><td class=\"data\"> ").append(teacher.getTeacherDesignation()).append("</td></tr>")
                    .append("<tr><td class=\"b\">salary : </td><td class=\"data\"> ").append(teacher.getTeacherSalary()).append("</td></tr>")
                    .append("</table>")
                    .append("<form action=\"teacherController\">")
                    .append("<input type=\"hidden\" name=\"action\" value=\"showallteachers\">")
                    .append("<div class=\"btn\"><input type=\"submit\" name=\"button\" id=\"btnform\" value=\"BACK\"/></div>")
                    .append("</form>")
                    .append("</center>")
                    .append("</div>");
            printWriter.println(outputString);

        } else if (action.equalsIgnoreCase("update")) {
            doPut(httpServletRequest, httpServletResponse);
        } else if (action.equalsIgnoreCase("delete")) {
            doDelete(httpServletRequest, httpServletResponse);
        } else if (action.equalsIgnoreCase("Update Teacher")) {
            doPut(httpServletRequest, httpServletResponse);
        }

    }


    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter = httpServletResponse.getWriter();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        String action = httpServletRequest.getParameter("action");

        if (action.equalsIgnoreCase("Insert Teacher")) {
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
            teacherService.insert(teacher);
            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("window.location = 'index.html'");
            printWriter.println("alert('Inserted Successfully!!!!!!')");
            printWriter.println("</script>");
        }
    }

    protected void doPut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter = httpServletResponse.getWriter();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        String action = httpServletRequest.getParameter("action");
        if (action.equalsIgnoreCase("Update")) {
            String id = httpServletRequest.getParameter("id");
            Teacher teacher = teacherService.find(id);
            StringBuilder outputString = new StringBuilder();
            outputString.append(TmsUtils.getCommonCssJavascriptString())
                    .append(TmsUtils.getJqueryString())
                    .append("<div data-include=\"header\"></div>")
                    .append("<div class=\"heading\"><h1>Insert Teacher</h1></div>")
                    .append("<div class=\"container\"><div class=\"form\"><form method=\"put\" action=\"teacherController\">")
                    .append("<input type=\"hidden\" name=\"teacherId\" value=\"").append(teacher.getTeacherId()).append("\">")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Name</label><input type=\"text\" name=\"teacherName\" value=\"").append(teacher.getTeacherName()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Address</label><input type=\"text\" name=\"teacherAddress\" value=\"").append(teacher.getTeacherAddress()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Mobile</label><input type=\"text\" name=\"teacherMobile\" value=\"").append(teacher.getTeacherMobile()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Email</label><input type=\"text\" name=\"teacherEmailId\" value=\"").append(teacher.getTeacherEmailId()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-text\"><label class=\"head\">Salary</label><input type=\"text\" name=\"teacherSalary\" value=\"").append(teacher.getTeacherSalary()).append("\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"form-options1\"><label class=\"head\">Designation</label><select name=\"teacherDesignation\" class=\"category1\"><option value=\"\">---Select Designation---</option><option value=\"PROFESSOR\" ");
            if (teacher.getTeacherDesignation() == Designation.PROFESSOR)
                outputString.append("Selected");
            outputString.append(">Professor</option><option value=\"TEACHING_ASSISTANCE\" ");
            if (teacher.getTeacherDesignation() == Designation.TEACHING_ASSISTANCE)
                outputString.append("Selected");
            outputString.append(">Teaching Assistance</option><option value=\"LAB_STAFF\" ");
            if (teacher.getTeacherDesignation() == Designation.LAB_STAFF)
                outputString.append("Selected");
            outputString.append(">Lab Staff</option></select></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"submit\" name=\"action\" value=\"Update Teacher\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"reset\" name=\"action\" value=\"Reset\"></div>")
                    .append("<div class=\"clear\"></div><div class=\"butn\"><input type=\"button\" name=\"action\" value=\"Back\" onclick=\"document.location = 'teacherController?action=showallteachers'\"></div>")
                    .append("</form></div></div>");
            printWriter.println(outputString);
        } else if (action.equalsIgnoreCase("Update Teacher")) {
            Teacher teacher = new Teacher();
            teacher.setTeacherId(httpServletRequest.getParameter("teacherId"));
            teacher.setTeacherAddress(httpServletRequest.getParameter("teacherAddress"));
            teacher.setTeacherDesignation(Designation.valueOf(httpServletRequest.getParameter("teacherDesignation")));
            teacher.setTeacherEmailId(httpServletRequest.getParameter("teacherEmailId"));
            teacher.setTeacherMobile(httpServletRequest.getParameter("teacherMobile"));
            teacher.setTeacherName(httpServletRequest.getParameter("teacherName"));
            teacher.setTeacherSalary(Double.parseDouble(httpServletRequest.getParameter("teacherSalary")));
            teacherService.update(teacher);
            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("window.location = 'teacherController?action=showallteachers'");
            printWriter.println("alert('Updated Successfully!!!!!!')");
            printWriter.println("</script>");
        }
    }

    protected void doDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter printWriter = httpServletResponse.getWriter();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        TeacherStudentServiceImpl teacherStudentService = new TeacherStudentServiceImpl();
        String action = httpServletRequest.getParameter("action");
        if (action.equalsIgnoreCase("Delete")) {
            String id = httpServletRequest.getParameter("id");
            teacherService.delete(id);
            teacherStudentService.deleteByTeacherId(id);
            printWriter.println("<script type=\"text/javascript\">");
            printWriter.println("window.location = 'teacherController?action=showallteachers'");
            printWriter.println("alert('Deleted Successfully!!!!!!')");
            printWriter.println("</script>");
        }
    }
}
