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
                                                "/api/login",
                                                "/api/todosFuncionarios",
                                                "/api/todosFuncionarios/{cpf}",
                                                "/api/inserirFuncionario",
                                                "/api/apagarFuncionario",
                                                "/api/editarFuncionario",
                                                "/api/funcionario/clienteParceiro",
                                                "/api/todasReservas",
                                                "/api/inserirReservas",
                                                "/api/editarReservas",
                                                "/api/apagarReservas",
                                                "/api/todasReservas/{cpf}" };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers(AUTH_LIST).permitAll().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth ) throws Exception {
        
    }

}
