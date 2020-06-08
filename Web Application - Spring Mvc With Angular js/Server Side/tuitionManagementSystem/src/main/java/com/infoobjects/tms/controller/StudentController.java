package com.infoobjects.tms.controller;

import static com.infoobjects.tms.utils.TmsUtils.*;

import java.util.List;

import static com.infoobjects.tms.utils.StudentUtils.*;
import static com.infoobjects.tms.utils.ConfigurationAndGenericConstants.*;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infoobjects.tms.dto.DisplayAllData;
import com.infoobjects.tms.entity.HttpResponse;
import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.service.interfaces.StudentServiceIncrement;


/**
 *@author Aniket
 *@description Controller which Controls Http Request Related to Student and StartUp
 */
@CrossOrigin("*")
@Controller
public class StudentController {

	/**
	 *  Student Service Reference to Perform Data Transformation Operation on Student Data
	 */
	@Autowired
	private StudentServiceIncrement<Student> studentService;

	/**
	 *  Api used to insert Student data into Database
	 * @param student Student Data
	 * @return ResponseEntity<HttpResponse>
	 */
	@PostMapping(value = insertStudentMapping, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpResponse> insertStudent(@RequestBody Student student) {
		// Generate UUID(Unique Random String) for Student Id
		student.setStudentId(uuidGeneration());
		while (studentService.find(student.getStudentId()) != null) {
			student.setStudentId(uuidGeneration());
		}
		studentService.insert(student);
		HttpResponse response = new HttpResponse();
		response.setResponseMessage("Student Inserted with id "+ student.getStudentId());
		return ResponseEntity.ok().body(response);
	}

	/**
	 * Api used to get all Student's Data and redirect to Show all generic page
	 * @return ResponseEntity<DisplayAllData>
 	 */
	@GetMapping(value = getAllStudentsMapping)
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok().body(studentService.findAll());
	}

	/**
	 *  Api used to Update Student into Database
	 * @param student Student Data
	 * @param studentId Student's Id
	 * @return ResponseEntity<HttpResponse>
	 */
	@PutMapping(value = updateStudentMapping + "{studentId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpResponse> updateStudent(@PathVariable("studentId") String studentId, @RequestBody Student student) {
		studentService.update(student);
		HttpResponse response = new HttpResponse();
		response.setResponseMessage("Student Updated with id "+ student.getStudentId());
		return ResponseEntity.ok().body(response);
	}

	/**
	 *  Api used to Delete Student for specific Student Id
	 * @param studentId Student's Id
	 * @return ResponseEntity<HttpResponse>
	 */
	@DeleteMapping(value = deleteStudentMapping + "{studentId}")
	public ResponseEntity<HttpResponse> delete(@PathVariable("studentId") String studentId){
		studentService.delete(studentId);
		HttpResponse response = new HttpResponse();
		response.setResponseMessage("Student Deleted with id "+ studentId);
		return ResponseEntity.ok().body(response);
	}
	
	/**
	 * Api used to get Student By Student Id
	 * @param studentId Student's Id
	 * @return ResponseEntity<Student>
 	 */
	@GetMapping(value = getStudentByStudentIdMapping + "{studentId}")
	public ResponseEntity<Student> getStudentByStudentId(@PathVariable("studentId") String studentId) {
		return ResponseEntity.ok().body(studentService.find(studentId));
	}
	
}
