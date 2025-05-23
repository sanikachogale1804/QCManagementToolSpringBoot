package com.example.Demo.QCManagementTool.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**") // Apply CORS settings to all endpoints
	        .allowedOrigins(
	        		"http://localhost:3000"
	        	)
	            .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // Allowed HTTP methods
	            .allowedHeaders("Authorization", "Content-Type", "Accept") // Allowed headers (added Accept header)
	            .allowedHeaders("*")
	            .allowCredentials(true); // Allow credentials (cookies, tokens)
	    }

}
