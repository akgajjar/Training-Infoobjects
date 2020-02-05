package com.infoobjects.tms.dto;

import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.enums.Designation;

import static com.infoobjects.tms.utils.TmsUtils.checkNull;
import static com.infoobjects.tms.utils.TmsUtils.genericToString;

public class TeacherDTO implements DTO {

    private int teacherId;
    private String teacherName;
    private String teacherAddress;
    private String teacherMobile;
    private String teacherEmailId;
    private Designation teacherDesignation;
    private Double teacherSalary;

    @Override
    public String toString() {
        System.out.println("\n Teacher : \n\n");
        return genericToString(this);
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherMobile() {
        return teacherMobile;
    }

    public void setTeacherMobile(String teacherMobile) {
        this.teacherMobile = teacherMobile;
    }

    public String getTeacherEmailId() {
        return teacherEmailId;
    }

    public void setTeacherEmailId(String teacherEmailId) {
        this.teacherEmailId = teacherEmailId;
    }

    public Designation getTeacherDesignation() {
        return teacherDesignation;
    }

    public void setTeacherDesignation(Designation teacherDesignation) {
        this.teacherDesignation = teacherDesignation;
    }

    public Double getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(Double teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    public void updateDTOCheck(TeacherDTO source) {
        if (checkNull(this.getTeacherAddress()))
            this.setTeacherAddress(source.getTeacherAddress());
        if (checkNull(this.getTeacherEmailId()))
            this.setTeacherEmailId(source.getTeacherEmailId());
        if (checkNull(this.getTeacherMobile()))
            this.setTeacherMobile(source.getTeacherMobile());
        if (checkNull(this.getTeacherName()))
            this.setTeacherName(this.getTeacherName());
        if (this.getTeacherSalary() == 0.0)
            this.setTeacherSalary(source.getTeacherSalary());

    }

}
