<%@page import="com.infoobjects.tms.utils.TmsUtils"%>
<%@page import="com.infoobjects.tms.enums.Gender"%>
<%@page import="com.infoobjects.tms.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<link href="/tms/resources/css/style.css" rel='stylesheet'
	type='text/css' media="all" />
<script src="/tms/resources/js/form-validation/jquery.min.js"></script>
<link rel="stylesheet" href="/tms/resources/css/jquery-ui.css" />
<script src="/tms/resources/js/form-validation/jquery.validate.min.js"></script>
<script src="/tms/resources/js/form-validation/form-validation.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="heading">
		<h1>Insert Student</h1>
	</div>
	<%
		Student student = (Student) request.getAttribute("student");
	%>
	<div class="container">
		<div class="form">
			<form method="post" action="/tms<%=TmsUtils.updateStudentMapping%>"
				id="studentForm">

				<input name="studentId" type="hidden"
					value="<%=student.getStudentId()%>" />

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Name</label> <input name="studentName"
						id="studentName" type="text" placeholder="Enter Student Name"
						value="<%=student.getStudentName()%>" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Class</label> <input name="studentClass"
						id="studentClass" type="text" placeholder="Enter Student Class"
						value="<%=student.getStudentClass()%>" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Address</label> <input name="studentAddress"
						id="studentAddress" type="text"
						placeholder="Enter Student Address"
						value="<%=student.getStudentAddress()%>" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Mobile</label> <input name="studentMobile"
						id="studentMobile" type="text" placeholder="Enter Student Mobile"
						value="<%=student.getStudentMobile()%>" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Email</label> <input name="studentEmailId"
						id="studentEmailId" type="text"
						placeholder="Enter Student Email Id"
						value="<%=student.getStudentEmailId()%>" />
				</div>

				<div class="clear"></div>
				<div class="form-options1">
					<label class="head">Gender</label> <select name="studentGender"
						id="studentGender" class="category1">
						<option value="">---Select Gender---</option>
						<%
							if (student.getStudentGender() == Gender.MALE) {
						%>
						<option value="MALE" selected>Male</option>
						<option value="FEMALE">Female</option>
						<%
							} else {
						%>
						<option value="MALE" selected>Male</option>
						<option value="FEMALE">Female</option>

						<%
							}
						%>
					</select>
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Parent Name</label> <input
						name="studentParentName" type="text" id="studentParentName"
						placeholder="Enter Student's Parent Name"
						value="<%=student.getStudentParentName()%>" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Parent Mobile</label> <input
						name="studentParentMobile" type="text" id="studentParentMobile"
						placeholder="Enter tudent's Parent Mobile no"
						value="<%=student.getStudentParentMobile()%>" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Parent Email</label> <input
						name="studentParentEmailId" type="text" id="studentParentEmailId"
						placeholder="Enter Student's Parent Email Id"
						value="<%=student.getStudentParentEmailId()%>" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Reference Name</label> <input
						name="studentReferenceName" type="text" id="studentReferenceName"
						placeholder="Enter Student's Reference Name"
						value="<%=student.getStudentReferenceName()%>" />
				</div>

				<div class="clear"></div>
				<div class="butn">
					<input type="submit" name="action" value="Update Student">
				</div>
				<div class="clear"></div>
				<div class="butn">
					<input type="reset" name="action" value="Reset">
				</div>

				<div class="clear"></div>
				<div class="butn">
					<input type="button" name="action" value="Back"
						onclick="document.location = '/tms<%=TmsUtils.homeMapping%>'">
				</div>
			</form>
		</div>
	</div>
</body>
</html>