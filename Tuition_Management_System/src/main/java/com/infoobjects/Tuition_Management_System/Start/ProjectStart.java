package com.infoobjects.Tuition_Management_System.Start;

import java.util.Scanner;

import com.infoobjects.Tuition_Management_System.DTO.StudentDTO;
import com.infoobjects.Tuition_Management_System.Service.StudentService;
import com.infoobjects.Tuition_Management_System.ServiceImpl.StudentServiceImpl;
import com.infoobjects.Tuition_Management_System.Utils.Projectutils;

public class ProjectStart {

	private static Scanner sc = null;
	private static Projectutils utils = null;

	public static void main(String[] args) {

		int c, flag = 0;
		sc = new Scanner(System.in);
		utils = new Projectutils();
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("                   Tuition Management System                        \n");
		System.out.println("--------------------------------------------------------------------");
		while (true) {
			System.out.println("\n\n\nChoose your Choice:");
			System.out.println("1) Insert Student");
			System.out.println("2) Update Student");
			System.out.println("3) Delete Student");
			System.out.println("4) Find Student");
			System.out.println("5) Find All Student");
			System.out.println("6) Exit");
			c = sc.nextInt();
			switch (c) {
			case 1:
				utils.insertStudent();
				break;
			case 2:
				utils.updateStudent();
				break;
			case 3:
				utils.deleteStudent();
				break;
			case 4:
				System.out.println("Enter a Student Id : ");
				int id = sc.nextInt();
				utils.findStudent(id);
				break;
			case 5:
				utils.findAllStudent();
				break;
			case 6:
				flag = 1;
				break;
			default:
				System.out.println("------------invalid Input------------");
				break;
			}
			if (flag == 1)
				break;
		}
	}
}
