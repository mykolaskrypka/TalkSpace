package com.challange.talkspace.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.challange.talkspace.security.JWTAuthenticationFilter.SIGN_UP_URL;


@Configuration
@EnableWebSecurity
public class FormLoginSecurityConfig {

//    private AuthenticationManager auth;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz ->
                        authz.anyRequest().permitAll())
//                                .requestMatchers(HttpMethod.POST, "/login").permitAll())
//                                .authenticated()
//                                .requestMatchers(HttpMethod.DELETE)
//                                .hasRole("ADMIN")
//                                .requestMatchers("/admin/**")
//                                .hasAnyRole("ADMIN")
//                                .requestMatchers("/user/**")
//                                .hasAnyRole("USER", "ADMIN")
//                                .requestMatchers("/login/**")
//                                .anonymous()
//                                .anyRequest().authenticated()
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .addFilter(new JWTAuthenticationFilter(auth))
//                .addFilter(new JWTAuthorizationFilter(auth))
                .build();
    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//                .username("user")
////                .password("password")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("user")
////                .password("password")
//                .roles("USER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

//    добавим уровень отладки и проигнорируем некоторые пути, например изображения или скрипты:

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        boolean securityDebug = false;
        return (web) -> web.debug(securityDebug)
                .ignoring()
                .requestMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
    }

}


//@Bean
//public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.securityMatcher("/api/**").authorizeHttpRequests(rmr -> rmr
//            .requestMatchers("/api/admin/**").hasRole(Role.ADMIN.name())
//            .requestMatchers("/api/**").authenticated()
//    ).httpBasic(httpbc -> httpbc
//            .authenticationEntryPoint(authenticationEntryPoint)
//    ).sessionManagement(smc -> smc
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//    ).csrf(AbstractHttpConfigurer::disable);
//    return http.build();