package com.infoobjects.tuitionManagementSystem.dto;

import java.lang.reflect.Field;

public class StudentDTO {

	private int studentId;
	private String studentName;
	private String studentAddress;
	private String studentEmailId;
	private String studentGender;
	private String studentMobile;
	private String studentParentName;
	private String studentParentMobile;
	private String studentParentEmailId;
	private String studentReferenceName;

	@Override
	public String toString() {
		String returnValue = "\nStudent : \n\n";
		Class classRef = this.getClass();
		Field[] fields = classRef.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				returnValue += fields[i].getName() + " : " + String.valueOf(fields[i].get(this)) + "\n";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return returnValue;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	public String getStudentParentName() {
		return studentParentName;
	}

	public void setStudentParentName(String studentParentName) {
		this.studentParentName = studentParentName;
	}

	public String getStudentParentMobile() {
		return studentParentMobile;
	}

	public void setStudentParentMobile(String studentParentMobile) {
		this.studentParentMobile = studentParentMobile;
	}

	public String getStudentParentEmailId() {
		return studentParentEmailId;
	}

	public void setStudentParentEmailId(String studentParentEmailId) {
		this.studentParentEmailId = studentParentEmailId;
	}

	public String getStudentReferenceName() {
		return studentReferenceName;
	}

	public void setStudentReferenceName(String studentReferenceName) {
		this.studentReferenceName = studentReferenceName;
	}
}
