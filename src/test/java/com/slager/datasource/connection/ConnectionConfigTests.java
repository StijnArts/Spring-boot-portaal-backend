//package com.slager.datasource.connection;
//
//import org.junit.jupiter.api.*;
//import org.mockito.*;
//import org.springframework.jdbc.core.*;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ConnectionConfigTests {
//    private static ConnectionConfig sut;
//    private static DatabaseProperties databaseProperties = Mockito.mock(DatabaseProperties.class);
//
//    @BeforeAll
//    public static void setup(){
//        sut = new ConnectionConfig(databaseProperties);
//    }
//
//    @Test
//    public void getConnectionString(){
//        //Arrange
//        Mockito.doReturn("com.microsoft.sqlserver.jdbc.SQLServerDriver").when(databaseProperties).driverString();
//        Mockito.doReturn("jdbc:sqlserver://localhost:1433;integratedSecurity=true;databaseName=slagerportal;trustServerCertificate=true;defaultResultSetHoldable=true").when(databaseProperties).connectionString();
//        //Assert
//        assertEquals(true, sut.jdbcTemplate() != null);
//    }
//}
