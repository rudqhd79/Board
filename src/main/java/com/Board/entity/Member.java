package com.Board.entity;

import groovy.transform.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.Board.constant.MemberRole;

@Entity
@Getter
@Setter
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id; // 회원 식별자
    private String name; // 회원 실명
    private String nickName; // 회원 닉네임
    private String password; // 회원 로그인 비밀번호
    private String memberId; // 회원 로그인 아이디
    private String email; // 회원 이메일
    private String phone; // 회원 전화번호
    private String hintA; // 회원 힌트에 대한 답변
    
    @Enumerated(EnumType.STRING)
    private MemberRole role;	// 권한s

    // mappedBy는 해당 객체의 관계도 주인의 entity에 생성한다
    @OneToMany(mappedBy = "member")
    private List<Hint> hints; // 회원의 힌트 리스트
    
    @OneToMany(mappedBy = "member")
    private List<ProfileImg> pro_imgs;
    
    @OneToMany(mappedBy = "member")
    private List<Board> boards;
    
    @OneToMany(mappedBy = "member")
    private List<Comment> comments;

}
