package com.infoobjects.Tuition_Management_System.Utils;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.infoobjects.Tuition_Management_System.DTO.StudentDTO;
import com.infoobjects.Tuition_Management_System.Service.StudentService;
import com.infoobjects.Tuition_Management_System.ServiceImpl.StudentServiceImpl;

public class Projectutils {
	private static StudentService stuservice =null;; 
	private static Scanner sc= null;
	private static String emailrejex="[a-zA_Z0-9]+[@]{1}[a-zA_Z0-9]+[.]{1}[a-zA_Z0-9]{2,3}";
	private static String mobilerejex="[789]{1}[0-9]{9}";
	public Projectutils() {
		sc=new Scanner(System.in);
		stuservice= new StudentServiceImpl(); 
	}
	public static boolean patternmatch(String pattern , String value) {
		return Pattern.matches(pattern,value);
	}
	public static String ScanEmailid() {
		String email=new String();
		while(true) {	
			System.out.println("Enter Email Id : ");
			email=sc.next();
			if(patternmatch(emailrejex,email))
				break;
			else
			{
				System.out.println("\nInvalid Email id !!!!!!!\n\n");
			}
		}
		return email;
	}
	public static String Scanmobile() {
		String mobile=new String();
		while(true) {
			System.out.println("Enter  Mobile : ");
			mobile=sc.next();
			if(patternmatch(mobilerejex, mobile)) {
				break;
			}
			else {
				System.out.println("Unvalid Mobile Number!!!!!!!!!!!");
			}
		}
		return mobile;
	}
	public static String Scangender() {
		String gender=new String();
		while(true) {	
			System.out.println("\nSelect Student Gender : \n1. Male\n2.Female\n");
			int c1= sc.nextInt();
			if(c1==1) {
				gender="Male";
				break;
			}
			else if(c1==2) {
				gender="Female";
				break;
			}
			else {
				System.out.println("Invalid choice!!!!!\nChoose again!!!!!!!!!!");
			}
		}
		return gender;
	}
	public void insertStudent() {
	
		StudentDTO student=new StudentDTO();
		System.out.println("Student Details : ");
		System.out.println("\n\nEnter Student id : ");
		student.setStudent_id(sc.nextInt());
		System.out.println("Enter Name : ");
		student.setStudent_name(sc.next());
		System.out.println("Enter Address : ");
		student.setStudent_address(sc.next());
		student.setStudent_email_id(ScanEmailid());
		student.setStudent_gen(Scangender());
		student.setStudent_mobile(Scanmobile());
		System.out.println("Parent Details : \n");
		System.out.println("Enter Student Parent Name : ");
		student.setStudent_parent_name(sc.next());
		student.setStudent_parent_mobile(Scanmobile());
		student.setStudent_parent_email_id(ScanEmailid());
		System.out.println("Enter Reference Name : ");
		student.setStudent_refname(sc.next());
		stuservice.insert(student);
	}
	
	public void deleteStudent() {
		
		System.out.println("\nEnter a Student Id : ");
		int id = sc.nextInt();
		stuservice.delete(id);
	}
	
	public void updateStudent() {
		
		System.out.println("\nEnter a Student Id : ");
		int id = sc.nextInt();
		findStudent(id);
		System.out.println("\n");
		StudentDTO student=new StudentDTO();
		student.setStudent_id(id);
		System.out.println("Enter Student Name : ");
		student.setStudent_name(sc.next());
		System.out.println("Enter Student Address : ");
		student.setStudent_address(sc.next());
		while(true) {	
			System.out.println("Enter Student Email Id : ");
			student.setStudent_email_id(sc.next());
			if(Pattern.matches(emailrejex,student.getStudent_email_id()))
				break;
			else
			{
				System.out.println("\nInvalid Email id !!!!!!!\n\n");
			}
		}
		while(true) {	
			System.out.println("Select Student Gender : \n1. Male\n2.Female\n");
			int c1= sc.nextInt();
			if(c1==1) {
				student.setStudent_gen("Male");
				break;
			}
			else if(c1==2) {
				student.setStudent_gen("Female");
				break;
			}
			else {
				System.out.println("Invalid choice!!!!!\nChoose again!!!!!!!!!!");
			}
		}
		while(true) {
			System.out.println("Enter Student Mobile : ");
			student.setStudent_mobile(sc.next());
			if(Pattern.matches(mobilerejex, student.getStudent_mobile())) {
				break;
			}
			else {
				System.out.println("Unvalid Mobile Number!!!!!!!!!!!");
			}
		}
		System.out.println("Enter Student Parent Name : ");
		student.setStudent_parent_name(sc.next());
		while(true) {
			System.out.println("Enter Student Parent Mobile : ");
			student.setStudent_parent_mobile(sc.next());
			if(Pattern.matches(mobilerejex, student.getStudent_parent_mobile())) {
				break;
			}
			else {
				System.out.println("Unvalid Mobile Number!!!!!!!!!!!");
			}
		}
		while(true) {	
			System.out.println("Enter Student Parent Email Id : ");
			student.setStudent_parent_email_id(sc.next());
			if(Pattern.matches(emailrejex,student.getStudent_parent_email_id()))
				break;
			else
			{
				System.out.println("\nInvalid Email id !!!!!!!\n\n");
			}
		}
		System.out.println("Enter Reference Name : ");
		student.setStudent_refname(sc.next());
		stuservice.update(student);
	}
	
	public void findStudent(int id) {
		StudentDTO student = stuservice.find(id);
		if(student == null) {
			System.out.println("\n\nNot Found !!!!!!!!!!!!\n\n");
			return;
		}
		System.out.println("\n"+student);
	}
	
	public void findAllStudent() {
		
		List<StudentDTO> students = stuservice.findAll();
		if(students.size()==0) {
			System.out.println("\n\nNo Students !!!!!!!!!!!!\n\n");
			return;
		}
		System.out.println("Students : \n\n");
		  for (int i=0; i<students.size(); i++)
		  {
			  StudentDTO student =  students.get(i);
			  System.out.println(student + "\n"); 
		  }
	}
}
