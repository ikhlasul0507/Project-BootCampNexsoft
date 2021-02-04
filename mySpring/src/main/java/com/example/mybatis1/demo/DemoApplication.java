package com.example.mybatis1.demo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.lang.annotation.*;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
@MapperScan("com.example")
public class DemoApplication {

    @Autowired
    private HelloWorldMapper helloWorldMapper;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
    }

    @PostConstruct
    public void init() {
        System.out.println(helloWorldMapper.getString("World"));
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}