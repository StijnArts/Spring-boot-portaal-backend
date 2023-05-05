package com.slager.datasource.queryhelper;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Repository
@Component
public class QueryHelper{
    JdbcTemplate jdbcTemplate;

    @Autowired
    public QueryHelper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void executeQueryWithoutResultWithTransaction(String query, ArrayList<Object> parameters) {
        executePreparedStatement(query, parameters);
    }

    public List executeQueryWithResult(String query, ArrayList<Object> parameters, RowMapper rowMapper) {
        return executePreparedStatement(query, parameters, rowMapper);
    }

    @Transactional
    public List executeQueryWithResultAndTransaction(String query, ArrayList<Object> parameters, RowMapper rowMapper) {
        return executePreparedStatement(query, parameters, rowMapper);
    }

    public void executeQueryWithoutResult(String query, ArrayList<Object> parameters) {
        executePreparedStatement(query, parameters);
    }

    public List executePreparedStatement(String query, ArrayList<Object> parameters, RowMapper rowMapper){
        return jdbcTemplate.query(query, preparedStatement -> {
            int i = 1;
            for (Object parameter: parameters) {
                preparedStatement.setObject(i,parameter);
                i++;
            }
        }, rowMapper);
    }

    public void executePreparedStatement(String query, ArrayList<Object> parameters){
        jdbcTemplate.update(query, preparedStatement -> {
            int i = 1;
            for (Object parameter: parameters) {
                preparedStatement.setObject(i,parameter);
                i++;
            }
        });
    }

//    @Autowired
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
}

