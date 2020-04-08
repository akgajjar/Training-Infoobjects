<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <script src="../../resources/js/jquery.min.js"></script>
    <script src="../../resources/js/style.js"></script>

    <link href="../../resources/css/style.css" rel='stylesheet' type='text/css' media="all"/>

</head>
<body>
<div data-include="header"></div>
<div class="heading">
    <h1>Tuition Management System</h1>
</div>


<div class="container">
    <div class="link-container">
    <h3><a href ="/tms/insertTeacher">Insert Teacher</a></h3>

    <h3><a href ="/tms/insertStudent">Insert Student</a></h3>
        <h3><a href ="teacherStudentController?action=TeacherStudentForm">Insert Mapping with Student</a></h3>
        <br><br>
        <h3><a href ="studentController?action=showallstudents">Show All Students</a></h3>
        <h3><a href ="teacherController?action=showallteachers">Show All Teachers</a></h3>
        <h3><a href ="teacherStudentController?action=ShowAllStudentsforSpecificTeacherId">Show All Students for Teacher Id</a></h3>
        <h3><a href ="teacherStudentController?action=ShowAllTeacherStudent">Show All TeacherStudent Mapping</a></h3>
    </div>
</div>
</body>
</html>
