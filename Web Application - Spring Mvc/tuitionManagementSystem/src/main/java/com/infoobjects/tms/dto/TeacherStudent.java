package com.infoobjects.tms.dto;

import com.infoobjects.tms.dto.interfaces.DTO;

import static com.infoobjects.tms.utils.TmsUtils.genericToString;

public class TeacherStudent implements DTO {
    private String teacherId;
    private String studentId;
    private String teacherName;
    private String studentName;
    
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
