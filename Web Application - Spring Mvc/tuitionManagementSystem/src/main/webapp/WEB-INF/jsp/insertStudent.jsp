<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<script src="/tms/resources/js/jquery.min.js"></script>
<link href="/tms/resources/css/style.css" rel='stylesheet' type='text/css'
	media="all" />

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="heading">
		<h1>Insert Student</h1>
	</div>

	<div class="container">
		<div class="form">
			<form:form method="post" action="/tms/insertStudent">

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentName" cssClass="head">Name</form:label>
					<form:input path="studentName" type="text"
						placeholder="Enter Student Name" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentClass" cssClass="head">Class</form:label>
					<form:input path="studentClass" type="text"
						placeholder="Enter Student Class" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentAddress" cssClass="head">Address</form:label>
					<form:input path="studentAddress" type="text"
						placeholder="Enter Student Address" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentMobile" cssClass="head">Mobile</form:label>
					<form:input path="studentMobile" type="text"
						placeholder="Enter Student Mobile" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentEmailId" cssClass="head">Email</form:label>
					<form:input path="studentEmailId" type="text"
						placeholder="Enter Student Email Id" />
				</div>

				<div class="clear"></div>
				<div class="form-options1">
					<form:label path="studentGender" cssClass="head">Gender</form:label>
					<form:select path="studentGender" cssClass="category1">
						<form:option value="">---Select Gender---</form:option>
						<form:option value="MALE">Male</form:option>
						<form:option value="FEMALE">Female</form:option>
					</form:select>
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentParentName" cssClass="head">Parent Name</form:label>
					<form:input path="studentParentName" type="text"
						placeholder="Enter Student's Parent Name" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentParentMobile" cssClass="head">Parent Mobile</form:label>
					<form:input path="studentParentMobile" type="text"
						placeholder="Enter tudent's Parent Mobile no" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentParentEmailId" cssClass="head">Parent Email</form:label>
					<form:input path="studentParentEmailId" type="text"
						placeholder="Enter Student's Parent Email Id" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentReferenceName" cssClass="head">Reference Name</form:label>
					<form:input path="studentReferenceName" type="text"
						placeholder="Enter Student's Reference Name" />
				</div>

				 <div class="clear"></div>
            <div class="butn">
                <input type="submit" name="action" value="Insert Student">
            </div>
        <div class="clear"></div>
        <div class="butn">
            <input type="reset" name="action" value="Reset">
        </div>

        <div class="clear"></div>
        <div class="butn">
            <input type="button" name="action" value="Back" onclick="document.location = '/tms/home'">
        </div>
			</form:form>
		</div>
	</div>
</body>
</html>