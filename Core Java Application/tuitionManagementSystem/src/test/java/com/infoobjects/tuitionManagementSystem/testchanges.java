package com.infoobjects.tuitionManagementSystem;

import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.utils.TmsUtils;
import org.apache.commons.text.CaseUtils;

import java.util.Map;

public class testchanges {
    public static void main(String[] args) {


        Teacher teacher = new Teacher();

/*

        teacher.setTeacherId("101");
        teacher.setTeacherAddress("ahmedabad");
        teacher.setTeacherEmailId("abc@gmail.com");
        teacher.setTeacherSalary(2500.0);

        Map map = TmsMapper.dtoToMap(teacher);
        String val = TmsUtils.updateCheck(teacher, "teacherSalary", null);



        System.out.println(map);


        System.out.println(TmsMapper.getTableName(teacher));

        System.out.println(CaseUtils.toCamelCase("TEACHER_ID",false ,'_'));
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        System.out.println("teacherId"
                .replaceAll(regex, replacement)
                .toUpperCase());
*/

        System.out.println(TmsUtils.uuidGeneration());
    }
}
