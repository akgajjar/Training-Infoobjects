package com.infoobjects.tms.dao;

import com.infoobjects.tms.mapper.TmsMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TmsDAOImpl {

    public void insert(Map dataMap, String tableName) throws SQLException {
        StringBuilder placeholders = new StringBuilder();
        int i = 1;
        StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
        try {
            for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
                sql.append(TmsMapper.camelCaseToSnakeCase(iteratorMap.next()));
                placeholders.append("?");
                if (iteratorMap.hasNext()) {
                    sql.append(",");
                    placeholders.append(",");
                }
            }
            sql.append(") VALUES (").append(placeholders).append(")");
            PreparedStatement preparedStatement = SingletonConnection.getInstance().prepareStatement(sql.toString());

            for (Object value : dataMap.values()) {
                preparedStatement.setObject(i++, value);
            }
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            throw exception;
        }
    }


    public void delete(Map dataMap, String tableName) throws SQLException {
        StringBuilder sql = new StringBuilder("DELETE FROM ").append(tableName);
        try {
            if (dataMap.size() > 0) {
                sql.append(" WHERE ");
                for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
                    sql.append(TmsMapper.camelCaseToSnakeCase(iteratorMap.next()));
                    sql.append(" = ? ");
                    if (iteratorMap.hasNext()) {
                        sql.append(" AND ");
                    }
                }
            }
            sql.append(";");
            PreparedStatement preparedStatement;
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sql.toString());
            int i = 1;
            for (Object value : dataMap.values()) {
                preparedStatement.setObject(i++, value);
            }
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            throw exception;
        }
    }


    public List<Map<String, Object>> find(Map dataMap, String tableName) throws SQLException {
        ResultSet resultSet = null;
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM ").append(tableName).append(" WHERE ");
        try {
            for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
                sqlQuery.append(TmsMapper.camelCaseToSnakeCase(iteratorMap.next()));
                sqlQuery.append(" = ? ");
                if (iteratorMap.hasNext()) {
                    sqlQuery.append(" AND ");
                }
            }
            sqlQuery.append(";");
            PreparedStatement preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlQuery.toString());
            int counterValue = 1;
            for (Object value : dataMap.values()) {
                preparedStatement.setObject(counterValue++, value);
            }
            resultSet = preparedStatement.executeQuery();

        } catch (Exception exception) {
            throw exception;
        }
        return TmsMapper.resultSetToMap(resultSet);
    }


    public void update(Map dataMap, String tableName, String idName) throws SQLException {
        int i = 1;
        StringBuilder sqlQuery = new StringBuilder("UPDATE ").append(tableName).append(" SET ");
        try {
            for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
                String columnName = iteratorMap.next();
                if (columnName.equalsIgnoreCase(idName)) {
                    continue;
                }
                sqlQuery.append(TmsMapper.camelCaseToSnakeCase(columnName));
                sqlQuery.append(" = ? ");

                if (iteratorMap.hasNext()) {
                    sqlQuery.append(" , ");
                }
            }
            sqlQuery.append(" WHERE ").append(TmsMapper.camelCaseToSnakeCase(idName)).append(" = ? ");
            PreparedStatement preparedStatement = null;
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlQuery.toString());
            Object idValue = dataMap.get(idName);
            dataMap.remove(idName);
            for (Object value : dataMap.values()) {
                preparedStatement.setObject(i++, value);
            }
            preparedStatement.setObject(i++, idValue);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            throw exception;
        }
    }

    public List<Map<String, Object>> findAll(Map dataMap, String tableName) throws SQLException {
        ResultSet resultSet = null;
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM ").append(tableName);
        if (dataMap.size() > 0) {
            sqlQuery.append(" WHERE ");

            for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
                sqlQuery.append(TmsMapper.camelCaseToSnakeCase(iteratorMap.next()));
                sqlQuery.append(" = ? ");

                if (iteratorMap.hasNext()) {
                    sqlQuery.append(" AND ");
                }
            }
        }
        try {
            PreparedStatement preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlQuery.toString());
            if (dataMap.size() > 0) {
                int i = 1;
                for (Object value : dataMap.values()) {
                    preparedStatement.setObject(i++, value);
                }
            }
            resultSet = preparedStatement.executeQuery();
        } catch (Exception exception) {
            throw exception;
        }
        return TmsMapper.resultSetToMap(resultSet);
    }

    public List<Map<String, Object>> executeQueryWithResultSet(String sqlQuery, List values) throws SQLException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlQuery.toString());
        if (values.size() > 0) {
            int i = 1;
            for (Object value : values) {
                preparedStatement.setObject(i++, value);
            }
        }
        resultSet = preparedStatement.executeQuery();
        return TmsMapper.resultSetToMap(resultSet);
    }

    public void executeQueryWithOutResultSet(String sqlQuery, List values) throws SQLException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlQuery.toString());
        if (values.size() > 0) {
            int i = 1;
            for (Object value : values) {
                preparedStatement.setObject(i++, value);
            }
            preparedStatement.executeUpdate();
        }
    }
}
