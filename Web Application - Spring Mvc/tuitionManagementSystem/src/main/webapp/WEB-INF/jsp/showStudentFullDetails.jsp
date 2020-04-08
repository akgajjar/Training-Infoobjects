<%@page import="com.infoobjects.tms.dto.Student"%>
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
		Student student = (Student) request.getAttribute("student");
	%>
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
				<td class="data"><%=student.getStudentId()%></td>
			</tr>
			<tr>
				<td class="b">Name :</td>
				<td class="data"><%=student.getStudentName()%></td>
			</tr>
			<tr>
				<td class="b">Class :</td>
				<td class="data"><%=student.getStudentClass()%></td>
			</tr>
			<tr>
				<td class="b">Address:</td>
				<td class="data"><%=student.getStudentAddress()%></td>
			</tr>
			<tr>
				<td class="b">Mobile :</td>
				<td class="data"><%=student.getStudentMobile()%></td>
			</tr>
			<tr>
				<td class="b">Email :</td>
				<td class="data"><%=student.getStudentEmailId()%></td>
			</tr>
			<tr>
				<td class="b">Gender :</td>
				<td class="data"><%=student.getStudentGender()%></td>
			</tr>
			<tr>
			</tr>

			<tr>
				<td colspan="2" class="head">Student Parents & Reference
					Details</td>
			</tr>
			<tr>
				<td class="b">Parents Name :</td>
				<td class="data"><%=student.getStudentParentName()%></td>
			</tr>
			<tr>
				<td class="b">Parents Mobile :</td>
				<td class="data"><%=student.getStudentParentMobile()%></td>
			</tr>
			<tr>
				<td class="b">Parents Email :</td>
				<td class="data"><%=student.getStudentParentEmailId()%></td>
			</tr>
			<tr>
				<td class="b">Reference Name :</td>
				<td class="data"><%=student.getStudentReferenceName()%></td>
			</tr>
		</table>
		<form action="/tms/showAllStudents">
			<div class="btn">
				<input type="submit" name="button" id="btnform"  value="BACK" />
			</div>
		</form>
	</div>
</body>
</html>
