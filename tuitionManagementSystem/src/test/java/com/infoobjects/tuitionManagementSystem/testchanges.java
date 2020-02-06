package com.infoobjects.tuitionManagementSystem;

import com.infoobjects.tms.dto.TeacherDTO;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.utils.TmsUtils;

public class testchanges {
    public static void main(String[] args) {


        TeacherDTO teacher = new TeacherDTO();


        teacher.setTeacherId(101);
        teacher.setTeacherAddress("ahmedabad");
        teacher.setTeacherEmailId("abc@gmail.com");
        teacher.setTeacherSalary(2500.0);

        String val = TmsUtils.updateCheck(teacher, "teacherSalary", null);

        System.out.println(val);
    }
}
