package com.example.Board.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.Board.constant.MemberRole;
import com.Board.dto.MemberDto;
import com.Board.entity.Member;
import com.Board.service.MemberService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
@Import(MemberService.class)
class MemberServiceTest {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	Member createMember() {
		MemberDto dto = new MemberDto();
		dto.setEmail("test@email.com");
		dto.setName("김테스트");
		dto.setNickName("테스터킴");
		dto.setLoginId("test");
		dto.setPhone("010-0000-0000");
		dto.setPassword("test1234");
		return Member.createMember(dto, passwordEncoder, MemberRole.USER);
	}
	
	@Test
	@Transactional
	void saveMember() {
		// given
		Member member = createMember();
		// when
		Member saveMember = memberService.save(member);
		// then
		assertEquals(member.getEmail(), saveMember.getEmail());
		assertEquals(member.getName(), saveMember.getName());
		assertEquals(member.getNickName(), saveMember.getNickName());
		assertEquals(member.getLoginId(), saveMember.getLoginId());
		assertEquals(member.getPhone(), saveMember.getPhone());
		assertEquals(member.getPassword(), saveMember.getPassword());
		assertEquals(member.getRole(), saveMember.getRole());
		fail("정보가 같지 않습니다.");
	}

}
