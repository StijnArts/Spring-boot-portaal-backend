package com.slager.datasource.queryhelper;

import org.junit.jupiter.api.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.jdbc.datasource.embedded.*;

import java.util.*;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class QueryHelperTests {
    private static EmbeddedDatabase h2;
    private static QueryHelper sut;
    @BeforeEach
    public void setup(){
        EmbeddedDatabase h2 = new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(H2)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("schema.sql")
                .addScripts("data.sql")
                .build();

        sut = new QueryHelper(new JdbcTemplate(h2));
    }

//    @AfterEach
//    public void shutdown(){
//        h2.shutdown();
//    }

    @Test
    public void executeQueryWithResultAndTransaction(){
        //Arrange
        String dog = "Dog";
        String result = "";
        String query = "SELECT ANIMAL FROM TEST WHERE ANIMAL = ?";
        ArrayList<Object> params = new ArrayList<>();
        params.add(dog);
        //Act
        result = (String) sut.executeQueryWithResultAndTransaction(query, params, (resultSet, rowNum) -> {
            return resultSet.getString("ANIMAL");
        }).get(0);
        //Assert
        assertEquals(dog, result);
    }

    @Test
    public void executeQueryWithResultWithoutTransaction(){
        //Arrange
        String dog = "Dog";
        String result = "";
        String query = "SELECT ANIMAL FROM TEST WHERE ANIMAL = ?";
        ArrayList<Object> params = new ArrayList<>();
        params.add(dog);
        //Act
        result = (String) sut.executeQueryWithResult(query, params, (resultSet, rowNum) -> {
            return resultSet.getString("ANIMAL");
        }).get(0);
        //Assert
        assertEquals(dog, result);
    }

    @Test
    public void executeQueryWithoutResultAndTransaction(){
        //Arrange
        String dog = "Dog";
        String meerkat = "meerkat";
        String result = "";
        String selectQuery = "SELECT ANIMAL FROM TEST WHERE ANIMAL = ?";
        String updateQuery = "UPDATE TEST SET ANIMAL = ? WHERE ANIMAL = ?";
        ArrayList<Object> selectParams = new ArrayList<>();
        selectParams.add(meerkat);
        ArrayList<Object> updateParams = new ArrayList<>();
        updateParams.add(meerkat);
        updateParams.add(dog);
        //Act
        sut.executeQueryWithoutResultWithTransaction(updateQuery, updateParams);
        result = (String) sut.executeQueryWithResult(selectQuery, selectParams, (resultSet, rowNum) -> {
            return resultSet.getString("ANIMAL");
        }).get(0);
        //Assert
        assertEquals(meerkat, result);
    }

    @Test
    public void executeQueryWithoutResultWithoutTransaction(){
        //Arrange
        String dog = "Dog";
        String raccoon = "Raccoon";
        String result = "";
        String selectQuery = "SELECT ANIMAL FROM TEST WHERE ANIMAL = ?";
        String updateQuery = "UPDATE TEST SET ANIMAL = ? WHERE ANIMAL = ?";
        ArrayList<Object> selectParams = new ArrayList<>();
        selectParams.add(raccoon);
        ArrayList<Object> updateParams = new ArrayList<>();
        updateParams.add(raccoon);
        updateParams.add(dog);
        //Act
        sut.executeQueryWithoutResult(updateQuery, updateParams);
        result = (String) sut.executeQueryWithResult(selectQuery, selectParams, (resultSet, rowNum) -> {
            return resultSet.getString("ANIMAL");
        }).get(0);
        //Assert
        assertEquals(raccoon, result);
    }
}
