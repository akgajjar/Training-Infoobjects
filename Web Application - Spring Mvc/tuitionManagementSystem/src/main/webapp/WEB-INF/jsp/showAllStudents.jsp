<%@page import="com.infoobjects.tms.utils.TmsUtils"%>
<%@page import="com.infoobjects.tms.entity.Student"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="/tms/resources/js/datatable/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/tablejs/datatables.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/dataTables.bootstrap.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/dataTables.buttons.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/buttons.bootstrap.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/jszip.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/pdfmake.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/vfs_fonts.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/buttons.html5.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/buttons.print.min.js"></script>
<script type="text/javascript"
	src="/tms/resources/js/datatable/buttons.colVis.min.js"></script>
<link href="/tms/resources/css/tablecss/css1.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="/tms/resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="/tms/resources/js/datatable/dataTables.bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="/tms/resources/js/datatable/buttons.bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="https://kit.fontawesome.com/b61ede621e.js" rel="stylesheet"
	type="text/css" media="all" />
<script>
	$(document).ready(
			function() {
				var table = $('#example').DataTable({
					buttons : [ 'copy', 'excel', 'pdf', 'print', 'colvis' ]
				});
				table.buttons().container().appendTo(
						'#example_wrapper .col-sm-6:eq(0)');
			});
</script>
<script type="text/javascript">
	var request = new XMLHttpRequest();
	$(document).ready(function() {
		$('#ab').DataTable();
	});
</script>
<link href="resources/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1 align="center" style=""1 em" ;color:#141414;">
		<b>Show All Students</b>
	</h1>
	<br />
	<br />
	<center>
		<%
			List<Student> students = (List<Student>) request.getAttribute("students");
		%>
		<b><font color="blue" size="5"></font></b>
	</center>
	<table cellpadding="10" id="example" class="display">
		<thead>
			<tr>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Class</th>
				<th>View Full Details</th>
				<th>View Teacher Name</th>
				<th>Update</th>
				<th>Delete</th>
		</thead>
		<tbody>
			<%
				for (Student student : students) {
			%>
			<tr>
				<td><%=student.getStudentId()%></td>
				<td><%=student.getStudentName()%></td>
				<td><%=student.getStudentClass()%></td>
				<td><form method="get"
						action="/tms<%=TmsUtils.viewStudentFullDetailsMapping%><%=student.getStudentId()%>">
						<input type="submit" name="action" class="btn btn-success"
							value="View Full Details">
					</form></td>
				<td><form method="get"
						action="/tms<%=TmsUtils.viewTeacherNameMapping%><%=student.getStudentId()%>">
						<input type="submit" name="action" class="btn btn-success"
							value="View Teacher Name">
					</form></td>
				<td><form method="get"
						action="/tms<%=TmsUtils.updateStudentFormMapping%><%=student.getStudentId()%>">
						<input type="submit" name="action" class="btn btn-success"
							value="Update">
					</form></td>
				<td><form method="post"
						action="/tms<%=TmsUtils.deleteStudentMapping%><%=student.getStudentId()%>">
						<input type="submit" name="action" class="btn btn-success"
							value="Delete">
					</form></td>
			</tr>
			<%
			}
		%>

		</tbody>
	</table>
</body>
</html>