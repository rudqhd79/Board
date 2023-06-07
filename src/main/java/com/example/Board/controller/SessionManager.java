package com.example.Board.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*세션의 동작 방식

클라이언트가 서버에 접속 시 세션 ID를 발급 받음
클라이언트는 세션 ID에 대해 쿠키를 사용해서 저장하고 가지고 있음
클라리언트는 서버에 요청할 때, 이 쿠키의 세션 ID를 같이 서버에 전달해서 요청
서버는 세션 ID를 전달 받아서 별다른 작업없이 세션 ID로 세션에 있는 클라언트 정보를 가져와서 사용
클라이언트 정보를 가지고 서버 요청을 처리하여 클라이언트에게 응답*/

@Component	// @Component는 부품 (독립적인 단위 모듈)
public class SessionManager {
	
	// 쿠키 특징 (아이디 저장 기능)
	// 세션 특징 (로그인 유지 기능)
	
	public static final String SESSION_COOKIE_NAME = "mySessionId";
	// ConcurrentHashMap은 Thread Hash Map이다
	private Map<String, Object> sessionStore = new ConcurrentHashMap<>();
	
	public void createSession(Object value, HttpServletResponse response) {
		//UUID로 랜덤하게 세션 아이디를 만듦
		String sessionId = UUID.randomUUID().toString();
		//쿠키 생성
		Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
		// 응답부에 쿠키 전달
		response.addCookie(mySessionCookie);
	}
	// 쿠키 인증
	private Cookie findCookie(HttpServletRequest request, String cookieName) {
		if (request.getCookies() == null) {
			return null;
		}
		return Arrays.stream(request.getCookies())
				.filter(cookie -> cookie.getName().equals(cookieName))
				.findAny()
				.orElse(null);
	}
	// 인증된 쿠키로 세션 얻기
	public Object getSession(HttpServletRequest request) {
		Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
		if (sessionCookie == null) {
			return null;
		}
		return sessionStore.get(sessionCookie.getValue());
	}
	// 쿠키 없애기
	public void expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie != null) {
            sessionStore.remove(sessionCookie.getValue());
        }
    }
	

}
