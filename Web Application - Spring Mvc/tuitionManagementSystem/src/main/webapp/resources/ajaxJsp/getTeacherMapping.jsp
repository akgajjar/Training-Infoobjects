<%@page import="com.infoobjects.tms.service.TeacherStudentServiceImpl"%>
<%@page import="com.infoobjects.tms.service.StudentServiceImpl"%>
<%@page import="com.infoobjects.tms.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.infoobjects.tms.service.TeacherServiceImpl"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String studentId = request.getParameter("studentId");
	
	if(studentId.equalsIgnoreCase("")){
		out.println("<option value=\"\">---Select Teacher---</form:option></select>");
	}
	else{
		ApplicationContext applicationContext =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		TeacherStudentServiceImpl teacherStudentService = (TeacherStudentServiceImpl)applicationContext.getBean("teacherStudentServiceImpl");
		List<Teacher> teachers = teacherStudentService.getTeachersForMapping(studentId);
		
		out.println("select name=\"teacherId\" class=\"category1\" id=\"teacherId\"><option value=\"\">---Select Teacher---</option>");
		for(Teacher teacher : teachers){
			out.println("<option value=\""+teacher.getTeacherId()+"\">"+teacher.getTeacherName()+" ("+teacher.getTeacherId()+")"+"</option>");
		}
		out.println("</select>");
		
	}

%>