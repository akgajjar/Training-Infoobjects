package com.infoobjects.tms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.entity.Teacher;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import static com.infoobjects.tms.utils.TmsUtils.*;

@Controller
public class TeacherController {

	@Autowired
	private TeacherServiceIncrement<Teacher> teacherService;

	public void setTeacherService(TeacherServiceIncrement<Teacher> teacherService) {
		this.teacherService = teacherService;
	}

	@RequestMapping(value = insertTeacherMapping, method = RequestMethod.GET)
	public ModelAndView insertTeacher(ModelAndView modelAndView){
		modelAndView.setViewName("insertTeacher");
		modelAndView.addObject("command", new Teacher());
		return modelAndView;
	}

	@RequestMapping(value = insertTeacherMapping, method = RequestMethod.POST)
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

	@RequestMapping(value = showAllTeachersMapping, method = RequestMethod.GET)
	public ModelAndView showAllTeachers(ModelAndView modelAndView){
		modelAndView.setViewName("showAllGenericPage");
		modelAndView.addObject("displayAllData", teacherToDisplayAllData(teacherService.findAll()));
		return modelAndView;
	}

	@RequestMapping(value = updateTeacherFormMapping + "{teacherId}", method = RequestMethod.GET)
	public ModelAndView updateTeacherForm(@PathVariable("teacherId") String teacherId, ModelAndView modelAndView) {
		modelAndView.addObject("teacher", teacherService.find(teacherId));
		modelAndView.setViewName("updateTeacher");
		modelAndView.addObject("command", new Teacher());
		return modelAndView;
	}

	@RequestMapping(value = updateTeacherMapping, method = RequestMethod.POST)
	public ModelAndView updateteacher(@ModelAttribute Teacher teacher, ModelAndView modelAndView){
		teacherService.update(teacher);
		modelAndView.setViewName("showAllTeachers");
		modelAndView.addObject("teachers", teacherService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = deleteTeacherMapping + "{teacherId}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("teacherId") String teacherId, ModelAndView modelAndView) {
		teacherService.delete(teacherId);
		modelAndView.setViewName("showAllTeachers");
		modelAndView.addObject("teachers", teacherService.findAll());
		return modelAndView;
	}

	@RequestMapping(value = viewTeacherFullDetailsMapping + "{teacherId}", method = RequestMethod.GET)
	public ModelAndView showFullDetails(@PathVariable("teacherId") String teacherId, ModelAndView modelAndView) {
		modelAndView.addObject("teacher", teacherService.find(teacherId));
		modelAndView.setViewName("showTeacherFullDetails");
		return modelAndView;
	}

}
