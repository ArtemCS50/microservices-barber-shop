package com.diploma.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
   @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        http.authorizeExchange()
//                .pathMatchers("/booking/**").hasRole("ADMIN")
//                .pathMatchers("/catalog/**").authenticated()
//                .pathMatchers("/feedback/**").authenticated()
//                .pathMatchers("/schedule/**").hasAnyRole("ADMIN", "MASTER")
//                .pathMatchers("/user/**").authenticated()
//                .anyExchange().permitAll()
//                .and().oauth2ResourceServer().jwt()
//                .jwtAuthenticationConverter(jwtAuthenticationConverter());
//        return http.build();

       http.authorizeExchange(exchange -> exchange.pathMatchers("/eureka/**")
                       .permitAll()
                       .anyExchange()
                       .authenticated()
               )
               .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
       return http.build();
    }
}
