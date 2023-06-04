package com.example.Board.dto;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.Board.entity.Hint;
import com.example.Board.entity.Member;
import com.example.Board.entity.Profile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

	private Long id;
	
	private Hint hint;
	
	private Profile profile;
	
	@NotEmpty(message = "이름을 입력해주세요.")
	@Size(min = 1, max = 15, message = "이름은 1자 ~ 15자 입니다.")
	private String memberName;
	
	private String memberNickName;

	@Length(min = 8, max = 16, message = "비밀번호는 8자~ 16자 입니다.")
	private String password;
	
	@NotEmpty(message = "아이디를 입력해주세요.")
	private String memberId;
	
	@NotEmpty(message = "전화번호를 입력해주세요.")
	@Length(min = 13, max = 13, message = "-포합 13자리를 입력해주세요.")
	@Pattern(regexp = "^(010|011|016|017|018|019)[-]?\\d{3,4}[-]?\\d{4}$", message = "전화번호를 형식에 맞게 입력해 주세요")
	private String phoneNumber;
	
	@NotEmpty(message = "이메일을 입력해주세요.")
	private String email;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Member createMemberProfile() {
		return modelMapper.map(this, Member.class);
	}
	
	public MemberDto of (Member member) {
		return modelMapper.map(member, MemberDto.class);
	}
	
	public Member updateMemberInfo(Member member, PasswordEncoder passwordEncoder) {
		member.setPassword(passwordEncoder.encode(this.password));
		return member;
	}
	
}
