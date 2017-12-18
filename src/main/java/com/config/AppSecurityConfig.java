package com.config;

import com.security.test4.AuthenticationTokenProcessingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.security")
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.logout();
        http.formLogin().
                loginPage("/login")
                .permitAll()
                .and().authorizeRequests()
                .antMatchers("/login/authorize").permitAll()
                .antMatchers("/mainPage").access("hasRole('ROLE_USER')");
        //.anyRequest().authenticated();

        http.addFilterBefore(new AuthenticationTokenProcessingFilter(userDetailsService), UsernamePasswordAuthenticationFilter.class);

    }
//


}
