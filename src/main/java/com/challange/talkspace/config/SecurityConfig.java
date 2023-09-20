package com.challange.talkspace.config;

import com.challange.talkspace.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        ((UrlAuthorizationConfigurer.AuthorizedUrl) httpSecurity.authorizeRequests().anyRequest()).authenticated();
//        httpSecurity.formLogin();
//        httpSecurity.httpBasic();
//        return (SecurityFilterChain) httpSecurity.build();

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/getHello").permitAll()
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/auth/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults());

        return http.build();
//        httpSecurity
//                .csrf(csrf -> csrf.disable())
//                .cors(cors -> cors.disable())
//                // .sessionManagement(sm ->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                // .formLogin(fl -> {})
//                .securityMatcher("/**");
//        //;
//        return httpSecurity.build();
    }
        //.
                //.authorizeHttpRequests(authz ->
                //        authz.anyRequest().permitAll());
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
                //.sessionManagement(session ->
                //        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .addFilter(new JWTAuthenticationFilter(auth))
//                .addFilter(new JWTAuthorizationFilter(auth))
          //      .build();

        //return httpSecurity.build();


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

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        boolean securityDebug = false;
//        return (web) -> web.debug(securityDebug)
//                .ignoring()
//                .requestMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
//    }

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