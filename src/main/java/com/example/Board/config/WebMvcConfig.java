package com.example.Board.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration	// @Configuration은 설정 파일 or @Bean을 위함 (싱글톤)
public class WebMvcConfig implements WebMvcConfigurer {
	
	// 업로드 경로용 매개변수 (registry를 통해 경로 값을 읽어온다) -> (업로드 파일 경로로 이미지를 등록하게 됨)
	@Value("${uploadPath}")
	String uploadPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// ResourceHandlerRegistry를 통해 직접 경로 입력하여 경로에 보낸다
		registry
			.addResourceHandler("/image/**", "/resource/**")
			.addResourceLocations(uploadPath)
			.addResourceLocations("file:./src/", "/resources/");
	}
}
