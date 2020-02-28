package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.service.interfaces.TeacherStudentServiceIncrement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherStudentServiceImpl implements TeacherStudentServiceIncrement<String, TeacherStudent> {


    @Override
    public void insert(TeacherStudent teacherStudent) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.insert(TmsMapper.dtoToMap(teacherStudent), TmsMapper.getTableName(teacherStudent));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
    }

    @Override
    public TeacherStudent find(String id) {
        return null;
    }

    @Override
    public void update(TeacherStudent dto) {
    }

    @Override
    public TeacherStudent find(TeacherStudent teacherStudentDTO) {
        TeacherStudent teacherStudent = null;
        try {
            HashMap map = new HashMap();
            map.put("teacherId", teacherStudentDTO.getTeacherId());
            map.put("studentId", teacherStudentDTO.getStudentId());
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.find(map, "TeacherStudent");
            if (resultList.size() == 0) {
                return null;
            }
            Map<String, Object> mapResult = resultList.get(0);
            teacherStudent = (TeacherStudent) TmsMapper.mapToDto(mapResult, new TeacherStudent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherStudent;
    }

    @Override
    public void update(TeacherStudent oldteacherStudentDTO, TeacherStudent newteacherStudentDTO) {
        String sqlQuery = "UPDATE TEACHERSTUDENT SET TEACHER_ID = ? , STUDENT_ID = ? WHERE TEACHER_ID = ? AND STUDENT_ID = ?";
        List values = new ArrayList();
        values.add(newteacherStudentDTO.getTeacherId());
        values.add(newteacherStudentDTO.getStudentId());
        values.add(oldteacherStudentDTO.getTeacherId());
        values.add(oldteacherStudentDTO.getStudentId());
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.executeQueryWithOutResultSet(sqlQuery, values);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TeacherStudent> findAll() {
        List<TeacherStudent> teacherstudents = new ArrayList<>();
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.findAll(new HashMap(), "TeacherStudent");
            for (int loopCounter = 0; loopCounter < resultList.size(); loopCounter++) {
                Map<String, Object> mapResult = resultList.get(loopCounter);
                TeacherStudent teacherStudent = (TeacherStudent) TmsMapper.mapToDto(mapResult, new TeacherStudent());
                teacherstudents.add(teacherStudent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherstudents;
    }

    @Override
    public void delete(TeacherStudent teacherStudent) {
        try {
            HashMap conditions = new HashMap();
            conditions.put("teacherId", teacherStudent.getTeacherId());
            conditions.put("studentId", teacherStudent.getStudentId());
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.delete(conditions , "TeacherStudent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> showAllStudent(String teacherId) {
        List<Student> students = new ArrayList<>();
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

    @Override
    public List<Teacher> getTeacherName(String studentId) {
        List<Teacher> teachers = new ArrayList<>();
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            TeacherServiceImpl teacherService = new TeacherServiceImpl();
            Map conditions = new HashMap();
            conditions.put("studentId", studentId);
            List<Map<String, Object>> resultList = genericDAO.findAll(conditions, "TeacherStudent");

            for (int loopCounter = 0; loopCounter < resultList.size(); loopCounter++) {
                Map<String, Object> mapResult = resultList.get(loopCounter);
                TeacherStudent teacherStudent = (TeacherStudent) TmsMapper.mapToDto(mapResult, new TeacherStudent());
                Teacher teacher = (Teacher) teacherService.find(teacherStudent.getTeacherId());
                teachers.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;
    }

    @Override
    public void deleteAllStudents() throws Exception {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.delete(new HashMap() , "TeacherStudent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByStudentId(String studentId) {
        try {
            HashMap conditions = new HashMap();
            conditions.put("studentId", studentId);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.delete(conditions , "TeacherStudent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByTeacherId(String teacherId) {
        try {
            HashMap conditions = new HashMap();
            conditions.put("teacherId", teacherId);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.delete(conditions , "TeacherStudent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
