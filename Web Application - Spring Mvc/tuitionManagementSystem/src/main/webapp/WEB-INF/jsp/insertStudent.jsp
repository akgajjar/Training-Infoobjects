<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import=" com.infoobjects.tms.utils.TmsUtils"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<script src="/tms/resources/js/jquery.min.js"></script>
<link href="/tms/resources/css/style.css" rel='stylesheet' type='text/css'
	media="all" />

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="heading">
		<h1>Insert Student</h1>
	</div>

	<div class="container">
		<div class="form">
			<form method="post" action="/tms<%=TmsUtils.insertStudentMapping %>">

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Name</label>
					<input name ="studentName" type="text"
						placeholder="Enter Student Name" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label  class="head">Class</label>
					<input name="studentClass" type="text"
						placeholder="Enter Student Class" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Address</label>
					<input name="studentAddress" type="text"
						placeholder="Enter Student Address" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label  class="head">Mobile</label>
					<input name="studentMobile" type="text"
						placeholder="Enter Student Mobile" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label  class="head">Email</label>
					<input name="studentEmailId" type="text"
						placeholder="Enter Student Email Id" />
				</div>

				<div class="clear"></div>
				<div class="form-options1">
					<label  class="head">Gender</label>
					<select name="studentGender" class="category1">
						<option value="">---Select Gender---</option>
						<option value="MALE">Male</option>
						<option value="FEMALE">Female</option>
					</select>
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label  class="head">Parent Name</label>
					<input name="studentParentName" type="text"
						placeholder="Enter Student's Parent Name" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label  class="head">Parent Mobile</label>
					<input name="studentParentMobile" type="text"
						placeholder="Enter tudent's Parent Mobile no" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label class="head">Parent Email</label>
					<input name="studentParentEmailId" type="text"
						placeholder="Enter Student's Parent Email Id" />
				</div>

				<div class="clear"></div>
				<div class="form-text">
					<label  class="head">Reference Name</label>
					<input name="studentReferenceName" type="text"
						placeholder="Enter Student's Reference Name" />
				</div>

				 <div class="clear"></div>
            <div class="butn">
                <input type="submit" name="action" value="Insert Student">
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