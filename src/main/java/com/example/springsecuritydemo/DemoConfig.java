package com.example.springsecuritydemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
          auth.inMemoryAuthentication()
                  .withUser("Mani")
                  .password("$2a$10$boUO8c2vnJ2ldDXtoctQFuqGj4RyyE1awAb2A3R/l4p6eHNJZB3IS")
                  .authorities("doctor")
                  .and()
                  .withUser("Vaishu")
                  .password("$2a$10$GFvLyU1rOzQvFfFyKlEcsO9OOPt4c5AMdICxnYhbjy7kRZLZdfUfi")
                  .authorities("ceo")
                  .and()
                  .withUser("Neetu")
                  .password("$2a$10$KhiVjHJ/ZTEq0CwRMcspuOqydY0st1EN7DlRsC4IWApaX1EhxCxzG")
                  .authorities("deo");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
          http.authorizeRequests()
                  .antMatchers("/doctor/**").hasAuthority("doctor")
                  .antMatchers("/deo/**").hasAuthority("deo")
                  .antMatchers("/ceo/**").hasAuthority("ceo")
                  .antMatchers("/schedule/**").hasAnyAuthority("doctor","deo")
                  .antMatchers("/**").permitAll()
                  .and()
                  .formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
