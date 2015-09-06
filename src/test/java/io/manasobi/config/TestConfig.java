package io.manasobi.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2015-09-06.
 */
@Configuration
@EnableConfigurationProperties
public class TestConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.test")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    //System.setProperty("spring.profiles.active","dev");
}
