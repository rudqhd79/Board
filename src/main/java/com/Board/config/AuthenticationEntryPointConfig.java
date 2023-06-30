package com.Board.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 인증되지 않은 사용자를 담당하는 AuthenticationEntryPoint 객체를 이용하여 사용한다
public class AuthenticationEntryPointConfig implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// (401 에러, "에러메세지")
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		/* response.sendRedirect("/"); */
	}

}
