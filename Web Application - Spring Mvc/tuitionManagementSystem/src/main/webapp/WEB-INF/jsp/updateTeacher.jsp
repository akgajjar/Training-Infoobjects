<%@page import="com.infoobjects.tms.utils.TmsUtils"%>
<%@page import="com.infoobjects.tms.enums.Designation"%>
<%@page import="com.infoobjects.tms.entity.Teacher"%>
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
    <form method="post" action="/tms<%=TmsUtils.updateTeacherMapping %>">

			<input name="teacherId" type="hidden" value = "<%=teacher.getTeacherId() %>"/>
			
            <div class="clear"></div>
            <div class="form-text">
            <label  class="head">Name</label>
					<input name="teacherName" type="text"
						placeholder="Enter Teacher Name" value = "<%=teacher.getTeacherName() %>"/>
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <label  class="head">Address</label>
					<input name="teacherAddress" type="text"
						placeholder="Enter Teacher Address" value = "<%=teacher.getTeacherAddress() %>"/>
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <label  class="head">Mobile</label>
					<input name="teacherMobile" type="text"
						placeholder="Enter Teacher Mobile no" value = "<%=teacher.getTeacherMobile() %>"/>
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <label  class="head">Email Id</label>
					<input name="teacherEmailId" type="text"
						placeholder="Enter Teacher Email Id"  value = "<%=teacher.getTeacherEmailId() %>"/>
            </div>

            <div class="clear"></div>
            <div class="form-text">
            <label  class="head">Salary</label>
					<input name="teacherSalary" type="text"
						placeholder="Enter Teacher Salary" value = "<%=teacher.getTeacherSalary() %>"/>
            </div>

            <div class="clear"></div>
            <div class="form-options1">
            <label  class="head">Designation</label>
					<select name="teacherDesignation" class="category1" >
						<%if(teacher.getTeacherDesignation() == Designation.PROFESSOR){ %>
							<option selected  value="PROFESSOR" >Professor</option>
						<%}else{ %>
							<option value="PROFESSOR">Professor</option>
						<%} %>
						<%if(teacher.getTeacherDesignation() == Designation.TEACHING_ASSISTANCE){ %>
							<option selected  value="TEACHING_ASSISTANCE" >Teaching Assistance</option>
						<%}else{ %>
							<option value="TEACHING_ASSISTANCE">Teaching Assistance</option>
						<%} %>
						<%if(teacher.getTeacherDesignation() == Designation.LAB_STAFF){ %>
							<option  value="LAB_STAFF" >Lab Staff</option>
						<%}else{ %>
							<option value="LAB_STAFF">Lab Staff</option>
						<%} %>
					</select>
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
                <input type="button" name="action" value="Back" onclick="document.location = '/tms<%=TmsUtils.homeMapping%>'">
            </div>

        </form>
    </div>
</div>
</body>
</html>