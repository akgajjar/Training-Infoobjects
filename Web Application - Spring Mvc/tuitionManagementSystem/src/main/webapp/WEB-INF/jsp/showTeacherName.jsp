<%@page import="com.infoobjects.tms.utils.TmsUtils"%>
<%@page import="com.infoobjects.tms.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="/tms/resources/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript" src="/tms/resources/js/jquery.min.js"></script>
<link href="/tms/resources/css/showfulldetails.css" rel="stylesheet"
	type="text/css" media="all" />
</head>
<body>
	<%
	List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="heading">
		<h1>Teacher's Name</h1>
	</div>
	<div class="container1">
		<table>
			<tr>
				<td class="head">Teacher Id</td>
				<td class="head">Name</td>
			</tr>
			<%
				for(Teacher teacher : teachers){
					%>
			<tr>
				<td class="b"><%=teacher.getTeacherId() %></td>
				<td class="data"><%=teacher.getTeacherName() %></td>
			</tr>

			<%}%>

		</table>
		<form action="/tms<%=TmsUtils.showAllStudentsMapping%>">
			<div class="btn">
				<input type="submit" name="button" id="btnform" value="BACK" />
			</div>
		</form>
	</div>
</body>
</html>