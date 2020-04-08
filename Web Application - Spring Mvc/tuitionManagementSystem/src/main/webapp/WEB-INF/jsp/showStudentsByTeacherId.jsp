<%@page import="com.infoobjects.tms.dto.Student"%>
<%@page import="com.infoobjects.tms.dto.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="/tms/resources/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript" src="/tms/resources/js/jquery.min.js"></script>
<link href="/tms/resources/css/showfulldetails.css" rel="stylesheet"
	type="text/css" media="all" />
</head>
<body>
	<%
	List<Student> students = (List<Student>) request.getAttribute("students");
%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="heading">
		<h1>Show Students By Teacher Id</h1>
	</div>
	<div class="container1">
		<table>
			<tr>
				<td class="head">Student Id</td>
				<td class="head">Name</td>
			</tr>
			<%
				for(Student student : students){
					%>
			<tr>
				<td class="b"><%=student.getStudentId() %></td>
				<td class="data"><%=student.getStudentName() %></td>
			</tr>

			<%}%>

		</table>
		<form action="/tms/home">
			<div class="btn">
				<input type="submit" name="button" id="btnform" value="BACK" />
			</div>
		</form>
	</div>
</body>
</html>