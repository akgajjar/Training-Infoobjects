package com.infoobjects.tms.dao;

import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.utils.SingletonConnection;
import com.infoobjects.tms.utils.TmsUtils;

import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TmsDAOImpl {

    public void insert(Map dataMap, String tableName) {
        StringBuilder placeholders = new StringBuilder();
        int i = 1;
        StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
        try {
            for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
                sql.append(iteratorMap.next());
                placeholders.append("?");
                if (iteratorMap.hasNext()) {
                    sql.append(",");
                    placeholders.append(",");
                }
            }
            sql.append(") VALUES (").append(placeholders).append(")");
            PreparedStatement preparedStatement = null;
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sql.toString());

            for (Object value : dataMap.values()) {
                preparedStatement.setObject(i++, value);
            }
           preparedStatement.executeUpdate();
            System.out.print(TmsUtils.insertSuccessmsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void delete(Integer id) {

    }


    public DTO find(Integer id) {
        return null;
    }


    public void update(DTO dto) {

    }


    public List<DTO> findAll() {
        return null;
    }
}
