package com.fastmarket.fastmarket.security;

import javax.servlet.http.HttpSessionListener;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebConfigSecurity extends WebSecurityConfigurerAdapter implements HttpSessionListener {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.GET, "/listar-acesso-por-id/*")
                .antMatchers(HttpMethod.DELETE, "/deletar-acesso-por-id/*")
                .antMatchers(HttpMethod.PUT, "/editar-acesso/*")
                .antMatchers(HttpMethod.GET, "/listar-acessos")
                .antMatchers(HttpMethod.POST, "/salvar-acesso");
    }
}
