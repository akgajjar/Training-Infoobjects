package com.infoobjects.tms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.enums.Gender;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Aniket
 * @description DTO Class - used to hold database record of Student and
 *              TeacherStudent Mapping Related to Specific Student
 * @description Entity Class - Mapped with data base table Student and Teacher
 *              Student
 * @description used to perform database operation related to Student and
 *              TeacherStudent Mapping Related to Specific Student
 */
@Entity
@Table(name = "Student", schema = "tms")
@JsonIgnoreProperties(value= {"teachers"})
public class Student implements DTO {

	/**
	 * Database Field and it's Mapping Information for Student Table
	 */
	@Id
	@Column(name = "STUDENT_ID", length = 255, nullable = false, unique = true)
	private String studentId;

	@Column(name = "STUDENT_NAME", length = 255, nullable = false, unique = false)
	private String studentName;

	@Column(name = "STUDENT_ADDRESS", length = 255, nullable = false, unique = false)
	private String studentAddress;

	@Column(name = "STUDENT_EMAIL_ID", length = 255, nullable = false, unique = false)
	private String studentEmailId;

	@Enumerated(EnumType.STRING)
	@Column(name = "STUDENT_GENDER", length = 10, nullable = false, unique = false)
	private Gender studentGender;

	@Column(name = "STUDENT_MOBILE", length = 15, nullable = false, unique = false)
	private String studentMobile;

	@Column(name = "STUDENT_PARENT_NAME", length = 255, nullable = false, unique = false)
	private String studentParentName;

	@Column(name = "STUDENT_PARENT_MOBILE", length = 15, nullable = false, unique = false)
	private String studentParentMobile;

	@Column(name = "STUDENT_PARENT_EMAIL_ID", length = 255, nullable = false, unique = false)
	private String studentParentEmailId;

	@Column(name = "STUDENT_REFERENCE_NAME", length = 255, nullable = false, unique = false)
	private String studentReferenceName;

	@Column(name = "STUDENT_CLASS", length = 5, nullable = false, unique = false)
	private int studentClass;

	/**
	 * TeacherStudent Table Mapping Information
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "TeacherStudent", joinColumns = {
			@JoinColumn(name = "STUDENT_ID", nullable = false, updatable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "TEACHER_ID", nullable = false, updatable = false) })
	private List<Teacher> teachers;

	/**
	 * toString method to display Student data and TeacherStudent Mapping data
	 * related to that Student into Console
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", studentEmailId=" + studentEmailId + ", studentGender=" + studentGender + ", studentMobile="
				+ studentMobile + ", studentParentName=" + studentParentName + ", studentParentMobile="
				+ studentParentMobile + ", studentParentEmailId=" + studentParentEmailId + ", studentReferenceName="
				+ studentReferenceName + ", studentClass=" + studentClass + "]";
	}

	/**
	 * getters and setters
	 */
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

	public int getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

}
