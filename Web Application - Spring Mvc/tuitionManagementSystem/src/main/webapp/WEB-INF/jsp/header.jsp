<%@page import="com.infoobjects.tms.utils.TeacherStudentUtils"%>
<%@page import="com.infoobjects.tms.utils.TeacherUtils"%>
<%@page import="com.infoobjects.tms.utils.StudentUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/tms/resources/css/bootstrap.css">
<script src="/tms/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/tms/resources/css/style.css">

</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Tuition Management System</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/tms${StudentUtils.homeMapping}">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Teacher <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/tms${TeacherUtils.insertTeacherMapping}">Insert
								Teacher</a></li>
						<li><a href="/tms${TeacherUtils.showAllTeachersMapping}">Show
								All Teachers</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Student <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/tms${StudentUtils.insertStudentMapping}">Insert
								Student</a></li>
						<li><a href="/tms${StudentUtils.showAllStudentsMapping}">Show
								All Student</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Teacher Student <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/tms${TeacherStudentUtils.insertTeacherStudentMapping}">Insert
								Mapping with Student</a></li>
						<li><a
							href="/tms${TeacherStudentUtils.getStudentByTeacherIdFormMapping}">Show
								All Students for Teacher Id</a></li>
						<li><a href="/tms${TeacherStudentUtils.showAllTeacherStudentMapping}">Show
								All TeacherStudent Mapping</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
</body>
</html>