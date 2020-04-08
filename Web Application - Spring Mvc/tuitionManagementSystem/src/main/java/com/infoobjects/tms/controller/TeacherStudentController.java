package com.infoobjects.tms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.service.TeacherServiceImpl;
import com.infoobjects.tms.service.TeacherStudentServiceImpl;

@Controller
public class TeacherStudentController {

	@Autowired
	private TeacherStudentServiceImpl teacherStudentService;
	
	
	
	public void setTeacherStudentService(TeacherStudentServiceImpl teacherStudentService) {
		this.teacherStudentService = teacherStudentService;
	}



	@RequestMapping(value = "/insertTeacherStudent", method = RequestMethod.GET)
	public ModelAndView insertTeacherStudentForm(ModelAndView modelAndView) {
		modelAndView.addObject("students",teacherStudentService.getStudentsForMapping());
		modelAndView.addObject("teacherStudent", new TeacherStudent());
		modelAndView.setViewName("insertTeacherStudentMapping");
		return modelAndView;
	}
	
	@RequestMapping(value = "/insertTeacherStudent", method = RequestMethod.POST)
	public ModelAndView insertTeacherStudent(@ModelAttribute TeacherStudent teacherStudent, ModelAndView modelAndView)  {
		teacherStudentService.insert(teacherStudent);
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value = "/getStudentsByTeacherIdForm", method = RequestMethod.GET)
	public ModelAndView getStudentsByTeacherIdForm( ModelAndView modelAndView)  {
		modelAndView.addObject("teachers",teacherStudentService.getAllTeachers());
		modelAndView.setViewName("showStudentsByTeacherIdForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/getStudentsByTeacherId", method = RequestMethod.GET)
	public ModelAndView getStudentsByTeacherId(@RequestParam("teacherId") String teacherId, ModelAndView modelAndView)  {
		modelAndView.addObject("students",teacherStudentService.getStudentsByTeacherId(teacherId));
		modelAndView.setViewName("showStudentsByTeacherId");
		return modelAndView;
	}
	
	@RequestMapping(value = "/getAllTeacherStudents", method = RequestMethod.GET)
	public ModelAndView getAllTeacherStudents(ModelAndView modelAndView)  {
		modelAndView.addObject("teacherStudents",teacherStudentService.findAll());
		modelAndView.setViewName("showAllTeacherStudents");
		return modelAndView;
	}
	
	@RequestMapping(value = "/teacherStudent/delete/{studentId}/{teacherId}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("studentId") String studentId,@PathVariable("teacherId") String teacherId, ModelAndView modelAndView) {
		teacherStudentService.delete(teacherId, studentId);
		modelAndView.addObject("teacherStudents",teacherStudentService.findAll());
		modelAndView.setViewName("showAllTeacherStudents");
		
		return modelAndView;
	}
	
}
