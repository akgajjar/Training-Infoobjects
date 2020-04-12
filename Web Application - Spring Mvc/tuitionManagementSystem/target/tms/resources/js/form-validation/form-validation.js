/**
 * 
 */

$().ready(function() {
	 
	$("#studentForm").validate({
		onfocusout: function(element) {
	         this.element(element);
	      },
	      
		rules : {
			studentName : {
				required : true,
				maxlength : 255,
				OnlyAlpha : true
			},
			studentClass:{
				required:true,
				maxlength : 5,
				onlydigit : true
			},
			studentAddress :{
				required:true,
				maxlength : 255
			},
			studentMobile:{
				required:true,
				mobile_no:true
			},
			studentEmailId : {
				required : true,
				email_add:true,
				maxlength : 255,
			},
			
			studentGender : {
				required:true
			},
			studentParentName : {
				required : true,
				maxlength : 255,
				OnlyAlpha : true
			},
			studentParentMobile:{
				required:true,
				mobile_no:true
			},
			studentParentEmailId : {
				required : true,
				email_add:true,
				maxlength : 255
			},
			studentReferenceName : {
				required : true,
				maxlength : 255,
				OnlyAlpha : true
			}
		},
		messages : {
			studentName : {
				required : "Please Enter a Student's Name.",
				maxlength : $.format("Maximum {0} characters allowed!")
			},
			studentClass:{
				required:"Please Enter a Student's Class.",
				maxlength : $.format("Maximum {0} characters allowed!")
			},
			studentAddress:{
				required:"Please Enter a Student's Address.",
				maxlength : $.format("Maximum {0} characters allowed!")
			},
			studentMobile:{
				required:"Please Enter a Student's Mobile Number."
			},
			studentEmailId:{
				required:"Please Enter a Student's Email Address.",
					maxlength : $.format("Maximum {0} characters allowed!")
			},
			
			studentGender : {
				required:"Please Select a Student's Gender."
			},
			studentParentName : {
				required : "Please Enter a Student's Parent Name.",
				maxlength : $.format("Maximum {0} characters allowed!")
			},
			studentParentMobile:{
				required:"Please Enter a Student's Parent Mobile Number."
			},
			studentParentEmailId:{
				required:"Please Enter a Student's Parent Email Address.",
				maxlength : $.format("Maximum {0} characters allowed!")
			},
			studentReferenceName : {
				required : "Please Enter a Reference's Name.",
				maxlength : $.format("Maximum {0} characters allowed!")
			}
		}
	});
	
	
	$("#teacherForm").validate({
		onfocusout: function(element) {
	         this.element(element);
	      },
	      
		rules : {
			teacherName : {
				required : true,
				maxlength : 255,
				OnlyAlpha : true
			},
			teacherAddress :{
				required:true,
				maxlength : 255
			},
			teacherMobile:{
				required:true,
				mobile_no:true
			},
			teacherEmailId : {
				required : true,
				email_add:true,
				maxlength : 255,
			},
			teacherSalary:{
				required:true,
				maxlength : 15,
				onlydigit : true
			},
			teacherDesignation : {
				required:true
			}
		},
		messages : {
			teacherName : {
				required : "Please Enter a Teacher's Name.",
				maxlength : $.format("Maximum {0} characters allowed!")
			},
			teacherAddress:{
				required:"Please Enter a Teacher's Address.",
				maxlength : $.format("Maximum {0} characters allowed!")
			},
			teacherMobile:{
				required:"Please Enter a Teacher's Mobile Number."
			},
			teacherEmailId:{
				required:"Please Enter a Teacher's Email Address.",
					maxlength : $.format("Maximum {0} characters allowed!")
			},
			teacherSalary:{
				required:"Please Enter a Teacher's Salary.",
				maxlength : $.format("Maximum {0} characters allowed!")
			},
			teacherDesignation : {
				required:"Please Select a Teacher's teacherDesignation."
			}
		}
	});
	
	$("#teacherStudentForm").validate({
		onfocusout: function(element) {
	         this.element(element);
	      },
	      
		rules : {
			teacherId : {
				required:true
			},
			studentId : {
				required:true
			}
		},
		messages : {
			teacherId : {
				required:"Please Select a Teacher."
			},
			studentId : {
				required:"Please Select a Student."
			}
		}
	});
	$("#showStudentsByTeacherIdForm").validate({
		onfocusout: function(element) {
	         this.element(element);
	      },
	      
		rules : {
			teacherId : {
				required:true
			}
		},
		messages : {
			teacherId : {
				required:"Please Select a Teacher Id."
			}
		}
	});
		
	$.validator.addMethod("OnlyAlpha", function(value, element) {
		return /^[A-Za-z ]+$/.test(value);
	}, "Please Alpha Characters Only.");
	$.validator.addMethod("username", function(value, element) {
		return /^[A-Za-z0-9_.@#]+$/.test(value);
	}, "Please Enter a Valid Username.");
	$.validator.addMethod("email_add", function(value, element)
	{
		return this.optional(element) || /^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\.[a-zA-Z.]{2,3}$/i.test(value);
	}, "Please enter a valid email address.");
	$.validator.addMethod("mobile_no",function(value,element)
			{
				return this.optional(element) || /^[9876]\d{9}$/i.test(value);
			},"Enter a Valid 10 Digit Indian Mobile No.");
	$.validator.addMethod("aadhar",function(value,element)
			{
				return this.optional(element) || /^[0-9]{12}$/i.test(value);
			},"Enter a Valid Aadhar Card Number");
	$.validator.addMethod("onlydigit",function(value,element)
			{
				return this.optional(element) || /^[0-9]{1,9}$/i.test(value);
			},"Only Digits are Allowed.");
	$.validator.addMethod("password",function(value,element)
	{
		return this.optional(element) || /^[A-Za-z0-9!@#$%^&*()_]{6,16}$/i.test(value);
	},"Please Enter Valid 6 to 16 Character Password.");
});    
