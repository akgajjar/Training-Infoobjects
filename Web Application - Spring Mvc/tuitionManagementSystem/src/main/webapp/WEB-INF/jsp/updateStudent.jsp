<%@page import="com.infoobjects.tms.enums.Gender"%>
<%@page import="com.infoobjects.tms.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<link href="/tms/resources/css/style.css" rel='stylesheet'
	type='text/css' media="all" />
<script src="/tms/resources/js/jquery.min.js"></script>
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
			<form:form method="post" action="/tms/updateStudent">
	
			<form:input path="studentId" type="hidden" value = "<%=student.getStudentId() %>"/>
	
				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentName" cssClass="head">Name</form:label>
					<form:input path="studentName" type="text"
						placeholder="Enter Student Name" value = "<%=student.getStudentName() %>"/>
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentClass" cssClass="head">Class</form:label>
					<form:input path="studentClass" type="text"
						placeholder="Enter Student Class" value = "<%=student.getStudentClass() %>"/>
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentAddress" cssClass="head">Address</form:label>
					<form:input path="studentAddress" type="text"
						placeholder="Enter Student Address" value = "<%=student.getStudentAddress() %>"/>
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentMobile" cssClass="head">Mobile</form:label>
					<form:input path="studentMobile" type="text"
						placeholder="Enter Student Mobile" value = "<%=student.getStudentMobile() %>"/>
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentEmailId" cssClass="head">Email</form:label>
					<form:input path="studentEmailId" type="text"
						placeholder="Enter Student Email Id" value = "<%=student.getStudentEmailId() %>"/>
				</div>

				<div class="clear"></div>
				<div class="form-options1">
					<form:label path="studentGender" cssClass="head">Gender</form:label>
					<form:select path="studentGender" cssClass="category1">
					<%
					if(student.getStudentGender()==Gender.MALE)
						{ %>
							<form:option value="MALE" selected = "true">Male</form:option>
							<form:option value="FEMALE">Female</form:option>
						<%}
					else
						 {%>
							<form:option value="MALE" selected = "true">Male</form:option>
							<form:option value="FEMALE" >Female</form:option>
						 
						<%}%>
					</form:select>
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentParentName" cssClass="head">Parent Name</form:label>
					<form:input path="studentParentName" type="text"
						placeholder="Enter Student's Parent Name" value = "<%=student.getStudentParentName() %>"/>
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentParentMobile" cssClass="head">Parent Mobile</form:label>
					<form:input path="studentParentMobile" type="text"
						placeholder="Enter tudent's Parent Mobile no"  value = "<%=student.getStudentParentMobile() %>"/>
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentParentEmailId" cssClass="head">Parent Email</form:label>
					<form:input path="studentParentEmailId" type="text"
						placeholder="Enter Student's Parent Email Id" value = "<%=student.getStudentParentEmailId() %>" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<form:label path="studentReferenceName" cssClass="head">Reference Name</form:label>
					<form:input path="studentReferenceName" type="text"
						placeholder="Enter Student's Reference Name" value = "<%=student.getStudentReferenceName() %>"/>
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
						onclick="document.location = '/tms/home'">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>