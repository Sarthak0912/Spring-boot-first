package com.springboot.crudoperation.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("user")).roles("USER").and().withUser("admin").password(passwordEncoder().encode("admin")).roles("USER","ADMIN");

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/school/**","/school").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/school/**","/school").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/school/**","/school").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/school/**","/school").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/**", "/school/**").hasAnyRole("USER","ADMIN")
                .and().httpBasic();
    }
}
