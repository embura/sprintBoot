package com.digitalOne.springboot.config;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testDatabaseConnection(){
        System.out.println("DB Connection dor DEV H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection for DEV H2_TEST - Test Instance";
    }

    @Profile("prod")
    @Bean
    public String productionDatabaseConnection(){
        System.out.println("DB Connection dor Prod H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection for PROD MYSQL_PROD - Production Instance";
    }
}
