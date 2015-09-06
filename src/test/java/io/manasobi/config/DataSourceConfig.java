package io.manasobi.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by bw on 9/1/15.
 */
@Configuration
@EnableConfigurationProperties
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.test")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }
}
