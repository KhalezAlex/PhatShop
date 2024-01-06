package ru.phatshop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtRequestFilter filter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/register/").hasRole("ADMIN")
                                .requestMatchers("/register/").hasAnyRole("USER")
                                .requestMatchers("/register/").hasRole("SELLER")
                                .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("").authenticated()
//                        .requestMatchers("/registration").anonymous()
                                .requestMatchers("/registration", "/auth").permitAll()
                                .anyRequest().authenticated()
                )
                //Отключаем сессие у реста в куках
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                //Выдаём ошибку при непредоставленном токене, аля 401 ошибка
                .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .failureUrl("/login?error=true")
//                        .permitAll()
//                        .defaultSuccessUrl("/")
//                )
//                .logout((logout) -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/"));
        return http.build();
    }

}
