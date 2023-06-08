package com.example.Board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.Board.service.MemberService;

@Configuration	// @Configuraion은 설정 파일, Bean을 사용하기 위해 설정 (싱글톤)
@EnableWebSecurity	// 스프링 시큐리티에서 FilterChain이 자동으로 포함됨
public class SecurityConfig {
	
	@Autowired
	MemberService memberService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		/* Authentication (인증) 로그인에 사용함 */
		/* Authorize (권한) 접근 설정 때 사용함 */
		
		http.
			formLogin()	// 로그인 부분 설정
			.loginPage("/login")	//로그인 페이지 url 설정
			.defaultSuccessUrl("/main")	  // 로그인 성공 시 url 설정
			.usernameParameter("userId")	// 로그인 시 사용할 아이디의 entity 파라미터 설정
			.passwordParameter("password")	// 로그인 시 사용할 비밀번호의 entity 파라미터 설정
			.failureUrl("/login/fail")	// 로그인 실패 시 url 설정
		.and()
			.logout()	// 로그아웃 부분 설정
			.logoutRequestMatcher(new AntPathRequestMatcher("/login/logout"))	// 로그아웃 url
			.logoutSuccessUrl("/main");
		
		http
			.authorizeHttpRequests()	// http를 이용하는 접근 설정
			.requestMatchers("/css/**", "/js/**", "/image/**").permitAll()	// 모두 접근 가능
			.requestMatchers("/login", "/join/**", "/login/**", "/join/**", "/main/**").permitAll()	// 모두 접근 가능
			.requestMatchers("/member/**").hasAnyRole("USER")	// USER 권한을 가진 사람만 접근 가능
			.requestMatchers("/admin/**").hasAnyRole("ADMIN")	// ADMIN 권한을 가진 사람만 접근 가능
			.anyRequest().authenticated();	// 그 외 페이지들은 모두 로그인 인증을 거쳐야 접근 가능하다
	
		// 인증되지 않은 사용자가 handling을 통해 직접 경로를 설정할 수 있다.
		// authenticationEntiryPoint 객체를 통해 CustomAuthenticationEntryPoint 객체를 이용하여 401 에러나 Redirect로 페이지를 강제 이동한다
		http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
	
		return http.build();
	}
	
}
