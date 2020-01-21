package com.infoobjects.Tuition_Management_System.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.infoobjects.Tuition_Management_System.DTO.StudentDTO;
import com.infoobjects.Tuition_Management_System.Service.StudentService;
import com.infoobjects.Tuition_Management_System.ServiceImpl.StudentServiceImpl;

public class Projectutils {
	private static StudentService stuservice = null;
	private static BufferedReader br = null;
	private static String emailrejex = "[a-zA_Z0-9]+[@]{1}[a-zA_Z0-9]+[.]{1}[a-zA_Z0-9]{2,3}";
	private static String mobilerejex = "[789]{1}[0-9]{9}";

	public Projectutils() {
		stuservice = new StudentServiceImpl();
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public static boolean patternmatch(String pattern, String value) {
		return Pattern.matches(pattern, value);
	}

	public static String Scan(String msg) throws IOException {
		System.out.println("\nEnter " + msg + " : ");
		return br.readLine();
	}

	public static String ScanEmailid() throws IOException {
		String email = new String();
		while (true) {
			System.out.println("Enter Email Id : ");
			email = br.readLine();
			if (patternmatch(emailrejex, email))
				break;
			else {
				System.out.println("\nInvalid Email id !!!!!!!\n\n");
			}
		}
		return email;
	}

	public static String Scanmobile() throws IOException {
		String mobile = new String();
		while (true) {
			System.out.println("Enter  Mobile no : ");
			mobile = br.readLine();
			if (patternmatch(mobilerejex, mobile)) {
				break;
			} else {
				System.out.println("Invalid Mobile Number!!!!!!!!!!!");
			}
		}
		return mobile;
	}

	public static String Scangender() throws NumberFormatException, IOException {
		String gender = new String();
		while (true) {
			System.out.println("\nSelect Student Gender : \n1. Male\n2.Female\n");
			int c1 = Integer.parseInt(br.readLine());
			if (c1 == 1) {
				gender = "Male";
				break;
			} else if (c1 == 2) {
				gender = "Female";
				break;
			} else {
				System.out.println("Invalid choice!!!!!\nChoose again!!!!!!!!!!");
			}
		}
		return gender;
	}

	public void insertStudent() throws IOException {

		StudentDTO student = new StudentDTO();
		System.out.println("Student Details : ");
		student.setStudent_id(Integer.parseInt(Scan("Student Id")));
		student.setStudent_name(Scan("Student Name"));
		student.setStudent_address("Student Address");
		student.setStudent_email_id(ScanEmailid());
		student.setStudent_gen(Scangender());
		student.setStudent_mobile(Scanmobile());
		System.out.println("Parent Details : \n");
		student.setStudent_parent_name(Scan("Student Parent Name"));
		student.setStudent_parent_mobile(Scanmobile());
		student.setStudent_parent_email_id(ScanEmailid());
		student.setStudent_refname(Scan("Reference Name"));
		stuservice.insert(student);
	}

	public void deleteStudent() throws NumberFormatException, IOException {

		System.out.println("\nEnter a Student Id : ");
		int id = Integer.parseInt(Scan("Student Id"));
		stuservice.delete(id);
	}

	public void updateStudent() throws IOException {
		System.out.println("\nEnter a Student Id : ");
		int id = Integer.parseInt(br.readLine());
		findStudent(id);
		System.out.println("\n");
		StudentDTO student = new StudentDTO();
		student.setStudent_id(id);
		System.out.println("Student Details : ");
		student.setStudent_id(Integer.parseInt(Scan("Student Id")));
		student.setStudent_name(Scan("Name"));
		student.setStudent_address("Address");
		student.setStudent_email_id(ScanEmailid());
		student.setStudent_gen(Scangender());
		student.setStudent_mobile(Scanmobile());
		System.out.println("Parent Details : \n");
		student.setStudent_parent_name(Scan("Parent Name"));
		student.setStudent_parent_mobile(Scanmobile());
		student.setStudent_parent_email_id(ScanEmailid());
		student.setStudent_refname(Scan("Reference Name"));
		stuservice.update(student);
	}

	public void findStudent(int id) {
		StudentDTO student = stuservice.find(id);
		if (student == null) {
			System.out.println("\n\nNot Found !!!!!!!!!!!!\n\n");
			return;
		}
		System.out.println("\n" + student);
	}

	public void findAllStudent() {

		List<StudentDTO> students = stuservice.findAll();
		if (students.size() == 0) {
			System.out.println("\n\nNo Students !!!!!!!!!!!!\n\n");
			return;
		}
		System.out.println("Students : \n\n");
		for (int i = 0; i < students.size(); i++) {
			StudentDTO student = students.get(i);
			System.out.println(student + "\n");
		}
	}
}
