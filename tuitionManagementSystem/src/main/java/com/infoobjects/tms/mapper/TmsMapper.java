package com.infoobjects.tms.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.utils.TmsUtils;
import org.apache.commons.text.CaseUtils;
import sun.awt.X11.XKeyEvent;
import sun.awt.X11.XKeyboardFocusManagerPeer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TmsMapper {

    public static Map dtoToMap(DTO instanceVariable) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map dataMap = objectMapper.convertValue(instanceVariable, Map.class);
     /*   for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
           String key = iteratorMap.next();
           Object value = dataMap.get(key);

           dataMap.remove(key);

           dataMap.put(camelCaseToSnakeCase(key), value);
        }
*/
        dataMap.forEach((key, value) -> {
            dataMap.remove(key);
            dataMap.put(camelCaseToSnakeCase(String.valueOf(key)), value);
        });
        return dataMap;
    }

    public static DTO mapToDto(Map mapVariable, DTO referenceVariable) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(mapVariable, referenceVariable.getClass());
    }

    public static String getTableName(DTO instanceVariable) {
        return instanceVariable.getClass().getSimpleName();
    }

    public static List<Map<String, Object>> resultSetToMap(ResultSet rs) {
        List<Map<String, Object>> rows = new ArrayList<>();

        try {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>(columns);
                for (int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
                rows.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public static String camelCaseToSnakeCase(String value) {
        return value.replaceAll(TmsUtils.camelCaseRegex, TmsUtils.camelCaseReplacementregex).toUpperCase();
    }

    public static String snakeCaseToCamelCase(String value){
        return CaseUtils.toCamelCase("TEACHER_ID",false ,'_');
    }

}
