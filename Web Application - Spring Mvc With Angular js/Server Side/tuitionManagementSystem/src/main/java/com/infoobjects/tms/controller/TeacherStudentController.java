package com.infoobjects.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infoobjects.tms.dto.DisplayAllData;
import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.entity.HttpResponse;
import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.entity.Teacher;
import com.infoobjects.tms.service.interfaces.TeacherStudentServiceIncrement;

import static com.infoobjects.tms.utils.StudentUtils.studentToDisplayAllData;
import static com.infoobjects.tms.utils.TeacherStudentUtils.*;

import java.util.List;

/**
 * @author Aniket
 * @description Controller which Controls Http Request Related to TeacherStudent Mapping
 */
@CrossOrigin("*")
@Controller
public class TeacherStudentController {

	/**
	 *  TeacherStudent Service Reference to Perform Transformation Operation on TeacherStudent Mapping Data
	 */
	@Autowired
	private TeacherStudentServiceIncrement<TeacherStudent> teacherStudentService;


	/**
	 *  Api used to insert TeacherStudent Data into Database
	 * @param teacherStudent TeacherStudent Data
	 * @return ResponseEntity<HttpResponse>
	 */
	@PostMapping(value = insertTeacherStudentMapping, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpResponse> insertTeacherStudent(@RequestBody TeacherStudent teacherStudent){
		teacherStudentService.insert(teacherStudent);
		HttpResponse response = new HttpResponse();
		response.setResponseMessage("TeacherStudent Inserted with StudentId : " + teacherStudent.getStudentId() + " and TeacherId : " + teacherStudent.getTeacherId());
		return ResponseEntity.ok().body(response);
	}

	/**
	 *  Api used to get Students for Specific Teacher Id
	 * @param teacherId Teacher's Id
	 * @return ResponseEntity<List<Student>>
	 */
	@GetMapping(value = getStudentsByTeacherIdMapping + "{teacherId}")
	public ResponseEntity<List<Student>> getStudentsByTeacherId(@PathVariable("teacherId") String teacherId)  {
		return ResponseEntity.ok().body(teacherStudentService.getStudentsByTeacherId(teacherId));
	}

	/**
	 *  Api used to get Teachers for Specific Student Id
	 * @param studentId Student's Id
	 * @return ResponseEntity<List<Teacher>>
	 */
	@GetMapping(value = getTeachersByStudentIdMapping + "{studentId}")
	public ResponseEntity<List<Teacher>> getTeachersByStudentId(@PathVariable("studentId") String studentId)  {
		return ResponseEntity.ok().body(teacherStudentService.getTeachersByStudentId(studentId));
	}
	
	/**
	 *  Api used to get all TeacherStudent Mapping data
	 * @return modelAndView
	 */
	@GetMapping(value = getAllTeacherStudentMapping)
	public ResponseEntity<DisplayAllData> getAllTeacherStudents()  {
		return ResponseEntity.ok().body(teacherStudentToDisplayAllData(teacherStudentService.findAll()));
	}

	/**
	 *  Api used to Delete TeacherStudent Mapping from Database
	 * @param studentId Student's Id
	 * @param teacherId Teacher's Id
	 * @param modelAndView Store view name and Attributes value
	 * @return modelAndView
	 */
	@DeleteMapping(value = deleteTeacherStudentMapping + "{studentId}/{teacherId}")
	public ResponseEntity<HttpResponse> delete(@PathVariable("studentId") String studentId,@PathVariable("teacherId") String teacherId){
		teacherStudentService.delete(teacherId, studentId);
		HttpResponse response = new HttpResponse();
		response.setResponseMessage("TeacherStudent Deleted with StudentId : "+ studentId + " and TeacherId : " + teacherId);
		return ResponseEntity.ok().body(response);
	}
	
}
