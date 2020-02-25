package com.infoobjects.tms;

import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.utils.TmsUtils;
import org.apache.commons.text.CaseUtils;

import java.util.List;
import java.util.Map;

public class testchanges {
    public static void main(String[] args) {
        StudentServiceImpl studentService = new StudentServiceImpl();

        StringBuffer outputString = new StringBuffer();
        outputString.append(TmsUtils.getDataTablesCssJavascriptString());
        /* outputString.append("<script type=\"text/javascript\"> location='showalldata.html';alert('Inserted Successfully!!!!!!');</script>");
         */
        outputString.append("<table cellpadding=\"10\"  id=\"example\" class=\"display\">\n");
        outputString.append("<thead><tr><th>Student Id</th>\n");
        outputString.append("<th>Student Name</th>\n");
        outputString.append("<th>Class</th>\n");
        outputString.append("<th>View Full Details</th>\n");
        outputString.append("<th>View Teacher Name </th>\n");
        outputString.append("<th>Update</th>\n");
        outputString.append("<th>Delete</th></thead>\n<tbody>\n");

        List<DTO> students =studentService.findAll();
        for(DTO student : students){
            Student studentReference = (Student) student;
            outputString.append("<tr>\n<td>").append(studentReference.getStudentId());
            outputString.append("</td>\n<td>").append(studentReference.getStudentName());
            outputString.append("</td>\n<td>").append(studentReference.getStudentClass());
            outputString.append("</td>\n<td>").append("<form method=\"get\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\" value=\"Show Full Details\">").append("</form>");
            outputString.append("</td>\n<td>").append("<form method=\"get\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\" value=\"View Teacher Name\">").append("</form>");
            outputString.append("</td>\n<td>").append("<form method=\"get\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\" value=\"Update\">").append("</form>");
            outputString.append("</td>\n<td>").append("<form method=\"get\" action=\"studentController\"><input type = \"hidden\" name=\"id\" value =\"").append(studentReference.getStudentId()).append("\"><input type=\"submit\" name=\"action\" value=\"Delete\">").append("</form>");
            outputString.append("</td>\n</tr>");
        }
        outputString.append("\n</tbody>\n</table>");
/*

        Teacher teacher = new Teacher();


        teacher.setTeacherId(101);
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

        System.out.println(outputString);
    }
}
