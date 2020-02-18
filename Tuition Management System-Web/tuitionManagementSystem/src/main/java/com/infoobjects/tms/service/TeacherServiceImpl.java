package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements TeacherServiceIncrement<Integer, DTO> {

    public void insert(DTO teacherDTO) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.insert(TmsMapper.dtoToMap(teacherDTO), TmsMapper.getTableName(teacherDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            HashMap map = new HashMap();
            map.put("teacherId", id);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.delete(map, "Teacher");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DTO find(Integer id) {
        DTO teacher = null;
        try {
            HashMap map = new HashMap();
            map.put("teacherId", id);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.find(map, "Teacher");
            if (resultList.size() == 0) {
                return null;
            }
            Map<String, Object> mapResult = resultList.get(0);
            teacher = TmsMapper.mapToDto(mapResult, new Teacher());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacher;
    }

    public void update(DTO teacherDTO) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.update(TmsMapper.dtoToMap(teacherDTO), TmsMapper.getTableName(teacherDTO), "teacherId");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DTO> findAll() {
        List<DTO> teachers = new ArrayList();
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.findAll(new HashMap(), "Teacher");
            for (int loopCounter = 0; loopCounter < resultList.size(); loopCounter++) {
                Map<String, Object> mapResult = resultList.get(loopCounter);
                DTO teacher = TmsMapper.mapToDto(mapResult, new Teacher());
                teachers.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;
    }


    public void insertStudent(DTO teacherStudent) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.insert(TmsMapper.dtoToMap(teacherStudent), TmsMapper.getTableName(teacherStudent));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> showAllStudent(int teacherId) {
        List<Student> students = new ArrayList();
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            StudentServiceImpl studentService = new StudentServiceImpl();
            Map conditions = new HashMap();
            conditions.put("teacherId", teacherId);
            List<Map<String, Object>> resultList = genericDAO.findAll(conditions, "TeacherStudent");

            for (int loopCounter = 0; loopCounter < resultList.size(); loopCounter++) {
                Map<String, Object> mapResult = resultList.get(loopCounter);
                TeacherStudent teacherStudent = (TeacherStudent) TmsMapper.mapToDto(mapResult, new TeacherStudent());
                Student student = (Student) studentService.find(teacherStudent.getStudentId());
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public void deleteAllStudents() throws Exception {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.delete(new HashMap(), "TeacherStudent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
