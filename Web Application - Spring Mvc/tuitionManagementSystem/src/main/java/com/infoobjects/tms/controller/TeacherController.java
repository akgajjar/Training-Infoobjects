package com.infoobjects.tms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.infoobjects.tms.entity.Teacher;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import static com.infoobjects.tms.utils.TmsUtils.*;

/**
 * @author Aniket
 * @description Controller which Controls Http Request Related to Teacher
 */
@Controller
public class TeacherController {

    /**
     *  Teacher Service Reference to Perform Transformation Operation on Teacher Data
     */
    @Autowired
    private TeacherServiceIncrement<Teacher> teacherService;

    /**
     * setters
     */
    public void setTeacherService(TeacherServiceIncrement<Teacher> teacherService) {
        this.teacherService = teacherService;
    }

    /**
     *  Api used to get Insert Student form
     * @param modelAndView Store view name and Attributes value
     * @return modelAndView
     */
    @RequestMapping(value = insertTeacherMapping, method = RequestMethod.GET)
    public ModelAndView insertTeacher(ModelAndView modelAndView) {
        modelAndView.setViewName("insertTeacher");
        modelAndView.addObject("command", new Teacher());
        return modelAndView;
    }

    /**
     *  Api used to get Insert Teacher data into database
     * @param teacher Teacher's Data
     * @param modelAndView Store view name and Attributes value
     * @return modelAndView
     */
    @RequestMapping(value = insertTeacherMapping, method = RequestMethod.POST)
    public ModelAndView insertTeacher(@ModelAttribute Teacher teacher, ModelAndView modelAndView) {

        // Generate UUID(Unique Random String) for Student Id
        teacher.setTeacherId(uuidGeneration());
        while (teacherService.find(teacher.getTeacherId()) != null) {
            teacher.setTeacherId(uuidGeneration());
        }

        teacherService.insert(teacher);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     *  Api used to get all Teacher's Data and redirect to Show all generic page
     * @param modelAndView Store view name and Attributes value
     * @return modelAndView
     */
    @RequestMapping(value = showAllTeachersMapping, method = RequestMethod.GET)
    public ModelAndView showAllTeachers(ModelAndView modelAndView) {
        modelAndView.setViewName("showAllGenericPage");
        modelAndView.addObject("displayAllData", teacherToDisplayAllData(teacherService.findAll()));
        return modelAndView;
    }

    /**
     *  Api used to redirect Update Teacher form with Teacher Data of Specific Teacher Id
     * @param teacherId Teacher's Id
     * @param modelAndView Store view name and Attributes value
     * @return modelAndView
     */
    @RequestMapping(value = updateTeacherFormMapping + "{teacherId}", method = RequestMethod.GET)
    public ModelAndView updateTeacherForm(@PathVariable("teacherId") String teacherId, ModelAndView modelAndView) {
        modelAndView.addObject("teacher", teacherService.find(teacherId));
        modelAndView.setViewName("updateTeacher");
        modelAndView.addObject("command", new Teacher());
        return modelAndView;
    }

    /**
     *  Api used to Update Teacher into Database
     * @param teacher Teacher's Data
     * @param modelAndView Store view name and Attributes value
     * @return modelAndView
     */
    @RequestMapping(value = updateTeacherMapping, method = RequestMethod.POST)
    public ModelAndView updateTeacher(@ModelAttribute Teacher teacher, ModelAndView modelAndView) {
        teacherService.update(teacher);
        modelAndView.setViewName("showAllGenericPage");
        modelAndView.addObject("displayAllData", teacherToDisplayAllData(teacherService.findAll()));
        return modelAndView;
    }

    /**
     *  Api used to Delete Teacher for Specific Teacher Id
     * @param teacherId Teacher's Id
     * @param modelAndView Store view name and Attributes value
     * @return modelAndView
     */
    @RequestMapping(value = deleteTeacherMapping + "{teacherId}", method = RequestMethod.POST)
    public ModelAndView delete(@PathVariable("teacherId") String teacherId, ModelAndView modelAndView) {
        teacherService.delete(teacherId);
        modelAndView.setViewName("showAllGenericPage");
        modelAndView.addObject("displayAllData", teacherToDisplayAllData(teacherService.findAll()));
        return modelAndView;
    }

    /**
     *  Api used to Show full details for Specific Teacher Id
     * @param teacherId Teacher's Id
     * @param modelAndView Store view name and Attributes value
     * @return modelAndView
     */
    @RequestMapping(value = viewTeacherFullDetailsMapping + "{teacherId}", method = RequestMethod.GET)
    public ModelAndView showFullDetails(@PathVariable("teacherId") String teacherId, ModelAndView modelAndView) {
        modelAndView.addObject("teacher", teacherService.find(teacherId));
        modelAndView.setViewName("showTeacherFullDetails");
        return modelAndView;
    }

}
