package com.example.Board.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		// 401에러 (에러 발생시키기)
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		
		// Redirect처럼 경로를 무조건 /main으로 보냄
		response.sendRedirect("/main");
	}

}
