package com.apirestful.Locar;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_LIST = { "/api",
                                                "/api/auth",
                                                "/api/employer",
                                                "/api/employer/{cpf}",
                                                "/api/client",
                                                "/api/client/{cpf}",
                                                "/api/parther",
                                                "/api/parther/{rg}",
                                                "/api/automobile",
                                                "/api/automobile/{id}",
                                                "http://localhost:8080/swagger-ui.html.#/" };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers(AUTH_LIST).permitAll().anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth ) throws Exception {
        
    }

}
