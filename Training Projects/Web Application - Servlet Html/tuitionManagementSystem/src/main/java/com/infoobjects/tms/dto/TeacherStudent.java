package com.infoobjects.tms.dto;

import com.infoobjects.tms.dto.interfaces.DTO;

import static com.infoobjects.tms.utils.TmsUtils.genericToString;

public class TeacherStudent implements DTO {
    private String teacherId;
    private String studentId;

    @Override
    public String toString() {
        System.out.println("TeacherStudent : \n");
        return genericToString(this);
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
