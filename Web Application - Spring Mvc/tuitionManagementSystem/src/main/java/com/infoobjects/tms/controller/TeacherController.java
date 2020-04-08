package com.infoobjects.tms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import static com.infoobjects.tms.utils.TmsUtils.*;

@Controller
public class TeacherController {

	@Autowired
	private TeacherServiceIncrement<Teacher> teacherService;

	public void setTeacherService(TeacherServiceIncrement<Teacher> teacherService) {
		this.teacherService = teacherService;
	}

	@RequestMapping(value = "/insertTeacher", method = RequestMethod.GET)
	public ModelAndView insertTeacher(ModelAndView modelAndView){
		modelAndView.setViewName("insertTeacher");
		modelAndView.addObject("command", new Teacher());
		return modelAndView;
	}

	@RequestMapping(value = "/insertTeacher", method = RequestMethod.POST)
	public ModelAndView insertTeacher(@ModelAttribute Teacher teacher, ModelAndView modelAndView){
		teacher.setTeacherId(uuidGeneration());
		while (teacherService.find(teacher.getTeacherId()) != null) {
			teacher.setTeacherId(uuidGeneration());
		}
		teacher.setStudents(new ArrayList<Student>());
		teacherService.insert(teacher);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = "/showAllTeachers", method = RequestMethod.GET)
	public ModelAndView showAllTeachers(ModelAndView modelAndView){
		modelAndView.setViewName("showAllTeachers");
		modelAndView.addObject("teachers", teacherService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/updateTeacherForm/{teacherId}", method = RequestMethod.POST)
	public ModelAndView updateTeacherForm(@PathVariable("teacherId") String teacherId, ModelAndView modelAndView) {
		modelAndView.addObject("teacher", teacherService.find(teacherId));
		modelAndView.setViewName("updateTeacher");
		modelAndView.addObject("command", new Teacher());
		return modelAndView;
	}

	@RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
	public ModelAndView updateteacher(@ModelAttribute Teacher teacher, ModelAndView modelAndView){
		teacherService.update(teacher);
		modelAndView.setViewName("showAllTeachers");
		modelAndView.addObject("teachers", teacherService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/teacher/delete/{teacherId}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("teacherId") String teacherId, ModelAndView modelAndView) {
		teacherService.delete(teacherId);
		modelAndView.setViewName("showAllTeachers");
		modelAndView.addObject("teachers", teacherService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/teacher/viewFullDetails/{teacherId}", method = RequestMethod.GET)
	public ModelAndView showFullDetails(@PathVariable("teacherId") String teacherId, ModelAndView modelAndView) {
		modelAndView.addObject("teacher", teacherService.find(teacherId));
		modelAndView.setViewName("showTeacherFullDetails");
		return modelAndView;
	}

}
