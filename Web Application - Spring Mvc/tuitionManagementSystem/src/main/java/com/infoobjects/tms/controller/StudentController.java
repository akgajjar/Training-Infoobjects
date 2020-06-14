package com.infoobjects.tms.controller;

import static com.infoobjects.tms.utils.TmsUtils.*;


import static com.infoobjects.tms.utils.StudentUtils.*;
import static com.infoobjects.tms.utils.ConfigurationAndGenericConstants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.service.interfaces.StudentServiceIncrement;


/**
 *@author Aniket
 *@description Controller which Controls Http Request Related to Student and StartUp
 */
@Controller
public class StudentController {

	/**
	 *  Student Service Reference to Perform Data Transformation Operation on Student Data
	 */
	@Autowired
	private StudentServiceIncrement<Student> studentService;

	/**
	 *  This Api is callled  when Application Runs first Time
	 * @param modelAndView Store view name and Attributes value
	 * @return ModelAndView
	 */
	@RequestMapping(value = startupMapping, method = RequestMethod.GET)
	public ModelAndView startup(ModelAndView modelAndView){
		modelAndView.setViewName(indexFile);
		return modelAndView;
	}

	/**
	 *  Api used to redirect to Home Page
	 * @param modelAndView Store view name and Attributes value
	 * @return ModelAndView
	 */
	@RequestMapping(value = homeMapping, method = RequestMethod.GET)
	public ModelAndView home(ModelAndView modelAndView){
		modelAndView.setViewName(indexFile);
		return modelAndView;
	}

	/**
	 *  Api used to get Insert Student Form
	 * @param modelAndView Store view name and Attributes value
	 * @return ModelAndView
	 */
	@RequestMapping(value = insertStudentMapping, method = RequestMethod.GET)
	public ModelAndView insertStudentForm(ModelAndView modelAndView) {
		modelAndView.setViewName(insertStudentFile);
		modelAndView.addObject("command", new Student());
		return modelAndView;
	}

	/**
	 *  Api used to insert Student data into Database
	 * @param student Student Data
	 * @param modelAndView Store view name and Attributes value
	 * @return ModelAndView
	 */
	@RequestMapping(value = insertStudentMapping, method = RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute Student student, ModelAndView modelAndView) {

		// Generate UUID(Unique Random String) for Student Id
		student.setStudentId(uuidGeneration());
		while (studentService.find(student.getStudentId()) != null) {
			student.setStudentId(uuidGeneration());
		}
		
		studentService.insert(student);
		modelAndView.setViewName(indexFile);
		return modelAndView;
	}

	/**
	 * Api used to get all Student's Data and redirect to Show all generic page
	 * @param modelAndView Store view name and Attributes value
	 * @return ModelAndView
 	 */
	@RequestMapping(value = showAllStudentsMapping, method = RequestMethod.GET)
	public ModelAndView showAllStudents(ModelAndView modelAndView) {
		modelAndView.setViewName(showAllGenericPageFile);
		modelAndView.addObject("displayAllData", studentToDisplayAllData(studentService.findAll()));
		return modelAndView;
	}

	/**
	 *  Api used to redirect Update Student form with Student Data of Specific Student Id
	 * @param studentId Student's Id
	 * @param modelAndView Store view name and Attributes value
	 * @return ModelAndView
	 */
	@RequestMapping(value =  updateStudentFormMapping + "{studentId}", method = RequestMethod.GET)
	public ModelAndView updateStudentForm(@PathVariable("studentId") String studentId, ModelAndView modelAndView) {
		modelAndView.addObject("student", studentService.find(studentId));
		modelAndView.setViewName(updateStudentFile);
		modelAndView.addObject("command", new Student());
		return modelAndView;
	}

	/**
	 *  Api used to Update Student into Database
	 * @param student Student Data
	 * @param modelAndView Store view name and Attributes value
	 * @return ModelAndView
	 */
	@RequestMapping(value = updateStudentMapping, method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute Student student, ModelAndView modelAndView) {
		studentService.update(student);
		modelAndView.setViewName(showAllGenericPageFile);
		modelAndView.addObject("displayAllData", studentToDisplayAllData(studentService.findAll()));
		return modelAndView;
	}

	/**
	 *  Api used to Delete Student for specific Student Id
	 * @param studentId Student's Id
	 * @param modelAndView Store view name and Attributes value
	 * @return ModelAndView
	 */
	@RequestMapping(value = deleteStudentMapping + "{studentId}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("studentId") String studentId, ModelAndView modelAndView){
		studentService.delete(studentId);
		modelAndView.setViewName(showAllGenericPageFile);
		modelAndView.addObject("displayAllData", studentToDisplayAllData(studentService.findAll()));
		return modelAndView;
	}

	/**
	 *  Api used to Show full details for Specific Student Id
	 * @param studentId Student's Id
	 * @param modelAndView Store view name and Attributes value
	 * @return ModelAndView
	 */
	@RequestMapping(value = viewStudentFullDetailsMapping + "{studentId}", method = RequestMethod.GET)
	public ModelAndView showFullDetails(@PathVariable("studentId") String studentId, ModelAndView modelAndView){
		modelAndView.addObject("student", studentService.find(studentId));
		modelAndView.setViewName(showStudentFullDetailsFile);
		return modelAndView;
	}


	/**
	 *  Api used to view all Teacher's Name for Specific Teacher Id
	 * @param studentId Student's Id
	 * @param modelAndView Store view name and Attributes value
	 * @return ModelAndView
	 */
	@RequestMapping(value = viewTeacherNameMapping + "{studentId}", method = RequestMethod.GET)
	public ModelAndView viewTeacherName(@PathVariable("studentId") String studentId, ModelAndView modelAndView) {
		modelAndView.addObject("teachers", studentService.getTeacherName(studentId));
		modelAndView.setViewName(showTeacherNameFile);
		return modelAndView;
	}
	
}
