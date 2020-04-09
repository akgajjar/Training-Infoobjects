<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <script src="../../resources/js/jquery.min.js"></script>
    <script src="../../resources/js/style.js"></script>
    <link href="../../resources/css/style.css" rel='stylesheet' type='text/css' media="all" />

</head>
<body>
<div data-include="header"></div>

<div class="heading">
    <h1>Insert Student</h1>
</div>
<div class="container" >
    <div class="form">
    <form method="post" action="/insertStudent" >

        <div class="clear"></div>
            <div class="form-text">
                <label class="head">Name</label>
                <input type="text" name="studentName" placeholder="Enter Student Name">
            </div>

        <div class="clear"></div>
        <div class="form-text">
            <label class="head">Class</label>
            <input type="text" name="studentClass" placeholder="Enter Student Class">
        </div>

        <div class="clear"></div>
            <div class="form-text">
                <label class="head">Address</label>
                <input type="text" name="studentAddress" placeholder="Enter Student Address">
            </div>

        <div class="clear"></div>
            <div class="form-text">
                <label class="head">Mobile</label>
                <input type="text" name="studentMobile" placeholder="Enter Student Mobile">
            </div>

        <div class="clear"></div>
            <div class="form-text">
                <label class="head">Email</label>
               <input type="text" name="studentEmailId" placeholder="Enter Student Email Id">
            </div>

        <div class="clear"></div>
            <div class="form-options1">
                <label class="head">Gender</label>
                <select name="studentGender" class="category1">
                    <option value="">---Select Gender---</option>
                    <option value="MALE">Male</option>
                    <option value="FEMALE">Female</option>
                </select>
            </div>

        <div class="clear"></div>
            <div class="form-text">
                <label class="head">Parent Name</label>
                <input type="text" name="studentParentName" placeholder="Enter Student's Parent Name">
            </div>

        <div class="clear"></div>
            <div class="form-text">
                <label class="head">Parent Mobile</label>
                <input type="text" name="studentParentMobile" placeholder="Enter Student's Parent Mobile no">
            </div>

        <div class="clear"></div>
            <div class="form-text">
                <label class="head">Parent Email</label>
                <input type="text" name="studentParentEmailId" placeholder="Enter Student's Parent Email Id">

            </div>

        <div class="clear"></div>
            <div class="form-text">
                <label class="head">Reference Name</label>
                <input type="text" name="studentReferenceName" placeholder="Enter Student's Reference Name">
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
            <input type="button" name="action" value="Back" onclick="document.location = '/tms/home'">
        </div>
    </form>
    </div>
</div>
</body>
</html>