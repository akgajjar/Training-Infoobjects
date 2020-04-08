<%@page import="com.infoobjects.tms.service.StudentServiceImpl"%>
<%@page import="com.infoobjects.tms.service.TeacherServiceImpl"%>
<%@page import="com.infoobjects.tms.service.TeacherStudentServiceImpl"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="com.infoobjects.tms.dto.TeacherStudent"%>
<%@page import="com.infoobjects.tms.dto.Teacher"%>
<%@page import="com.infoobjects.tms.dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<script type="text/javascript"
	src="/tms/resources/js/datatable/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/tablejs/datatables.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/dataTables.bootstrap.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/dataTables.buttons.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/buttons.bootstrap.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/jszip.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/pdfmake.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/vfs_fonts.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/buttons.html5.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/buttons.print.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/buttons.colVis.min.js"></script>
<link href="/tms/resources/css/tablecss/css1.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="/tms/resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="/tms/resources/js/datatable/dataTables.bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="/tms/resources/js/datatable/buttons.bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="https://kit.fontawesome.com/b61ede621e.js" rel="stylesheet"
	type="text/css" media="all" />
<script>
	$(document).ready(
			function() {
				var table = $('#example').DataTable({
					buttons : [ 'copy', 'excel', 'pdf', 'print', 'colvis' ]
				});
				table.buttons().container().appendTo(
						'#example_wrapper .col-sm-6:eq(0)');
			});
</script>
<script type="text/javascript">
	var request = new XMLHttpRequest();
	$(document).ready(function() {
		$('#ab').DataTable();
	});
</script>
<link href="/tms/resources/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<jsp:include page="header.jsp" />
<h1 align="center" style=""1 em" ;color:#141414;">
	<b>Show All Teacher Students</b>
</h1>
<br />
<br />
<center>
	<% 
	ApplicationContext applicationContext =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	List<TeacherStudent> teacherStudents = (List<TeacherStudent>)request.getAttribute("teacherStudents");
	TeacherServiceImpl teacherService = (TeacherServiceImpl)applicationContext.getBean("teacherServiceImpl");
	StudentServiceImpl studentService = (StudentServiceImpl)applicationContext.getBean("studentServiceImpl");
%>
	<b><font color="blue" size="5"></font></b>
</center>
<table cellpadding="10" id="example" class="display">
	<thead>
		<tr>
			<th>Student Id</th>
			<th>Student Name</th>
			<th>Teacher Id</th>
			<th>Teacher Name</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<%
			for(TeacherStudent teacherStudent : teacherStudents){
				%>
		<tr>
			<td><%=teacherStudent.getStudentId()%></td>
			<td><%= studentService.find(teacherStudent.getStudentId()).getStudentName()%></td>
			<td><%=teacherStudent.getTeacherId() %></td>
			<td><%=teacherService.find(teacherStudent.getTeacherId()).getTeacherName() %></td>
			<td><form method="post"
					action="/tms/teacherStudent/delete/<%=teacherStudent.getStudentId() %>/<%=teacherStudent.getTeacherId() %>">
					<input type="submit" name="action" class="btn btn-success"
						value="Delete">
				</form></td>
		</tr>
		<%
			}
		%>

	</tbody>
</table>