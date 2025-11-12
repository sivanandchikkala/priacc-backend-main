package com.disaster.gateway.config;

import com.disaster.gateway.filter.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;

    public GatewayConfig(JwtAuthenticationFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r.path("/api/v1/auth/**")
                        .uri("lb://auth-service"))
                .route("core-service", r -> r.path("/api/v1/incidents/**", "/api/v1/sensors/**")
                        .filters(f -> f.filter(jwtAuthFilter))
                        .uri("lb://core-service"))
                .route("ai-service", r -> r.path("/api/v1/ai/**")
                        .filters(f -> f.filter(jwtAuthFilter))
                        .uri("lb://ai-service"))
                .route("notification-service", r -> r.path("/api/v1/notify/**")
                        .filters(f -> f.filter(jwtAuthFilter))
                        .uri("lb://notification-service"))
                .build();
    }
}
