<%@page import="com.infoobjects.tms.utils.TmsUtils"%>
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
    <form method="post" action="/tms<%=TmsUtils.insertTeacherMapping %>">

            <div class="clear"></div>
            <div class="form-text">
            <label class="head">Name</label>
					<input name="teacherName" type="text"
						placeholder="Enter Teacher Name" />
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <label class="head">Address</label>
					<input name = "teacherAddress" type = "text"
						placeholder = "Enter Teacher Address" />
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <label class="head">Mobile</label>
					<input name = "teacherMobile" type="text"
						placeholder="Enter Teacher Mobile no" />
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <label class="head">Email Id</label>
					<input name="teacherEmailId" type="text"
						placeholder="Enter Teacher Email Id" />
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <label class="head">Salary</label>
					<input name="teacherSalary" type="text"
						placeholder="Enter Teacher Salary" />
            </div>

            <div class="clear"></div>
            <div class="form-options1">
            <label class="head">Designation</label>
					<select class="category1" name = "teacherDesignation">
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
                <input type="button" name="action" value="Back" onclick="document.location = '/tms<%= TmsUtils.homeMapping%>'">
            </div>

        </form>
    </div>
</div>
</body>
</html>