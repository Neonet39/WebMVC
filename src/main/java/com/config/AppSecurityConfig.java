package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan("com.config.security")
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
      /*  http.csrf().disable();
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
*/
    }



}