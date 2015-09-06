package io.manasobi.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2015-09-06.
 */
@SpringBootApplication
public class TestConfig {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestConfig.class, args);
    }

    //System.setProperty("spring.profiles.active","dev");
}
