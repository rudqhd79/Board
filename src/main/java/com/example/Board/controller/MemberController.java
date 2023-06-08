package com.example.Board.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Board.constant.Role;
import com.example.Board.dto.MemberDto;
import com.example.Board.entity.Member;
import com.example.Board.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class MemberController {
	
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;

	// 로그인 페이지
	@GetMapping(value = "login")
	public String login() {
		return "login";
	}
	
	// 로그인 실패했을 때
	@GetMapping(value = "login/fail")
	public String loginFail(Model model) {
		model.addAttribute("fail", "아이디 또는 비밀번호를 확인해주세요.");
		return "login";
	}
	
	// 회원가입
	@GetMapping(value = "join")
	public String join(Model model) {
		model.addAttribute("memberDto", new MemberDto());
		return "join";
	}
	
	// 회원가입 버튼
	@PostMapping(value = "join/new")
	public String joinNew(@Valid MemberDto memberDto, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "join";
		}
		try {
			Member member = Member.createMember(memberDto, passwordEncoder, Role.USER, null, null);
			memberService.saveMember(member);
			model.addAttribute("errorMsg", "회원가입에 실패했습니다");
		} catch (Exception e) {
			
		}
		return "redirect:/main";
	}
	
	
	
}
