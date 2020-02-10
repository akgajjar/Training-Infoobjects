package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.dao.TeacherDAOImpl;
import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.dao.interfaces.TeacheDAOIncrement;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements  TeacherServiceIncrement<Integer, DTO> {

    private TeacheDAOIncrement<Integer, Teacher> teacherDAO = new TeacherDAOImpl();
    private TmsDAOImpl genericDAO = new TmsDAOImpl();

    public TeacheDAOIncrement<Integer, Teacher> getTeacherDAO() {
        return teacherDAO;
    }

    @Override
    public void insert(DTO teacherDTO) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.insert(TmsMapper.dtoToMap(teacherDTO),TmsMapper.getTableName(teacherDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            HashMap map = new HashMap();
            map.put("teacherId", id);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.delete(map ,"Teacher");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DTO find(Integer id) {
        DTO teacher = null;
        try {
            HashMap map = new HashMap();
            map.put("teacherId", id);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.find(map ,"Teacher");
            Map<String, Object> mapResult = resultList.get(0);
            teacher = TmsMapper.mapToDto(mapResult, new Teacher());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public void update(DTO teacherDTO) {
     //   teacherDAO.update(teacherDTO);
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.update(TmsMapper.dtoToMap(teacherDTO),TmsMapper.getTableName(teacherDTO), "teacherId");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DTO> findAll() {
        List<DTO> teachers = new ArrayList<>();
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.findAll("Teacher");
            for(int loopCounter = 0 ; loopCounter < resultList.size(); loopCounter++) {
                Map<String, Object> mapResult = resultList.get(loopCounter);
                DTO teacher = TmsMapper.mapToDto(mapResult, new Teacher());
                teachers.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;
    }


    @Override
    public void insertStudent(int studentId, int teacherId) throws Exception {
        teacherDAO.insertStudent(studentId, teacherId);
    }

    @Override
    public List<Student> showAllStudent(int teacherId, StudentDAOImpl studentDAO) {
        return teacherDAO.showAllStudent(teacherId, studentDAO);
    }

    @Override
    public void deleteStudents() throws Exception {
        teacherDAO.deleteStudents();
    }

}
