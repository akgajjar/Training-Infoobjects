package com.infoobjects.tms.controller;

import static com.infoobjects.tms.utils.TmsUtils.*;


import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infoobjects.tms.dto.DisplayAllData;
import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.service.interfaces.StudentServiceIncrement;
import com.infoobjects.tms.utils.TmsUtils;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceIncrement<Student> studentService;

	public void setStudentService(StudentServiceIncrement<Student> studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = startupMapping, method = RequestMethod.GET)
	public ModelAndView startup(ModelAndView modelAndView)  {
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = homeMapping, method = RequestMethod.GET)
	public ModelAndView home(ModelAndView modelAndView)  {
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = insertStudentMapping, method = RequestMethod.GET)
	public ModelAndView insertStudentForm(ModelAndView modelAndView) {
		modelAndView.setViewName("insertStudent");
		modelAndView.addObject("command", new Student());
		return modelAndView;
	}

	@RequestMapping(value = insertStudentMapping, method = RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute Student student, ModelAndView modelAndView) {
		student.setStudentId(TmsUtils.uuidGeneration());
		while (studentService.find(student.getStudentId()) != null) {
			student.setStudentId(TmsUtils.uuidGeneration());
		}
		studentService.insert(student);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = showAllStudentsMapping, method = RequestMethod.GET)
	public ModelAndView showAllStudents(ModelAndView modelAndView) {
		modelAndView.setViewName("showAllGenericPage");
		modelAndView.addObject("displayAllData", studentToDisplayAllData(studentService.findAll()));
		return modelAndView;
	}

	@RequestMapping(value = updateStudentFormMapping + "{studentId}", method = RequestMethod.GET)
	public ModelAndView updateStudentForm(@PathVariable("studentId") String studentId, ModelAndView modelAndView) {
		modelAndView.addObject("student", studentService.find(studentId));
		modelAndView.setViewName("updateStudent");
		modelAndView.addObject("command", new Student());
		return modelAndView;
	}

	@RequestMapping(value = updateStudentMapping, method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute Student student, ModelAndView modelAndView)  {
		studentService.update(student);
		modelAndView.setViewName("showAllStudents");
		modelAndView.addObject("students", studentService.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = deleteStudentMapping + "{studentId}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("studentId") String studentId, ModelAndView modelAndView) {
		studentService.delete(studentId);
		modelAndView.setViewName("showAllStudents");
		modelAndView.addObject("students", studentService.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = viewStudentFullDetailsMapping + "{studentId}", method = RequestMethod.GET)
	public ModelAndView showFullDetails(@PathVariable("studentId") String studentId, ModelAndView modelAndView) {
		modelAndView.addObject("student", studentService.find(studentId));
		modelAndView.setViewName("showStudentFullDetails");
		return modelAndView;
	}


	@Transactional
	@RequestMapping(value = viewTeacherNameMapping + "{studentId}", method = RequestMethod.GET)
	public ModelAndView viewTeacherName(@PathVariable("studentId") String studentId, ModelAndView modelAndView) {
		Student student = studentService.find(studentId);
		Hibernate.initialize(student.getTeachers());
		modelAndView.addObject("teachers", student.getTeachers());
		modelAndView.setViewName("showTeacherName");
		return modelAndView;
	}
	
}
