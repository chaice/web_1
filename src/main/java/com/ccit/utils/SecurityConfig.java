package com.ccit.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by cc on 2017/8/18.
 */
@Configuration
@EnableWebSecurity
/**
 * @EnableWebSecurity注解将会启用Web安全功能
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private BasicDataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password from user where username = ?")
                .authoritiesByUsernameQuery("select username,role from user_role where username = ?")
                .passwordEncoder(new StandardPasswordEncoder("123456"));
        super.configure(auth);
    }
}
