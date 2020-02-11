package com.infoobjects.tms.mapper;

import com.infoobjects.tms.dto.interfaces.DTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TmsMapper {

    public static Map dtoToMap(DTO instanceVariable){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(instanceVariable, Map.class);
    }

    public static DTO mapToDto(Map mapVariable, DTO referenceVariable){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(mapVariable, referenceVariable.getClass());
    }
    public static String getTableName(DTO instanceVariable){
        return instanceVariable.getClass().getSimpleName();
    }

    public static List<Map<String, Object>> resultSetToMap(ResultSet rs){
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
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rows;
    }
}
