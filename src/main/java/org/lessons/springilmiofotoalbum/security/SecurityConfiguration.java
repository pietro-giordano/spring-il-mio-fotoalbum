package org.lessons.springilmiofotoalbum.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

      // UserDetailsService NECESSARIO
      @Bean
      DatabaseUserDetailsService userDetailsService() {
            return new DatabaseUserDetailsService();
      }

      // PasswordEncoder NECESSARIO
      @Bean
      PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
      }

      // AuthenticationProvider: UserDetailsService + PasswordEncoder
      @Bean
      DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

            authProvider.setUserDetailsService(userDetailsService());
            authProvider.setPasswordEncoder(passwordEncoder());

            return authProvider;
      }

      @Bean
      SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests()
                    .requestMatchers("/api/**").permitAll()
                    .requestMatchers("/photos/**").hasAuthority("ADMIN")
                    .requestMatchers("/categories/**").hasAuthority("ADMIN")
                    .requestMatchers("/**").permitAll()
                    .and().formLogin()
                    .and().logout()
                    .logoutSuccessUrl("http://localhost:5173");
            // disabilitiamo csrf per permettere chiamate api
            http.csrf().disable();
            return http.build();
      }
}
