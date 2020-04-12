package com.infoobjects.tms.utils;

import com.fasterxml.uuid.Generators;
import com.infoobjects.tms.dto.Data;
import com.infoobjects.tms.dto.DisplayAllData;
import com.infoobjects.tms.dto.SubmitButton;
import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.entity.Teacher;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aniket
 * @description Utility Class used contains of Utility methods and constants common between all classes
 */
public class TmsUtils {

	// Form Method Constants
    private final static String getMethod = "get";
    private final static String postMethod = "post";
    
    // Show All Data Heading
    private final static String showAllStudentsHeading = "Show All Students";
    private final static String showAllTeachersHeading = "Show All Teachers";
    private final static String showAllTeacherStudentsHeading = "Show All Teacher Students";
    // Headers Constants
    private final static String viewFullDetailsText = "View Full Details";
    private final static String viewTeacherNameText = "View Teacher Name";
    private final static String updateHeaderText = "Update";
    private final static String deleteHeaderText = "Delete";
    private final static String studentIdHeaderText = "Student Id";
    private final static String studentNameHeaderText = "Student Name";
    private final static String classHeaderText = "Class";
    private final static String teacherIdHeaderText = "Teacher Id";
    private final static String teacherNameHeaderText = "Teacher Name";
    private final static String designationHeaderText = "Designation";

	/**
	 * Mapping Records
	 */
	// Common mapping
    public final static String startupMapping = "/";
    public final static String homeMapping = "/home";
    
    // Student Mapping Constants
    public final static String insertStudentMapping = "/insertStudent";
    public final static String updateStudentMapping = "/updateStudent";
    public final static String deleteStudentMapping = "/student/delete/";
    public final static String showAllStudentsMapping = "/showAllStudents";  
    public final static String viewStudentFullDetailsMapping = "/student/viewFullDetails/";
    public final static String updateStudentFormMapping = "/student/updateStudentForm/";
    public final static String viewTeacherNameMapping = "/student/viewTeacherName/";
    
    // teacher Mapping
    public final static String insertTeacherMapping = "/insertTeacher";
    public final static String updateTeacherMapping = "/updateTeacher";
    public final static String deleteTeacherMapping = "/teacher/delete/";
    public final static String showAllTeachersMapping = "/showAllTeachers";  
    public final static String viewTeacherFullDetailsMapping = "/teacher/viewFullDetails/";
    public final static String updateTeacherFormMapping = "/teacher/updateTeacherForm/";
  
    
    // Teacher Student Mapping
    public final static String insertTeacherStudentMapping = "/insertTeacherStudent";
    public final static String showAllTeacherStudentMapping = "/showAllTeacherStudents";  
    public final static String getStudentByTeacherIdFormMapping = "/getStudentsByTeacherIdForm";
    public final static String getStudentByTeacherIdMapping = "/getStudentsByTeacherId";
    public final static String deleteTeacherStudentMapping = "/teacherStudent/delete/";

