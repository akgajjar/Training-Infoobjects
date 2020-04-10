<%@page import="com.infoobjects.tms.utils.TmsUtils"%>
<%@page import="com.infoobjects.tms.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<script src="/tms/resources/js/form-validation/jquery.min.js"></script>
<link rel="stylesheet" href="/tms/resources/css/jquery-ui.css"/>
<script src="/tms/resources/js/form-validation/jquery.validate.min.js"></script>
<script src="/tms/resources/js/form-validation/form-validation.js"></script>

<link href="/tms/resources/css/style.css" rel='stylesheet' type='text/css'
	media="all" />

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="heading">
		<h1>Show Students By Teacher Id</h1>
	</div>
<%
	List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
%>

	<div class="container">
		<div class="form">
			<form method="get" action="/tms<%=TmsUtils.getStudentByTeacherIdMapping %>" id="showStudentsByTeacherIdForm">

					<div class="clear"></div>
				<div class="form-options1">
					<label class="head">Teacher Id</label>
					<select name="teacherId" class="category1" id="teacherId">
						<option value="">---Select Teacher Id---</option>						
						
						<%
							for(Teacher teacher : teachers){
								%>
						<option value="<%=teacher.getTeacherId()%>"><%=teacher.getTeacherName()%> (<%=teacher.getTeacherId()%>)</option>
						<%}%>
					</select>
				</div>
				
				 <div class="clear"></div>
            <div class="butn">
                <input type="submit" name="action" value="Show Students">
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