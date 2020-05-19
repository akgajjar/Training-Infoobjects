package com.infoobjects.tms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infoobjects.tms.dto.DisplayAllData;
import com.infoobjects.tms.entity.HttpResponse;
import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.entity.Teacher;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import static com.infoobjects.tms.utils.TmsUtils.*;
import static com.infoobjects.tms.utils.ConfigurationAndGenericConstants.*;
import static com.infoobjects.tms.utils.StudentUtils.getStudentByStudentIdMapping;
import static com.infoobjects.tms.utils.StudentUtils.studentToDisplayAllData;
import static com.infoobjects.tms.utils.TeacherUtils.*;

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
     *  Api used to get Insert Teacher data into database
     * @param teacher Teacher's Data
     * @return ResponseEntity<HttpResponse>
     */
    @PostMapping(value = insertTeacherMapping, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponse> insertTeacher(@ModelAttribute Teacher teacher) {
    	
        // Generate UUID(Unique Random String) for Student Id
        teacher.setTeacherId(uuidGeneration());
        while (teacherService.find(teacher.getTeacherId()) != null) {
            teacher.setTeacherId(uuidGeneration());
        }
        teacherService.insert(teacher);
        HttpResponse response = new HttpResponse();
		response.setResponseMessage("Teacher Inserted with id "+ teacher.getTeacherId());
		return ResponseEntity.ok().body(response);
    }

    /**
     *  Api used to get all Teacher's Data and redirect to Show all generic page
     * @return ResponseEntity<DisplayAllData>
     */
    @GetMapping(value = getAllTeachersMapping)
    public ResponseEntity<DisplayAllData> showAllTeachers(ModelAndView modelAndView) {
    	return ResponseEntity.ok().body(teacherToDisplayAllData(teacherService.findAll()));
    }

    /**
     *  Api used to Update Teacher into Database
     * @param teacher Teacher's Data
     * @param teacherId Teacher's Id
     * @return ResponseEntity<HttpResponse>
     */
    @PutMapping(value = updateTeacherMapping + "{teacherId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpResponse> updateTeacher(@PathVariable("teacherId") String teacherId, @RequestBody Teacher teacher) {
        teacherService.update(teacher);
        HttpResponse response = new HttpResponse();
		response.setResponseMessage("Teacher Updated with id "+ teacher.getTeacherId());
		return ResponseEntity.ok().body(response);
        
    }

    /**
     *  Api used to Delete Teacher for Specific Teacher Id
     * @param teacherId Teacher's Id
     * @return ResponseEntity<HttpResponse>
     */
    @DeleteMapping(value = deleteTeacherMapping + "{teacherId}")
    public ResponseEntity<HttpResponse> delete(@PathVariable("teacherId") String teacherId) {
        teacherService.delete(teacherId);
        HttpResponse response = new HttpResponse();
		response.setResponseMessage("Teacher Deleted with id "+ teacherId);
		return ResponseEntity.ok().body(response);
    }

    /**
     * Api used to get Teacher By Teacher Id
     * @param teacherId Teacher's Id
     * @return ResponseEntity<Teacher>
     */
    @GetMapping(value = getStudentByStudentIdMapping + "{teacherId}")
	public ResponseEntity<Teacher> getStudentByStudentId(@PathVariable("teacherId") String teacherId) {
		return ResponseEntity.ok().body(teacherService.find(teacherId));
	}
    
}
