package com.slager.datasource.connection;

import com.slager.datasource.queryhelper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.*;

import javax.xml.crypto.*;

@Configuration
@ComponentScan
public class ConnectionConfig {

    private DatabaseProperties databaseProperties;

    @Autowired
    public ConnectionConfig(DatabaseProperties databaseProperties){
        this.databaseProperties = databaseProperties;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(databaseProperties.connectionString());
        driverManagerDataSource.setDriverClassName(databaseProperties.driverString());
        return new JdbcTemplate(driverManagerDataSource);
    }
}
