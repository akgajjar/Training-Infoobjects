<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script src="/tms/resources/js/jquery.min.js"></script>
    <link href="/tms/resources/css/style.css" rel='stylesheet' type='text/css' media="all"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="heading">
    <h1>Tuition Management System</h1>
</div>
<div class="container">
    <div class="link-container">
    <h3><a href ="/tms/insertTeacher">Insert Teacher</a></h3>

    <h3><a href ="/tms/insertStudent">Insert Student</a></h3>
        <h3><a href ="/tms/insertTeacherStudent">Insert Mapping with Student</a></h3>
        <br><br>
        <h3><a href ="/tms/showAllStudents">Show All Students</a></h3>
        <h3><a href ="/tms/showAllTeachers">Show All Teachers</a></h3>
        <h3><a href ="/tms/getStudentsByTeacherIdForm">Show All Students for Teacher Id</a></h3>
        <h3><a href ="/tms/getAllTeacherStudents">Show All TeacherStudent Mapping</a></h3>
    </div>
</div>
</body>
</html>
