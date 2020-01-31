package com.infoobjects.tms.dto;

import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.enums.Gender;
import com.infoobjects.tms.enums.OperationType;

import static  com.infoobjects.tms.utils.TmsUtils.*;

import java.lang.reflect.Field;

public class StudentDTO implements DTO {

	private int studentId;
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
		System.out.println("\n Student : \n\n");
		StringBuffer returnValue = new StringBuffer();
		Class classReference = this.getClass();
		Field[] fields = classReference.getDeclaredFields();
		for (int loopCounter = 0; loopCounter < fields.length; loopCounter++) {
			try {
				returnValue.append(fields[loopCounter].getName());
				returnValue.append(" : ");
				returnValue.append(String.valueOf(fields[loopCounter].get(this)));
				returnValue.append("\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return returnValue.toString();
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

	public void updateDTOCheck(StudentDTO source){

		if(checkNull(this.getStudentAddress(), OperationType.PRINT))
			this.setStudentAddress(source.getStudentAddress());
		if(checkNull(this.getStudentEmailId(), OperationType.PRINT))
			this.setStudentEmailId(source.getStudentEmailId());
		if(checkNull(this.getStudentMobile(), OperationType.PRINT ))
			this.setStudentMobile(source.getStudentMobile());
		if(checkNull(this.getStudentName(),OperationType.PRINT ))
			this.setStudentName(source.getStudentName());
		if(checkNull(this.getStudentParentEmailId(), OperationType.PRINT))
			this.setStudentParentEmailId(source.getStudentParentEmailId());
		if(checkNull(this.getStudentParentMobile(),OperationType.PRINT))
			this.setStudentParentMobile(source.getStudentParentMobile());
		if(checkNull(this.getStudentParentName(), OperationType.PRINT))
			this.setStudentParentName(source.getStudentParentName());
		if(checkNull(this.getStudentReferenceName(), OperationType.PRINT))
			this.setStudentReferenceName(source.getStudentReferenceName());
		if(this.getStudentGender() == Gender.NONE)
			this.setStudentGender(source.getStudentGender());
	}

}
