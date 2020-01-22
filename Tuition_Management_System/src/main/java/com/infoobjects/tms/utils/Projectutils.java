package com.infoobjects.tuitionManagementSystem.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Projectutils {

	private static BufferedReader br = null;
	public static String emailRejex = "[a-zA_Z0-9]+[@]{1}[a-zA_Z0-9]+[.]{1}[a-zA_Z0-9]{2,3}";
	public static String mobileRejex = "[789]{1}[0-9]{9}";
	public static String scanningErrorMsg = "\nInvalid Input !!!!!!!!!\n\n";
	public static String findErrorMsg = "\nNot Found !!!!!!!!!\n\n";

	public Projectutils() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public  boolean patternMatch(String pattern, String value) {
		return Pattern.matches(pattern, value);
	}

	public  String scan(String msg) throws IOException {
		System.out.println("\nEnter " + msg + " : ");
		if(br == null)
			System.out.println("Null");
		return br.readLine();
	}
 
	public  String scan(String msg, String rejex) throws IOException {
		String returnValue = null;
		while (true) {
			System.out.println("\nEnter " + msg + " : ");
			returnValue = br.readLine();
			if (patternMatch(rejex, returnValue))
				break;
			else {
				System.out.println(scanningErrorMsg);
			}
		}
		return returnValue;
	}

	public  String scanGender() throws NumberFormatException, IOException {
		String gender = "";
		while (true) {
			System.out.println("\nSelect Student Gender : \n1. Male\n2. Female\n");
			int c1 = Integer.parseInt(br.readLine());
			if (c1 == 1) {
				gender = "Male";
				break;
			} else if (c1 == 2) {
				gender = "Female";
				break;
			} else {
				System.out.println(scanningErrorMsg);
			}
		}
		return gender;
	}
}
