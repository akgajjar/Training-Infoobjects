<%@page import="com.infoobjects.tms.dto.SubmitButton"%>
<%@page import="com.infoobjects.tms.dto.Data"%>
<%@page import="com.infoobjects.tms.dto.DisplayAllData"%>
<%@page import="com.infoobjects.tms.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<%
			
			DisplayAllData displayAllData = (DisplayAllData)request.getAttribute("displayAllData");
		%>
	<jsp:include page="header.jsp" />
	<h1 align="center" style="margin: 1 em; color: #141414;">
		<b><%=displayAllData.getDisplayAllDataHeading() %></b>
	</h1>
	<br />
	<br />
	<center>
		<b><font color="blue" size="5"></font></b>
	</center>
	<table cellpadding="10" id="example" class="display">
		<thead>
			<tr>
				<%
					for(String dataHeader : displayAllData.getDataHeaders()){
						%>
				<th><%=dataHeader %></th>
				<%
					}
					for(String buttonHeader : displayAllData.getButtonsHeaders()){
						%>
				<th><%=buttonHeader %></th>
				<%
					}
				%>
			</tr>
		</thead>
		<tbody>
			<%
				for (Data data : displayAllData.getDataToDisplay()) {
			%>
			<tr>
				<%
					for(String dataHeader : displayAllData.getDataHeaders()){
						%>
				<td>
					<%= data.getData().get(dataHeader)%>
				</td>
				<%
					}
					for(String buttonHeader : displayAllData.getButtonsHeaders()){
						%>
				<td><form
						method="<%=data.getSubmitButtons().get(buttonHeader).getFormMethod()%>"
						action="/tms<%=data.getSubmitButtons().get(buttonHeader).getFormAction()%>">
						<input type="submit" name="action" class="btn btn-success"
							value="<%=data.getSubmitButtons().get(buttonHeader).getButtonValue()%>">
					</form></td>
				<%
					}
				%>
			</tr>
			<%
			}
		%>
		</tbody>
	</table>
</body>
</html>