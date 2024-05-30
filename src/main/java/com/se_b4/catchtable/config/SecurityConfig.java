package com.se_b4.catchtable.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authorizeRequests) ->
                authorizeRequests.anyRequest().permitAll() // 시작 기본 스프링 로그인 페이지 제거
        );
        http
                .formLogin(formLogin -> formLogin
                        .loginPage("/users/signin")
                        .defaultSuccessUrl("/")
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                );

//                .logout(logout -> logout
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/users/signout")) // 로그아웃 URL
//                        .logoutSuccessUrl("/") // 로그아웃 성공 후 리디렉션
//                        .invalidateHttpSession(true) // 세션 무효화
//                        .deleteCookies("JSESSIONID") // 쿠키 삭제
//                        .permitAll() // 로그아웃은 모두 접근 가능
//                )
//                .csrf(csrf -> csrf.disable()); // CSRF 비활성화 (필요에 따라 활성화 고려)
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/ignore1", "/ignore2");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() { // Password 암호화
        return new BCryptPasswordEncoder();
    }
}