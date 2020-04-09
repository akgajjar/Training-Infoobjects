<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <script src="../../resources/js/jquery.min.js"></script>
    <script src="../../resources/js/style.js"></script>

    <link href="../../resources/css/style.css" rel='stylesheet' type='text/css' media="all"/>
</head>
<body>
<div data-include="header"></div>

<div class="heading">
    <h1>Insert Teacher</h1>
</div>
<div class="container">
    <div class="form">
        <form method="post" action="teacherController">

            <div class="clear"></div>
            <div class="form-text">
                <label class="head">Name</label>
                <input type="text" name="teacherName">
            </div>

            <div class="clear"></div>
            <div class="form-text">
                <label class="head">Address</label>
                <input type="text" name="teacherAddress">
            </div>

            <div class="clear"></div>
            <div class="form-text">
                <label class="head">Mobile</label>
                <input type="text" name="teacherMobile">
            </div>

            <div class="clear"></div>
            <div class="form-text">
                <label class="head">Email</label>
                <input type="text" name="teacherEmailId">
            </div>

            <div class="clear"></div>
            <div class="form-text">
                <label class="head">Salary</label>
                <input type="text" name="teacherSalary">
            </div>

            <div class="clear"></div>
            <div class="form-options1">
                <label class="head">Designation</label>
                <select name="teacherDesignation" class="category1">
                    <option value="">---Select Designation---</option>
                    <option value="PROFESSOR">Professor</option>
                    <option value="TEACHING_ASSISTANCE">Teaching Assistance</option>
                    <option value="LAB_STAFF">Lab Staff</option>
                </select>
            </div>

            <div class="clear"></div>
            <div class="butn">
                <input type="submit" name="action" value="Insert Teacher">
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