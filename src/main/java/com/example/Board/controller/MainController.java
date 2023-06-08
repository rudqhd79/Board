package com.example.Board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Board.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor	// 필드나 final 변수들의 생성자를 자동으로 생성해주는 어노테이션이다
public class MainController {
	
	private final MemberService memberService;
	
	@GetMapping(value = "/main")
	public String mainPage() {
		return "main";
	}
}
