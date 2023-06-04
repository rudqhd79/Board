package com.example.Board.dto;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;

import com.example.Board.entity.Board;
import com.example.Board.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
	
	private Long id;
	
	private Member member;
	
	private String title;
	
	private int views;
	
	private LocalDateTime regTime;
	
	private LocalDateTime updateTime;

	private static ModelMapper modelMapper = new ModelMapper();
	
	public Board createBoard() {
		return modelMapper.map(this, Board.class);
	}
	
	public static BoardDto of(Board board) {
		return modelMapper.map(board, BoardDto.class);
	}
	
}
