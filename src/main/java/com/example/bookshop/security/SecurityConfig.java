package com.example.bookshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends GlobalMethodSecurityConfiguration {


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsService userDetail)
            throws Exception {

        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);

        auth.userDetailsService(userDetail).passwordEncoder(passwordEncoder());
        return auth.build();

    }

    // Je to vlastně pouze konfigurace, jak se mají chovat jednotlivé stránky a přístup k nim.
    // Všechny stránky autentizované a pro přístup použiji LOGIN page.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/registration").permitAll()
                //.requestMatchers("/admin").hasRole("ROLE_ADMIN")
                .anyRequest().authenticated()    // Všechny stránky musí být autentizované
                //.requestMatchers(HttpMethod.GET, "/h2/**").anonymous()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                //.httpBasic()
                //.and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout") // Redirect to login page with logout parameter
                .permitAll();
        //.and()
        // POZOR: Musím dát frameOptions DISABLED. Jinak se mi nenačte hlavní stránka H2 databáze.
        // Protože když dám PROZKOUMAT na stránce, která se objeví po login do H2 databáze , a která se nenačte ,
        // tak vidím, že chce renderovat nějaké FRAME - jsou aktivované pomocí Xframe Option.
        // A to tam dělá neplechu. Nutno zakázat.
        //.headers(headers -> headers.frameOptions().disable())
        //.csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
