package io.manasobi.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Created by bw on 9/1/15.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="spring.datasource.test")
public class DataSourceConfig {

    String driver = "org.h2.Driver";
    String url = "jdbc:h2:tcp://localhost/~/test";
    String username = "sa";
    String password = "";

    @Bean

    public DataSource testDataSource() {



        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;

        //return DataSourceBuilder.create().build();
    }

    @Bean
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(testDataSource());

        return flyway;
    }
}
