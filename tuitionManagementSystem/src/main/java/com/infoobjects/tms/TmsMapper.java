package com.infoobjects.tms;

import com.infoobjects.tms.dto.interfaces.DTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class TmsMapper {

    public static Map dtoToMap(DTO instanceVariable){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(instanceVariable, Map.class);
    }

    public static DTO mapTodto(Map mapVariable){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(mapVariable, DTO.class);
    }
    public static String getTableName(DTO instanceVariable){
        return instanceVariable.getClass().getSimpleName();
    }

}
