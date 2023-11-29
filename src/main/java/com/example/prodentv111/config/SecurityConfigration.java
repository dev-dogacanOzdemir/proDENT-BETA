package com.example.prodentv111.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
public class SecurityConfigration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic();
        //Dashboard yoluna gelen yolda izin sağlamaya yarar.
        http.authorizeHttpRequests().antMatchers("/")
                .authenticated()
                .and()
                .authorizeHttpRequests().antMatchers("/dashboard").permitAll();
    }
}
