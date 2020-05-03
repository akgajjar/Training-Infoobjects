package com.infoobjects.tms.entity;

import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.enums.Designation;
import com.infoobjects.tms.utils.TmsUtils;

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
 * @description DTO Class - used to hold database record of Teacher and
 *              TeacherStudent Mapping Related to Specific Teacher
 * @description Entity Class - Mapped with data base table Teacher and Teacher
 *              Student.
 * @description used to perform database operation related to Teacher and
 *              TeacherStudent Mapping Related to Specific Student
 */
@Entity
@Table(name = "Teacher", schema = "tms")
public class Teacher implements DTO {

	/**
	 * Database Field and it's Mapping Information for Teacher Table
	 */
	@Id
	@Column(name = "TEACHER_ID", length = 255, nullable = false, unique = true)
	private String teacherId;

	@Column(name = "TEACHER_NAME", length = 255, nullable = false, unique = false)
	private String teacherName;

	@Column(name = "TEACHER_ADDRESS", length = 255, nullable = false, unique = false)
	private String teacherAddress;

	@Column(name = "TEACHER_MOBILE", length = 15, nullable = false, unique = false)
	private String teacherMobile;

	@Column(name = "TEACHER_EMAIL_ID", length = 255, nullable = false, unique = false)
	private String teacherEmailId;

	@Enumerated(EnumType.STRING)
	@Column(name = "TEACHER_DESIGNATION", length = 50, nullable = false, unique = false)
	private Designation teacherDesignation;

	@Column(name = "TEACHER_SALARY", length = 15, nullable = false, unique = false)
	private Double teacherSalary;

	/**
	 * TeacherStudent Table Mapping Information
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "TeacherStudent", joinColumns = {
			@JoinColumn(name = "TEACHER_ID", nullable = false, updatable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "STUDENT_ID", nullable = false, updatable = false) })
	private List<Student> students;

	/**
	 * toString method to display Teacher data and TeacherStudent Mapping data
	 * related to that Teacher into Console
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return TmsUtils.genericToString(this);
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public String getTeacherMobile() {
		return teacherMobile;
	}

	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = teacherMobile;
	}

	public String getTeacherEmailId() {
		return teacherEmailId;
	}

	public void setTeacherEmailId(String teacherEmailId) {
		this.teacherEmailId = teacherEmailId;
	}

	public Designation getTeacherDesignation() {
		return teacherDesignation;
	}

	public void setTeacherDesignation(Designation teacherDesignation) {
		this.teacherDesignation = teacherDesignation;
	}

	public Double getTeacherSalary() {
		return teacherSalary;
	}

	public void setTeacherSalary(Double teacherSalary) {
		this.teacherSalary = teacherSalary;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
