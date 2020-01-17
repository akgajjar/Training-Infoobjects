package com.infoobjects.Tuition_Management_System.Utils;

import java.util.List;
import java.util.Scanner;

import com.infoobjects.Tuition_Management_System.DTO.StudentDTO;
import com.infoobjects.Tuition_Management_System.Service.StudentService;
import com.infoobjects.Tuition_Management_System.ServiceImpl.StudentServiceImpl;

public class Projectutils {
	private static StudentService stuservice =null;; 
	private static Scanner sc= null;
	
	public Projectutils() {
		sc=new Scanner(System.in);
		stuservice= new StudentServiceImpl(); 
	}
	
	public void insertStudent() {
	
		StudentDTO student=new StudentDTO();
		System.out.println("\n\nEnter Student id : ");
		student.setStudent_id(sc.nextInt());
		System.out.println("Enter Student Name : ");
		student.setStudent_name(sc.next());
		System.out.println("Enter Student Address : ");
		student.setStudent_address(sc.next());
		System.out.println("Enter Student Email Id : ");
		student.setStudent_email_id(sc.next());
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
		System.out.println("Enter Student Mobile : ");
		student.setStudent_mobile(sc.next());
		System.out.println("Enter Student Parent Name : ");
		student.setStudent_parent_name(sc.next());
		System.out.println("Enter Student Parent Mobile : ");
		student.setStudent_parent_mobile(sc.next());
		System.out.println("Enter Student Parent Email Id : ");
		student.setStudent_parent_email_id(sc.next());
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
		System.out.println("Enter Student Email Id : ");
		student.setStudent_email_id(sc.next());
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
		System.out.println("Enter Student Mobile : ");
		student.setStudent_mobile(sc.next());
		System.out.println("Enter Student Parent Name : ");
		student.setStudent_parent_name(sc.next());
		System.out.println("Enter Student Parent Mobile : ");
		student.setStudent_parent_mobile(sc.next());
		System.out.println("Enter Student Parent Email Id : ");
		student.setStudent_parent_email_id(sc.next());
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
