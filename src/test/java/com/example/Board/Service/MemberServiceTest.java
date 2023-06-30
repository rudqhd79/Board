package com.example.Board.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import com.Board.constant.MemberRole;
import com.Board.dto.MemberDto;
import com.Board.entity.Member;
import com.Board.repository.MemberRepository;
import com.Board.service.MemberService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class MemberServiceTest {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	Member createMember() {
		MemberDto dto = new MemberDto();
		return Member.createMember(dto, passwordEncoder, MemberRole.USER);
	}

}
