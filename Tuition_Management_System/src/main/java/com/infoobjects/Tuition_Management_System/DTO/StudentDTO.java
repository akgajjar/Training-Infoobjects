package com.infoobjects.Tuition_Management_System.DTO;

import java.lang.reflect.Field;

public class StudentDTO {

	private int Student_id;
	private String Student_name;
	private String Student_address;
	private String Student_email_id;
	private String Student_gen;
	private String Student_mobile;
	private String Student_parent_name;
	private String Student_parent_mobile;
	private String Student_parent_email_id;
	private String Student_refname;

	@Override
	public String toString() {
		String ret = "\nStudent : \n\n";
		Class c = this.getClass();
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				ret += fields[i].getName() + " : " + String.valueOf(fields[i].get(this)) + "\n";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public int getStudent_id() {
		return Student_id;
	}

	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}

	public String getStudent_name() {
		return Student_name;
	}

	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}

	public String getStudent_address() {
		return Student_address;
	}

	public void setStudent_address(String student_address) {
		Student_address = student_address;
	}

	public String getStudent_email_id() {
		return Student_email_id;
	}

	public void setStudent_email_id(String student_email_id) {
		Student_email_id = student_email_id;
	}

	public String getStudent_gen() {
		return Student_gen;
	}

	public void setStudent_gen(String student_gen) {
		Student_gen = student_gen;
	}

	public String getStudent_mobile() {
		return Student_mobile;
	}

	public void setStudent_mobile(String student_mobile) {
		Student_mobile = student_mobile;
	}

	public String getStudent_parent_name() {
		return Student_parent_name;
	}

	public void setStudent_parent_name(String student_parent_name) {
		Student_parent_name = student_parent_name;
	}

	public String getStudent_parent_mobile() {
		return Student_parent_mobile;
	}

	public void setStudent_parent_mobile(String student_parent_mobile) {
		Student_parent_mobile = student_parent_mobile;
	}

	public String getStudent_parent_email_id() {
		return Student_parent_email_id;
	}

	public void setStudent_parent_email_id(String student_parent_email_id) {
		Student_parent_email_id = student_parent_email_id;
	}

	public String getStudent_refname() {
		return Student_refname;
	}

	public void setStudent_refname(String student_refname) {
		Student_refname = student_refname;
	}
}
