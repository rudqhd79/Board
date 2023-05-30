package com.example.Board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "board")
@Getter
@Setter
@ToString
public class Board extends DateEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "boardId")
	private Long id;
	
	@JoinColumn(name = "memberId")
	@ManyToOne(fetch = FetchType.LAZY)
	private Member member;
	
	
	@Column(length = 50, nullable = false)
	private String title;
	
	//Integer와 int의 차이점이 궁금해져서 찾아보니
	//int는 null로 초기화 불가능, 산술 연산이 가능
	//Integer는 (Boxing(int -> Integer로 변환), Unboxing(Integer -> int로 변환, 변환 할 때 Integer 변수명.intValue()로 변환하여 산술 연산 가능))
	//Unboxing이 이루어지지 않으면 산술 연산이 불가능, 대신 null 초기화 가능
	@Column(columnDefinition = "integer default 0", nullable = false)
	private int views;
	
}
