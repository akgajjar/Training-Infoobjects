package com.infoobjects.tms.dto;

import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.enums.Gender;
import com.infoobjects.tms.enums.OperationType;

import static  com.infoobjects.tms.utils.TmsUtils.*;

public class Student implements DTO {

	private String studentId;
	private String studentName;
	private String studentAddress;
	private String studentEmailId;
	private Gender studentGender;
	private String studentMobile;
	private String studentParentName;
	private String studentParentMobile;
	private String studentParentEmailId;
	private String studentReferenceName;
	@Override
	public String toString() {
		System.out.println("Student : \n");
		return genericToString(this);
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
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

	public Gender getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(Gender studentGender) {
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
