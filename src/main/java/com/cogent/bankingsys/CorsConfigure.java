//package com.cogent.bankingsys;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfigure implements WebMvcConfigurer {
//
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedOrigins("http://localhost:3000", "https://example.com")
//				.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS").allowedHeaders("*")
//				.allowCredentials(true).maxAge(3600);
//	}
//
//}