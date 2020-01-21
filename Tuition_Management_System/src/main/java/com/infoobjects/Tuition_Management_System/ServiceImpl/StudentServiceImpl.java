package com.infoobjects.Tuition_Management_System.ServiceImpl;

import java.util.List;

import com.infoobjects.Tuition_Management_System.DAO.ProjectDAO;
import com.infoobjects.Tuition_Management_System.DTO.StudentDTO;
import com.infoobjects.Tuition_Management_System.Service.StudentService;

public class StudentServiceImpl implements StudentService {

	private ProjectDAO<StudentDTO> projectdao = null;
	
	public StudentServiceImpl() {
		projectdao=new ProjectDAO<StudentDTO>();
	}

	public void insert(StudentDTO t) {
		projectdao.insert(t, t.getStudentId());
	}

	public void delete(int id) {
		projectdao.delete(id);
	}

	public StudentDTO find(int id) {
		return projectdao.find(id);
	}

	public void update(StudentDTO t) {
		projectdao.update(t,t.getStudentId());
	}

	public List<StudentDTO> findAll() {
		return projectdao.findAll();
	}
}
