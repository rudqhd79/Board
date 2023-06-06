package com.example.Board.dto;

import com.example.Board.entity.Member;
import com.example.Board.entity.Post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

	private Long id;
	
	private String commentDetail;
	
	private Post post;
	
	private Member member;
	
}
