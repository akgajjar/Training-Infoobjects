package com.infoobjects.tms.dto;

import com.infoobjects.tms.dto.interfaces.DTO;


/**
 * @author Aniket
 * @description DTO Class - used to hold database record of TeacherStudent
 *              Mapping
 */
public class TeacherStudent implements DTO {
	private String teacherId;
	private String studentId;
	private String teacherName;
	private String studentName;

	/**
	 * toString method to display TeacherStudent's Mapping data
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "TeacherStudent [teacherId=" + teacherId + ", studentId=" + studentId + ", teacherName=" + teacherName
				+ ", studentName=" + studentName + "]";
	}

	/**
	 * getters and setters
	 */
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
