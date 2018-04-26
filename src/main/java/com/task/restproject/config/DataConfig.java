package com.task.restproject.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan(basePackages = "com.task.restproject.model")
@Configuration
@PropertySource("classpath:application.properties")

public class DataConfig {

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getRequiredProperty("spring.datasource.url"));
        dataSource.setUsername(env.getRequiredProperty("spring.datasource.username"));
        dataSource.setPassword(env.getRequiredProperty("spring.datasource.password"));
        return dataSource;
    }

    @Bean
    public Properties getHibernateProperties(){
        Properties properties=new Properties();
        properties.put("hibernate.dialect",env.getRequiredProperty("spring.jooq.sql-dialect"));
        properties.put("hibernate.show_sql",env.getRequiredProperty("spring.jpa.show-sql"));
        properties.put("hibernate.hbm2ddl.auto",env.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.connection.CharSet",env.getRequiredProperty("spring.freemarker.charset"));
        properties.put("hibernate.connection.characterEncoding",env.getRequiredProperty("spring.datasource.sql-script-encoding"));
        properties.put("hibernate.connection.useUnicode","true");
        return  properties;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=
                new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("spring.data.cassandra.keyspace-name"));

        return entityManagerFactoryBean;
    }

}