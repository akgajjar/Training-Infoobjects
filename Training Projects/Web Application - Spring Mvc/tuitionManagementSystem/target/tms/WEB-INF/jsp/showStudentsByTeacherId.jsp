<%@page import="com.infoobjects.tms.utils.StudentUtils"%>
<%@page import="com.infoobjects.tms.entity.Student"%>
<%@page import="com.infoobjects.tms.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link href="/tms/resources/css/style.css" rel="stylesheet"
	type="text/css" media="all" />

<script src="/tms/resources/js/form-validation/jquery.min.js"></script>
<link rel="stylesheet" href="/tms/resources/css/jquery-ui.css" />
<script src="/tms/resources/js/form-validation/jquery.validate.min.js"></script>


<link href="/tms/resources/css/showfulldetails.css" rel="stylesheet"
	type="text/css" media="all" />
</head>
<body>
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
			<c:forEach var="student" items="${students}">
				<tr>
					<td class="b">${student.studentId}</td>
					<td class="data">${student.studentName}</td>
				</tr>
			</c:forEach>
		</table>
		<form action="/tms${StudentUtils.homeMapping}">
			<div class="btn">
				<input type="submit" name="button" id="btnform" value="BACK" />
			</div>
		</form>
	</div>
</body>
</html>