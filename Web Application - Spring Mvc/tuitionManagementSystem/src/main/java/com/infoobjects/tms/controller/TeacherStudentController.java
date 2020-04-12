package com.infoobjects.tms.controller;

import com.infoobjects.tms.service.interfaces.TeacherStudentServiceIncrement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.service.TeacherStudentServiceImpl;
import static com.infoobjects.tms.utils.TmsUtils.*;

/**
 * @author Aniket
 * @description Controller which Controls Http Request Related to TeacherStudent Mapping
 */
@Controller
public class TeacherStudentController {

	/**
	 *  TeacherStudent Service Reference to Perform Transformation Operation on TeacherStudent Mapping Data
	 */
	@Autowired
	private TeacherStudentServiceIncrement<TeacherStudent> teacherStudentService;

	/**
	 * setters
	 */
	public void setTeacherStudentService(TeacherStudentServiceIncrement<TeacherStudent> teacherStudentService) {
		this.teacherStudentService = teacherStudentService;
	}

	/**
	 *  Api used to get Insert TeacherStudent Mapping form
	 * @param modelAndView Store view name and Attributes value
	 * @return modelAndView
	 */
	@RequestMapping(value = insertTeacherStudentMapping, method = RequestMethod.GET)
	public ModelAndView insertTeacherStudentForm(ModelAndView modelAndView) {
		modelAndView.addObject("students",teacherStudentService.getStudentsForMapping());
		modelAndView.addObject("teacherStudent", new TeacherStudent());
		modelAndView.setViewName("insertTeacherStudentMapping");
		return modelAndView;
	}

	/**
	 *  Api used to insert TeacherStudent Data into Database
	 * @param teacherStudent TeacherStudent Data
	 * @param modelAndView Store view name and Attributes value
	 * @return modelAndView
	 */
	@RequestMapping(value = insertTeacherStudentMapping, method = RequestMethod.POST)
	public ModelAndView insertTeacherStudent(@ModelAttribute TeacherStudent teacherStudent, ModelAndView modelAndView)  {
		teacherStudentService.insert(teacherStudent);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	/**
	 *  Api used to get Students By Teacher Id form
	 * @param modelAndView Store view name and Attributes value
	 * @return modelAndView
	 */
	@RequestMapping(value = getStudentByTeacherIdFormMapping, method = RequestMethod.GET)
	public ModelAndView getStudentsByTeacherIdForm( ModelAndView modelAndView)  {
		modelAndView.addObject("teachers",teacherStudentService.getAllTeachers());
		modelAndView.setViewName("showStudentsByTeacherIdForm");
		return modelAndView;
	}

	/**
	 *  Api used to get Students for Specific Teacher Id
	 * @param teacherId Teacher's Id
	 * @param modelAndView Store view name and Attributes value
	 * @return modelAndView
	 */
	@RequestMapping(value = getStudentByTeacherIdMapping, method = RequestMethod.GET)
	public ModelAndView getStudentsByTeacherId(@RequestParam("teacherId") String teacherId, ModelAndView modelAndView)  {
		modelAndView.addObject("students",teacherStudentService.getStudentsByTeacherId(teacherId));
		modelAndView.setViewName("showStudentsByTeacherId");
		return modelAndView;
	}

	/**
	 *  Api used to get all TeacherStudent Mapping data
	 * @param modelAndView Store view name and Attributes value
	 * @return modelAndView
	 */
	@RequestMapping(value = showAllTeacherStudentMapping, method = RequestMethod.GET)
	public ModelAndView showAllTeacherStudents(ModelAndView modelAndView)  {
		modelAndView.addObject("displayAllData", teacherStudentToDisplayAllData(teacherStudentService.findAll()));
		modelAndView.setViewName("showAllGenericPage");
		return modelAndView;
	}

	/**
	 *  Api used to Delete TeacherStudent Mapping from Database
	 * @param studentId Student's Id
	 * @param teacherId Teacher's Id
	 * @param modelAndView Store view name and Attributes value
	 * @return modelAndView
	 */
	@RequestMapping(value = deleteTeacherStudentMapping + "{studentId}/{teacherId}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("studentId") String studentId,@PathVariable("teacherId") String teacherId, ModelAndView modelAndView) {
		teacherStudentService.delete(teacherId, studentId);
		modelAndView.addObject("displayAllData", teacherStudentToDisplayAllData(teacherStudentService.findAll()));
		modelAndView.setViewName("showAllGenericPage");
		return modelAndView;
	}
	
}
