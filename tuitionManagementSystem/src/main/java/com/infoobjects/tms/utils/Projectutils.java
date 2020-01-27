package com.infoobjects.tms.utils;

import com.infoobjects.tms.enums.Gender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Projectutils {

	public static String emailRegex = "[a-zA_Z0-9]+[@]{1}[a-zA_Z0-9]+[.]{1}[a-zA_Z0-9]{2,3}";
	public static String mobileRegex = "(0/91)?[7-9][0-9]{9}";
	public static String digitRegex = "\\d";
	public static String stringRegex = "[a-zA-Z]+";
	public static String exclamationMark = "!!!!!!!!!!";
	public static String scanningErrorMsg = "\nInvalid %s " + exclamationMark + "\n\n";
	public static String findErrorMsg = "\nNo Student Found " + exclamationMark + "\n\n";
	public static String nullErrorMsg = "\nNull Value Found Please Enter Correct Value" + exclamationMark + "\n\n";
	public static String duplicatePrimaryKeyErrorMsg = "\nDuplicate Value for Primary Key" + exclamationMark + "\n\n";
	public static String selectErrorMsg = "\nEnter Single Digit as Input " + exclamationMark + "\n\n";
	public static String integerOnlyErrorMsg = "\nplease Enter integer Value only" + exclamationMark +"\n\n";
	public static String stringOnlyErrorMsg = "\nplease Enter Chanracter only" + exclamationMark +"\n\n";

	public  static boolean patternMatch(String pattern, String value) {
		Pattern patternRef = Pattern.compile(pattern);
		return patternRef.matcher(value).matches();
	}

	public static String scan(String msg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String returnValue = null;
		while (true){
			System.out.println("\nEnter " + msg + " : ");
			returnValue = br.readLine();
			if(returnValue == null) {
				System.out.println(nullErrorMsg);
				continue;
			}
			else
			{
				return returnValue;
			}
		}
	}

	public static String scanString(String msg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String returnValue = null;
		while (true){
			System.out.println("\nEnter " + msg + " : ");
			returnValue = br.readLine();
			if(returnValue == null) {
				System.out.println(nullErrorMsg);
				continue;
			}
			else if(!patternMatch(stringRegex, returnValue))
			{
				System.out.println(stringOnlyErrorMsg);
				continue;
			}
			else
			{
				return returnValue;
			}
		}
	}

	public static int scanInteger(String msg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String returnValue = null;
		while (true){
			System.out.println("\nEnter " + msg + " : ");
			returnValue = br.readLine();
			if(returnValue == null) {
				System.out.println(nullErrorMsg);
				continue;
			}
			else if(!patternMatch(digitRegex + "+" , returnValue))
			{
				System.out.println(integerOnlyErrorMsg);
				continue;
			}
			else{
				break;
			}
		}
		return Integer.parseInt(returnValue);
	}

	public  static String scan(String msg, String regex) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String returnValue = null;
		while (true) {
			System.out.println("\nEnter " + msg + " : ");
			returnValue = br.readLine();
			if(returnValue == null) {
				System.out.println(nullErrorMsg);
				continue;
			}
			else if (patternMatch(regex, returnValue))
				break;
			else {
				System.out.printf(scanningErrorMsg,msg);
			}
		}
		return returnValue;
	}


	public static Gender scanGender() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Gender gender = null;
		int loopBreak = 0;
		String inputValue = null;
		while (true) {
			System.out.println("\nSelect Student Gender : \n1. Male\n2. Female\n");
			inputValue = br.readLine();
			if(inputValue == null) {
				System.out.println(nullErrorMsg);
				continue;
			}
			else if(patternMatch(digitRegex, inputValue))
			{
				int choice = Integer.parseInt(inputValue);
				switch (choice) {
					case 1:
						gender = Gender.MALE;
						loopBreak = 1;
						break;
					case 2:
						gender = Gender.FEMALE;
						loopBreak = 1;
						break;
					default:
						System.out.printf(scanningErrorMsg,"Gender");
				}
			}
			else {
				System.out.println(selectErrorMsg);
			}
			if(loopBreak == 1)
				break;
		 }
		return gender;
	}

}
