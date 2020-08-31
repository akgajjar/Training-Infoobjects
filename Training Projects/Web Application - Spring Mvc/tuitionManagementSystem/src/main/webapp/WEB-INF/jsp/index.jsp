<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@page import="com.infoobjects.tms.utils.TeacherStudentUtils"%>
<%@page import="com.infoobjects.tms.utils.TeacherUtils"%>
<%@page import="com.infoobjects.tms.utils.StudentUtils"%>
<!DOCTYPE html>
<html>
<head>
<script src="/tms/resources/js/form-validation/jquery.min.js"></script>
<link rel="stylesheet" href="/tms/resources/css/jquery-ui.css"/>
<script src="/tms/resources/js/form-validation/jquery.validate.min.js"></script>

<link href="/tms/resources/css/style.css" rel='stylesheet'
	type='text/css' media="all" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="heading">
		<h1>Tuition Management System</h1>
	</div>
	<div class="container">
		<div class="link-container">
			<h3>
				<a href="/tms${TeacherUtils.insertTeacherMapping}">Insert Teacher</a>
			</h3>

			<h3>
				<a href="/tms${StudentUtils.insertStudentMapping}">Insert Student</a>
			</h3>
			<h3>
				<a href="/tms${TeacherStudentUtils.insertTeacherStudentMapping}">Insert Mapping with Student</a>
			</h3>
			<br>
			<br>
			<h3>
				<a href="/tms${StudentUtils.showAllStudentsMapping}">Show All Students</a>
			</h3>
			<h3>
				<a href="/tms${TeacherUtils.showAllTeachersMapping}">Show All Teachers</a>
			</h3>
			<h3>
				<a href="/tms${TeacherStudentUtils.getStudentByTeacherIdFormMapping}">Show All Students for
					Teacher Id</a>
			</h3>
			<h3>
				<a href="/tms${TeacherStudentUtils.showAllTeacherStudentMapping}">Show All TeacherStudent
					Mapping</a>
			</h3>
		</div>
	</div>
</body>
</html>
