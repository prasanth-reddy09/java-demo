package com.Prasanth.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 1. Marks this class as a configuration source
@Configuration 
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
        // Apply CORS rules to all API endpoints (/**)
        registry.addMapping("/**")
                // Allow requests from ANY origin/domain (*)
                .allowedOrigins("*") 
                // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
                .allowedMethods("*") 
                // Allow all headers
                .allowedHeaders("*");
    }
}