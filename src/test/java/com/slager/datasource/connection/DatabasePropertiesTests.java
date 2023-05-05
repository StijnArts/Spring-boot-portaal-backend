package com.slager.datasource.connection;

import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabasePropertiesTests {

    private static DatabaseProperties sut;

    private DatabaseProperties mockedDatabaseProperties = Mockito.mock(DatabaseProperties.class);

    @BeforeAll
    public static void setup(){
        sut = new DatabaseProperties();
    }

    @Test
    public void getDriverString(){
        //Arrange
        String driverTestString = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String sutString;
        //Act
        sutString = sut.driverString();
        //Assert
        assertEquals(driverTestString,sutString);
    }

    @Test
    public void getConnectionString(){
        //Arrange
        String connectionTestString = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;databaseName=slagerportal;trustServerCertificate=true;defaultResultSetHoldable=true";
        String sutString;
        //Act
        sutString = sut.connectionString();
        //Assert
        assertEquals(connectionTestString,sutString);
    }
}
