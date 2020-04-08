<%@page import="com.infoobjects.tms.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<script src="/tms/resources/js/jquery.min.js"></script>
<link href="/tms/resources/css/style.css" rel='stylesheet'
	type='text/css' media="all" />

<script type="text/javascript">

function getTeacherMapping() {
	
	var str=document.getElementById("studentId").value;
   
	 
	
    var request = new XMLHttpRequest();
		  var url = "/tms/resources/ajaxJsp/getTeacherMapping.jsp?studentId=" + str;
			try {
				request.onreadystatechange = function() {
					if (request.readyState == 4) {
						var val = request.responseText;
						document.getElementById("teacherId").innerHTML=val;
						
					}
					

				}
				request.open("GET", url, true);
				request.send();
				
			} catch (e) {
				alert("Unable to connect to server");
			}
}
</script>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="heading">
		<h1>Insert Teacher Student Mapping</h1>
	</div>

	<%
	List<Student> students = (List<Student>) request.getAttribute("students");
%>
	<div class="container">
		<div class="form">
			<form method="post" action="/tms/insertTeacherStudent" >

				<div class="clear"></div>
				<div class="form-options1">
					<label class="head">Student</label>
					<select name="studentId" class="category1" id="studentId"
						onchange="getTeacherMapping();">
						<option value="">---Select Student---</option>						
						
						<%
							for(Student student : students){
								%>
						<option value="<%=student.getStudentId()%>"><%=student.getStudentName()%> (<%=student.getStudentId()%>)</option>
						<%}%>
					</select>
				</div>

				<div class="clear"></div>
				<div class="form-options1">
					<label  class="head">Teacher</label>
					<div id="teacher">
						<select name="teacherId" class="category1" id="teacherId">
							<option value="">---Select Teacher---</option>
						</select>
					</div>
				</div>

				<div class="clear"></div>
				<div class="butn">
					<input type="submit" name="action" value="Insert Teacher Student Mapping">
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
			</form>
		</div>
	</div>
</body>
</html>