<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
	<script src="/tms/resources/js/jquery.min.js"></script>
    <link href="/tms/resources/css/style.css" rel='stylesheet' type='text/css' media="all"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="heading">
    <h1>Insert Teacher</h1>
</div>
<div class="container">
    <div class="form">
    <form:form method="post" action="/tms/insertTeacher">

            <div class="clear"></div>
            <div class="form-text">
            <form:label path="teacherName" cssClass="head">Name</form:label>
					<form:input path="teacherName" type="text"
						placeholder="Enter Teacher Name" />
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <form:label path="teacherAddress" cssClass="head">Address</form:label>
					<form:input path="teacherAddress" type="text"
						placeholder="Enter Teacher Address" />
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <form:label path="teacherMobile" cssClass="head">Mobile</form:label>
					<form:input path="teacherMobile" type="text"
						placeholder="Enter Teacher Mobile no" />
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <form:label path="teacherEmailId" cssClass="head">Email Id</form:label>
					<form:input path="teacherEmailId" type="text"
						placeholder="Enter Teacher Email Id" />
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <form:label path="teacherSalary" cssClass="head">Salary</form:label>
					<form:input path="teacherSalary" type="text"
						placeholder="Enter Teacher Salary" />
            </div>

            <div class="clear"></div>
            <div class="form-options1">
            <form:label path="teacherDesignation" cssClass="head">Designation</form:label>
					<form:select path="teacherDesignation" cssClass="category1">
						<form:option value="">---Select Designation---</form:option>
						<form:option value="PROFESSOR">Professor</form:option>
						<form:option value="TEACHING_ASSISTANCE">Teaching Assistance</form:option>
						<form:option value="LAB_STAFF">Lab Staff</form:option>
					</form:select>
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
                <input type="button" name="action" value="Back" onclick="document.location = '/tms/home'">
            </div>

        </form:form>
    </div>
</div>
</body>
</html>