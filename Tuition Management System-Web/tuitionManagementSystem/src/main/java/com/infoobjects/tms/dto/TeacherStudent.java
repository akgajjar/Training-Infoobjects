package com.infoobjects.tms.dto;

import com.infoobjects.tms.dto.interfaces.DTO;

import static com.infoobjects.tms.utils.TmsUtils.genericToString;

public class TeacherStudent implements DTO {
    private int teacherId;
    private int studentId;

    @Override
    public String toString() {
        System.out.println("TeacherStudent : \n");
        return genericToString(this);
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
