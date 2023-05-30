package com.example.Board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table(name="postImg")
@ToString
@Entity
public class PostImg {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="postImgId")
	private Long id;
	
	@JoinColumn(name="postId")
	@ManyToOne(fetch = FetchType.LAZY)
	private Post post;
	
	private String postImgOriginalName;
	
	private String postImgLocation;
	
	private String postImgName;
	
}
