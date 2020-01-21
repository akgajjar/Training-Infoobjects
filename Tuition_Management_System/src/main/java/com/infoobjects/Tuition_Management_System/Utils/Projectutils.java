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
	private static BufferedReader br = null;
	public static String emailRejex = "[a-zA_Z0-9]+[@]{1}[a-zA_Z0-9]+[.]{1}[a-zA_Z0-9]{2,3}";
	public static String mobileRejex = "[789]{1}[0-9]{9}";
	public static String scanningErrorMsg = "\ninvalid Input !!!!!!!!!\n\n";
	public Projectutils() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public static boolean patternMatch(String pattern, String value) {
		return Pattern.matches(pattern, value);
	}

	public static String scan(String msg) throws IOException {
		System.out.println("\nEnter " + msg + " : ");
		return br.readLine();
	}
 
	public static String scan(String msg,String rejex) throws IOException {
		String returnValue = null;
		while (true) {
			System.out.println("\nEnter " + msg + " : ");
			returnValue = br.readLine();
			if (patternMatch(rejex, msg))
				break;
			else {
				System.out.println(scanningErrorMsg);
			}
		}
		return returnValue;
	}

	public static String scanGender() throws NumberFormatException, IOException {
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
}
