<%@page import="com.infoobjects.tms.utils.TmsUtils"%>
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
		<h1>Teacher's Name</h1>
	</div>
	<div class="container1">
		<table>
			<tr>
				<td class="head">Teacher Id</td>
				<td class="head">Name</td>
			</tr>
			<c:forEach var="teacher" items="${teachers}">
				<tr>
					<td class="b">${teacher.teacherId}</td>
					<td class="data">${teacher.teacherName}</td>
				</tr>
			</c:forEach>
		</table>
		<form action="/tms${TmsUtils.showAllStudentsMapping}">
			<div class="btn">
				<input type="submit" name="button" id="btnform" value="BACK" />
			</div>
		</form>
	</div>
</body>
</html>