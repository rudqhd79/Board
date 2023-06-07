package com.example.Board.dto;

import com.example.Board.entity.Post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostImgDto {

	private Long id;
	
	private Post post;
	
	private String postImgOriginalName;
	
	private String postImgLocation;
	
	private String postImgName;
	
}
