package com.infoobjects.tms.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.utils.TmsUtils;
import org.apache.commons.text.CaseUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

public class TmsMapper {

    public static Map dtoToMap(DTO instanceVariable) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map dataMap = objectMapper.convertValue(instanceVariable, Map.class);
        Map returnMap = new HashMap();
        for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
           String key = iteratorMap.next();
           Object value = dataMap.get(key);


            returnMap.put(key,value);
        }
        return returnMap;
    }

    public static DTO mapToDto(Map mapVariable, DTO referenceVariable) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(mapVariable, referenceVariable.getClass());
    }

    public static String getTableName(DTO instanceVariable) {
        return instanceVariable.getClass().getSimpleName();
    }

    public static List<Map<String, Object>> resultSetToMap(ResultSet rs) {
        List<Map<String, Object>> rowList = new ArrayList<>();

        try {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>(columns);
                for (int i = 1; i <= columns; ++i) {
                    row.put(snakeCaseToCamelCase(md.getColumnName(i)), rs.getObject(i));
                }
                rowList.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowList;
    }

    public static String camelCaseToSnakeCase(String value) {
        return value.replaceAll(TmsUtils.camelCaseRegex, TmsUtils.camelCaseReplacementRegex).toUpperCase();
    }

    public static String snakeCaseToCamelCase(String value){
        return CaseUtils.toCamelCase(value,false ,'_');
    }

}
