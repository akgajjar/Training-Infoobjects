package com.infoobjects.Tuition_Management_System.Start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.infoobjects.Tuition_Management_System.DTO.StudentDTO;
import com.infoobjects.Tuition_Management_System.Service.StudentService;
import com.infoobjects.Tuition_Management_System.ServiceImpl.StudentServiceImpl;
import com.infoobjects.Tuition_Management_System.Utils.Projectutils;
import com.infoobjects.Tuition_Management_System.view.ProjectMainView;

public class ProjectStart {

	private static ProjectMainView view = null;
	private static BufferedReader br = null;

	public static void main(String[] args) throws IOException {

		int c, flag = 0;
		br = new BufferedReader(new InputStreamReader(System.in));
		view = new ProjectMainView();
		String pretty="--------------------------------------------------------------------\n";
		System.out.printf("%s\t\t\tTuition Management System\t\t\t\n%s%n", pretty, pretty);
		while (true) {
			System.out.println("\n\n\nChoose your Choice:");
			System.out.println("1) Insert Student");
			System.out.println("2) Update Student");
			System.out.println("3) Delete Student");
			System.out.println("4) Find Student");
			System.out.println("5) Find All Student");
			System.out.println("6) Exit");
			c = Integer.parseInt(br.readLine());
			switch (c) {
			case 1:
				view.insertStudent();
				break;
			case 2:
				view.updateStudent();
				break;
			case 3:
				view.deleteStudent();
				break;
			case 4:
				System.out.println("Enter a Student Id : ");
				int id = Integer.parseInt(br.readLine());
				view.findStudent(id);
				break;
			case 5:
				view.findAllStudent();
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
