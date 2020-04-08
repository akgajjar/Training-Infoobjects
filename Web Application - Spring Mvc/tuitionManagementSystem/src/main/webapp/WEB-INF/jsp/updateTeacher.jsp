<%@page import="com.infoobjects.tms.enums.Designation"%>
<%@page import="com.infoobjects.tms.dto.Teacher"%>
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
<%
	Teacher teacher = (Teacher) request.getAttribute("teacher");
%>
<div class="container">
    <div class="form">
    <form:form method="post" action="/tms/updateTeacher">

			<form:input path="teacherId" type="hidden" value = "<%=teacher.getTeacherId() %>"/>
			
            <div class="clear"></div>
            <div class="form-text">
            <form:label path="teacherName" cssClass="head">Name</form:label>
					<form:input path="teacherName" type="text"
						placeholder="Enter Teacher Name" value = "<%=teacher.getTeacherName() %>"/>
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <form:label path="teacherAddress" cssClass="head">Address</form:label>
					<form:input path="teacherAddress" type="text"
						placeholder="Enter Teacher Address" value = "<%=teacher.getTeacherAddress() %>"/>
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <form:label path="teacherMobile" cssClass="head">Mobile</form:label>
					<form:input path="teacherMobile" type="text"
						placeholder="Enter Teacher Mobile no" value = "<%=teacher.getTeacherMobile() %>"/>
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <form:label path="teacherEmailId" cssClass="head">Email Id</form:label>
					<form:input path="teacherEmailId" type="text"
						placeholder="Enter Teacher Email Id"  value = "<%=teacher.getTeacherEmailId() %>"/>
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <form:label path="teacherSalary" cssClass="head">Salary</form:label>
					<form:input path="teacherSalary" type="text"
						placeholder="Enter Teacher Salary" value = "<%=teacher.getTeacherSalary() %>"/>
            </div>

            <div class="clear"></div>
            <div class="form-options1">
            <form:label path="teacherDesignation" cssClass="head">Designation</form:label>
					<form:select path="teacherDesignation" cssClass="category1" >
						<%if(teacher.getTeacherDesignation() == Designation.PROFESSOR){ %>
							<form:option selected = "true" value="PROFESSOR" >Professor</form:option>
						<%}else{ %>
							<form:option value="PROFESSOR">Professor</form:option>
						<%} %>
						<%if(teacher.getTeacherDesignation() == Designation.TEACHING_ASSISTANCE){ %>
							<form:option selected = "true" value="TEACHING_ASSISTANCE" >Teaching Assistance</form:option>
						<%}else{ %>
							<form:option value="TEACHING_ASSISTANCE">Teaching Assistance</form:option>
						<%} %>
						<%if(teacher.getTeacherDesignation() == Designation.LAB_STAFF){ %>
							<form:option selected = "true" value="LAB_STAFF" >Lab Staff</form:option>
						<%}else{ %>
							<form:option value="LAB_STAFF">Lab Staff</form:option>
						<%} %>
					</form:select>
            </div>

            <div class="clear"></div>
            <div class="butn">
                <input type="submit" name="action" value="Update Teacher">
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