<%@page import="com.infoobjects.tms.utils.StudentUtils"%>
<%@page import="com.infoobjects.tms.utils.TeacherUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<script src="/tms/resources/js/form-validation/jquery.min.js"></script>
<link rel="stylesheet" href="/tms/resources/css/jquery-ui.css" />
<script src="/tms/resources/js/form-validation/jquery.validate.min.js"></script>
<script src="/tms/resources/js/form-validation/form-validation.js"></script>

<link href="/tms/resources/css/style.css" rel='stylesheet'
	type='text/css' media="all" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="heading">
		<h1>Insert Teacher</h1>
	</div>
	<div class="container">
		<div class="form">
			<form method="post" action="/tms${TeacherUtils.insertTeacherMapping}" id="teacherForm">

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Name</label> <input name="teacherName" id="teacherName"
						type="text" placeholder="Enter Teacher Name" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Address</label> <input name="teacherAddress" id="teacherAddress"
						type="text" placeholder="Enter Teacher Address" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Mobile</label> <input name="teacherMobile" id="teacherMobile"
						type="text" placeholder="Enter Teacher Mobile no" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Email Id</label> <input name="teacherEmailId" id="teacherEmailId"
						type="text" placeholder="Enter Teacher Email Id" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Salary</label> <input name="teacherSalary" id="teacherSalary"
						type="text" placeholder="Enter Teacher Salary" />
				</div>

				<div class="clear"></div>
				<div class="form-options1">
					<label class="head">Designation</label> <select class="category1" id="teacherDesignation"
						name="teacherDesignation">
						<option value="">---Select Designation---</option>
						<option value="PROFESSOR">Professor</option>
						<option value="TEACHING_ASSISTANCE">Teaching Assistance</option>
						<option value="LAB_STAFF">Lab Staff</option>
					</select>
				</div>

				<div class="clear"></div>
				<div class="butn">
					<input type="submit" name="action" value="Insert Teacher">
				</div>
				<div class="clear"></div>
				<div class="butn">
					<input type="reset" name="action" value="Reset">
				</div>

				<div class="clear"></div>
				<div class="butn">
					<input type="button" name="action" value="Back"
						onclick="document.location = '/tms${StudentUtils.homeMapping}'">
				</div>
			</form>
		</div>
	</div>
</body>
</html>