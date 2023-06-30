package com.Board.service;

import org.springframework.stereotype.Service;

import com.Board.entity.Member;
import com.Board.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	public Member save (Member member) {
		validateDuplication(member);
		return memberRepository.save(member);
	}
	
	private void validateDuplication(Member member) {
		Member findMember = memberRepository.findByLoginId(member.getLoginId());
		if (findMember != null) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}
	
}
