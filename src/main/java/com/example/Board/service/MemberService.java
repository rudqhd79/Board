package com.example.Board.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.Board.entity.Member;
import com.example.Board.repository.MemberRepository;

@Service
public class MemberService {
	
	private final MemberRepository memberRepository = null;
	
	public UserDetails loadUserByUserName(String userName) {
		Member member = memberRepository.findByUserId(userName);
		
		return User.builder().username(member.getUserId()).password(member.getPassword())
				.roles(member.getRole().toString()).build();
	}
	
	// 회원가입 중복이 아니면 repository를 통해 DB로 insert
	public Member saveMember(Member member) {
		try {
			validMember(member);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return memberRepository.save(member);
	}
	
	// 회원가입 시 가입된 회원인지 판별
	public void validMember(Member member) throws IllegalAccessException {
		Member findMember = memberRepository.findByUserId(member.getUserId());
		if (findMember != null) {
			throw new IllegalAccessException("이미 가입된 회원입니다.");
		}
	}

}
