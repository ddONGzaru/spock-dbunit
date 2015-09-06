package io.manasobi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2015-09-06.
 */
@Configuration
@ComponentScan("io.manasobi.jpa")
@EnableTransactionManagement
@EnableSpringConfigured
@EnableJpaRepositories("io.manasobi.jpa")
@Import(value = DataSourceConfig.class)
public class TestConfig {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestConfig.class, args);
    }

    @Autowired
    Environment env;

    @Resource(name = "testDataSource")
    DataSource dataSource;

    /*@Bean
    public DataSource testDataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }*/

    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException, PropertyVetoException{
        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(jpaVendorAdapter());
        emf.setPersistenceUnitName("rss");
        emf.setPackagesToScan("pe.kr.ddakker.jpa.domain");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        //properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.format_sql", "true");
        emf.setJpaProperties(properties);
        return  emf;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws PropertyVetoException, SQLException {
        JpaTransactionManager trans = new JpaTransactionManager();
        trans.setEntityManagerFactory(entityManagerFactory().getObject());
        return trans;
    }

}
