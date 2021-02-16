package com.apirestful.Locar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    private static final String[] AUTH_LIST = { "/api",
                                                "/api/login/funcionario", 
                                                "/api/login/cliente" };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers(AUTH_LIST).permitAll().anyRequest().authenticated();
    }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth ) throws Exception {
    //     auth.userDetailsService(userDetailsService);
    // }

    // @Bean(name = "pwdEncoder")
    // public PasswordEncoder getPasswordEncoder() {
    //     DelegatingPasswordEncoder delPasswordEncoder = (DelegatingPasswordEncoder) PasswordEncoderFactories
    //             .createDelegatingPasswordEncoder();
    //     BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
    //     delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder);
    //     return delPasswordEncoder;
    // }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception
    // {
    // auth.userDetailsService(customFuncionarioDetailService);
    // }
}
