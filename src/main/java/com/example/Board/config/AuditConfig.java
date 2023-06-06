package com.example.Board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@Configuration	// @Configuraion은 설정 파일
@EnableJpaAuditing //JPA 기능 활성화
public class AuditConfig {
	
	// Bean은 Configuration 주로 사용한다 (싱글톤)
	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}

}