	/**
	 * Generic ToString Method Which Dynamically Prints all variable's value of Dto class
	 * @param reference DTO reference
	 * @return String
	 */
	public static String genericToString(DTO reference) {
        StringBuilder returnValue = new StringBuilder();
        Class classReference = reference.getClass();
        Field[] fields = classReference.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                returnValue.append(field.getName());
                returnValue.append(" : ");
                returnValue.append(field.get(reference));
                returnValue.append("\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnValue.toString();
    }

	/**
	 * used to generate random uuid String
	 * @return String
	 */
	public static String uuidGeneration() {
        return Generators.randomBasedGenerator().generate().toString();
    }


	/**
	 * used to create Submit Button Instance
	 * @param formAction Form's Action value
	 * @param formMethod Form's method type
	 * @param buttonValue Button's value
	 * @return SubmitButton
	 */
    public static SubmitButton createSubmitButton(String formAction, String formMethod, String buttonValue) {
    	return new SubmitButton(formAction, formMethod, buttonValue);
    }

	/**
	 * used to convert List of Student Data into DisplayALlData which are used for render using generic show all page
	 * @param students List of Students
	 * @return DisplayAllData
	 */
	public static DisplayAllData studentToDisplayAllData(List<Student> students) {
    	DisplayAllData displayAllData = new DisplayAllData();
    	
    	List<String> dataHeaders = new ArrayList<String>();
    	dataHeaders.add(studentIdHeaderText);
    	dataHeaders.add(studentNameHeaderText);
    	dataHeaders.add(classHeaderText);
    	
    	List<String> buttonsHeaders = new ArrayList<String>();
    	buttonsHeaders.add(viewFullDetailsText);
    	buttonsHeaders.add(viewTeacherNameText);
    	buttonsHeaders.add(updateHeaderText);
    	buttonsHeaders.add(deleteHeaderText);
    	
    	List<Data> dataToDisplay = new ArrayList<Data>();
    	
    	for(Student student : students) {
    	
    	Data dataOfStudent = new Data();
    		
    	Map<String,SubmitButton> submitButtons = new HashMap<String,SubmitButton>();
    	submitButtons.put(viewFullDetailsText, createSubmitButton(viewStudentFullDetailsMapping + student.getStudentId(), getMethod, viewFullDetailsText));
    	submitButtons.put(viewTeacherNameText, createSubmitButton(viewTeacherNameMapping + student.getStudentId(), getMethod, viewTeacherNameText));
    	submitButtons.put(updateHeaderText, createSubmitButton(updateStudentFormMapping + student.getStudentId(), getMethod, updateHeaderText));
    	submitButtons.put(deleteHeaderText, createSubmitButton(deleteStudentMapping + student.getStudentId(), postMethod, deleteHeaderText));
    	
    	Map<String,String> data = new HashMap<String,String>();
    	data.put(studentIdHeaderText, student.getStudentId());
    	data.put(studentNameHeaderText, student.getStudentName());
    	data.put(classHeaderText, String.valueOf(student.getStudentClass()));
    	
    	dataOfStudent.setData(data);
    	dataOfStudent.setSubmitButtons(submitButtons);
    	System.out.println(dataOfStudent.getData());
    	
    	dataToDisplay.add(dataOfStudent);
    	}
    	
    	displayAllData.setDataHeaders(dataHeaders);
    	displayAllData.setButtonsHeaders(buttonsHeaders);
    	displayAllData.setDataToDisplay(dataToDisplay);
    	displayAllData.setDisplayAllDataHeading(showAllStudentsHeading);
    	
    	return displayAllData;
    }

	/**
	 * used to convert List of Teacher Data into DisplayALlData which are used for render using generic show all page
	 * @param teachers List of Teachers
	 * @return DisplayAllData
	 */
    public static DisplayAllData teacherToDisplayAllData(List<Teacher> teachers) {
    	DisplayAllData displayAllData = new DisplayAllData();
    	
    	List<String> dataHeaders = new ArrayList<String>();
    	dataHeaders.add(teacherIdHeaderText);
    	dataHeaders.add(teacherNameHeaderText);
    	dataHeaders.add(designationHeaderText);
    	
    	List<String> buttonsHeaders = new ArrayList<String>();
    	buttonsHeaders.add(viewFullDetailsText);
    	buttonsHeaders.add(updateHeaderText);
    	buttonsHeaders.add(deleteHeaderText);
    	
    	List<Data> dataToDisplay = new ArrayList<Data>();
    	
    	for(Teacher teacher : teachers) {
    	
    	Data dataOfTeacher = new Data();
    		
    	Map<String,SubmitButton> submitButtons = new HashMap<String,SubmitButton>();
    	
    	submitButtons.put(viewFullDetailsText, createSubmitButton(viewTeacherFullDetailsMapping + teacher.getTeacherId(), getMethod, viewFullDetailsText));
    	submitButtons.put(updateHeaderText, createSubmitButton(updateTeacherFormMapping + teacher.getTeacherId(), getMethod, updateHeaderText));
    	submitButtons.put(deleteHeaderText, createSubmitButton(deleteTeacherMapping + teacher.getTeacherId(), postMethod, deleteHeaderText));
    	
    	Map<String,String> data = new HashMap<String,String>();
    	data.put(teacherIdHeaderText, teacher.getTeacherId());
    	data.put(teacherNameHeaderText, teacher.getTeacherName());
    	data.put(designationHeaderText, teacher.getTeacherDesignation().toString());
    	
    	dataOfTeacher.setData(data);
    	dataOfTeacher.setSubmitButtons(submitButtons);
    	
    	dataToDisplay.add(dataOfTeacher);
    	}
    	
    	displayAllData.setDataHeaders(dataHeaders);
    	displayAllData.setButtonsHeaders(buttonsHeaders);
    	displayAllData.setDataToDisplay(dataToDisplay);
    	displayAllData.setDisplayAllDataHeading(showAllTeachersHeading);
    	return displayAllData;
    }

	/**
	 * used to convert List of TeacherStudent Mapping Data into DisplayALlData which are used for render using generic show all page
	 * @param teacherStudents List of TeacherStudents
	 * @return teacherStudents
	 */
    public static DisplayAllData teacherStudentToDisplayAllData(List<TeacherStudent> teacherStudents) {
    	
    	DisplayAllData displayAllData = new DisplayAllData();
    	
    	List<String> dataHeaders = new ArrayList<String>();
    	dataHeaders.add(studentIdHeaderText);
    	dataHeaders.add(studentNameHeaderText);
    	dataHeaders.add(teacherIdHeaderText);
    	dataHeaders.add(teacherNameHeaderText);
    	
    	List<String> buttonsHeaders = new ArrayList<String>();
    	buttonsHeaders.add(deleteHeaderText);
    	
    	List<Data> dataToDisplay = new ArrayList<Data>();
    	
    	for(TeacherStudent teacherStudent : teacherStudents) {
    	
    	Data dataOfTeacher = new Data();
    		
    	Map<String,SubmitButton> submitButtons = new HashMap<String,SubmitButton>();
    	
    	submitButtons.put(deleteHeaderText, createSubmitButton(deleteTeacherStudentMapping + teacherStudent.getStudentId() + "/" + teacherStudent.getTeacherId(), postMethod, deleteHeaderText));
    	
    	Map<String,String> data = new HashMap<String,String>();
    	data.put(studentIdHeaderText, teacherStudent.getStudentId());
    	data.put(studentNameHeaderText, teacherStudent.getStudentName());
    	data.put(teacherIdHeaderText, teacherStudent.getTeacherId());
    	data.put(teacherNameHeaderText, teacherStudent.getTeacherName());
    	
    	dataOfTeacher.setData(data);
    	dataOfTeacher.setSubmitButtons(submitButtons);
    	
    	dataToDisplay.add(dataOfTeacher);
    	}
    	
    	displayAllData.setDataHeaders(dataHeaders);
    	displayAllData.setButtonsHeaders(buttonsHeaders);
    	displayAllData.setDataToDisplay(dataToDisplay);
    	displayAllData.setDisplayAllDataHeading(showAllTeacherStudentsHeading);
    	
    	return displayAllData;
    }
    
}
