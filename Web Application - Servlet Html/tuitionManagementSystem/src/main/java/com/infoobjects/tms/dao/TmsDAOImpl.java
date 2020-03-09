package com.infoobjects.tms.dao;

import com.infoobjects.tms.dto.interfaces.DTO;
import static com.infoobjects.tms.mapper.TmsMapper.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TmsDAOImpl {

    public void insert(Map dataMap, DTO reference) throws SQLException, ClassNotFoundException, Exception {
        StringBuilder placeholders = new StringBuilder();
        int i = 1;
        StringBuilder sql = new StringBuilder("INSERT INTO ").append(getTableName(reference)).append(" (");
        try {
            for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
                sql.append(camelCaseToSnakeCase(iteratorMap.next()));
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
        } catch (SQLException exception) {
            throw exception;
        } catch (ClassNotFoundException classNotFoundException) {
            throw classNotFoundException;
        } catch (Exception exception) {
            throw exception;
        }
    }


    public void delete(Map dataMap, DTO reference) throws SQLException, ClassNotFoundException, Exception {
        StringBuilder sql = new StringBuilder("DELETE FROM ").append(getTableName(reference));
        try {
            if (dataMap.size() > 0) {
                sql.append(" WHERE ");
                for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
                    sql.append(camelCaseToSnakeCase(iteratorMap.next()));
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
        } catch (SQLException exception) {
            throw exception;
        } catch (ClassNotFoundException classNotFoundException) {
            throw classNotFoundException;
        } catch (Exception exception) {
            throw exception;
        }
    }


    public List<Map<String, Object>> find(Map dataMap, DTO reference) throws SQLException, ClassNotFoundException, Exception {
        ResultSet resultSet = null;
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM ").append(getTableName(reference)).append(" WHERE ");
        try {
            for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
                sqlQuery.append(camelCaseToSnakeCase(iteratorMap.next()));
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

        } catch (SQLException exception) {
            throw exception;
        } catch (ClassNotFoundException classNotFoundException) {
            throw classNotFoundException;
        } catch (Exception exception) {
            throw exception;
        }
        return resultSetToMap(resultSet);
    }


    public void update(Map dataMap, DTO reference, String idName) throws SQLException, ClassNotFoundException, Exception {
        int i = 1;
        StringBuilder sqlQuery = new StringBuilder("UPDATE ").append(getTableName(reference)).append(" SET ");
        try {
            for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
                String columnName = iteratorMap.next();
                if (columnName.equalsIgnoreCase(idName)) {
                    continue;
                }
                sqlQuery.append(camelCaseToSnakeCase(columnName));
                sqlQuery.append(" = ? ");

                if (iteratorMap.hasNext()) {
                    sqlQuery.append(" , ");
                }
            }
            sqlQuery.append(" WHERE ").append(camelCaseToSnakeCase(idName)).append(" = ? ");
            PreparedStatement preparedStatement = null;
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlQuery.toString());
            Object idValue = dataMap.get(idName);
            dataMap.remove(idName);
            for (Object value : dataMap.values()) {
                preparedStatement.setObject(i++, value);
            }
            preparedStatement.setObject(i++, idValue);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw exception;
        } catch (ClassNotFoundException classNotFoundException) {
            throw classNotFoundException;
        } catch (Exception exception) {
            throw exception;
        }
    }

    public List<Map<String, Object>> findAll(Map dataMap, DTO reference) throws SQLException, ClassNotFoundException, Exception {
        ResultSet resultSet = null;
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM ").append(getTableName(reference));
        if (dataMap.size() > 0) {
            sqlQuery.append(" WHERE ");

            for (Iterator<String> iteratorMap = dataMap.keySet().iterator(); iteratorMap.hasNext(); ) {
                sqlQuery.append(camelCaseToSnakeCase(iteratorMap.next()));
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
        } catch (SQLException exception) {
            throw exception;
        } catch (ClassNotFoundException classNotFoundException) {
            throw classNotFoundException;
        } catch (Exception exception) {
            throw exception;
        }
        return resultSetToMap(resultSet);
    }

    public List<Map<String, Object>> executeQueryWithResultSet(String sqlQuery, List values) throws SQLException, ClassNotFoundException, Exception {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlQuery.toString());

            if (values.size() > 0) {
                int i = 1;
                for (Object value : values) {
                    preparedStatement.setObject(i++, value);
                }
            }
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException exception) {
            throw exception;
        } catch (ClassNotFoundException classNotFoundException) {
            throw classNotFoundException;
        } catch (Exception exception) {
            throw exception;
        }
        return resultSetToMap(resultSet);
    }

    public void executeQueryWithOutResultSet(String sqlQuery, List values) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlQuery.toString());

            if (values.size() > 0) {
                int i = 1;
                for (Object value : values) {
                    preparedStatement.setObject(i++, value);
                }
                preparedStatement.executeUpdate();
            }
        } catch (SQLException exception) {
            throw exception;
        } catch (ClassNotFoundException classNotFoundException) {
            throw classNotFoundException;
        } catch (Exception exception) {
            throw exception;
        }
    }

}
