package com.example.Board.dto;

import lombok.Setter;

import com.example.Board.entity.Board;

import lombok.Getter;

@Getter
@Setter
public class PostDto {

	private Long id;
	
	private Board board;
	
	private String postDetail;
	
}
