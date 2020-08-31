<%@page import="com.infoobjects.tms.utils.StudentUtils"%>
<%@page import="com.infoobjects.tms.entity.Student"%>
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
		<h1>Show Full Details</h1>
	</div>
	<div class="container1">
		<table>
			<tr>
				<td colspan="2" class="head">Student Personal Details</td>
			</tr>
			<tr>
				<td class="b">Student Id :</td>
				<td class="data">${student.studentId}</td>
			</tr>
			<tr>
				<td class="b">Name :</td>
				<td class="data">${student.studentName}</td>
			</tr>
			<tr>
				<td class="b">Class :</td>
				<td class="data">${student.studentClass}</td>
			</tr>
			<tr>
				<td class="b">Address:</td>
				<td class="data">${student.studentAddress}</td>
			</tr>
			<tr>
				<td class="b">Mobile :</td>
				<td class="data">${student.studentMobile}</td>
			</tr>
			<tr>
				<td class="b">Email :</td>
				<td class="data">${student.studentEmailId}</td>
			</tr>
			<tr>
				<td class="b">Gender :</td>
				<td class="data">${student.studentGender}</td>
			</tr>
			<tr>
			</tr>

			<tr>
				<td colspan="2" class="head">Student Parents & Reference
					Details</td>
			</tr>
			<tr>
				<td class="b">Parents Name :</td>
				<td class="data">${student.studentParentName}</td>
			</tr>
			<tr>
				<td class="b">Parents Mobile :</td>
				<td class="data">${student.studentParentMobile}</td>
			</tr>
			<tr>
				<td class="b">Parents Email :</td>
				<td class="data">${student.studentParentEmailId}</td>
			</tr>
			<tr>
				<td class="b">Reference Name :</td>
				<td class="data">${student.studentReferenceName}</td>
			</tr>
		</table>
		<form action="/tms${StudentUtils.showAllStudentsMapping}">
			<div class="btn">
				<input type="submit" name="button" id="btnform" value="BACK" />
			</div>
		</form>
	</div>
</body>
</html>
