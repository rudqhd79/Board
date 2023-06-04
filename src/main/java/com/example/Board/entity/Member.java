package com.example.Board.entity;

import org.hibernate.bytecode.internal.bytebuddy.PassThroughInterceptor;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.Board.constant.Role;
import com.example.Board.dto.MemberDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "member")
@ToString
public class Member {
	
	@Id
	@Column(name = "memberId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 25, nullable = false)
	private String memberName;
	
	@Column(length = 50, nullable = false, unique = true)
	private String memberNickName;
	
	@Column(nullable = false)
	private String password;
	
	@Column (nullable = false, length = 25, unique = true)
	private String memberId;
	
	@Column (nullable = false, length = 50)
	private String email;
	
	@Column (nullable = false, length = 13, unique = true)
	private String phoneNumber;

	//	권한 (유저, 관리자)
	@Enumerated (EnumType.STRING)
	private Role role;
	
//	힌트 식별자
	@OneToOne
	private Hint hint;
	
	//프로필 식별자 (한명의 회원은 여러개의 프로필이미지를 갖는다)
	@OneToMany
	private Profile profile;
	
	public static Member createMember (MemberDto memberDto, PasswordEncoder passwordEncoder, Role role, Hint hint, Profile profile) {
		Member member = new Member();
		member.setMemberId(memberDto.getMemberId());
		member.setMemberName(memberDto.getMemberName());
		member.setMemberNickName(memberDto.getMemberNickName());
		member.setPhoneNumber(memberDto.getPhoneNumber());
		member.setEmail(memberDto.getEmail());
		member.setHint(hint);
		member.setProfile(profile);
		member.setRole(role);
		
		String password = passwordEncoder.encode(memberDto.getPassword());
		member.setPassword(password);
		
		return member;
	}
	
}
