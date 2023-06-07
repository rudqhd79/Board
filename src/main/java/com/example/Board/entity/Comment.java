package com.example.Board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="comment")
public class Comment extends DateEntity {
	
	@Id
	@Column(name="commentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(name="memberId")
	@ManyToOne(fetch = FetchType.LAZY)
	private Member member;
	
	@JoinColumn(name = "postId")
	@ManyToOne(fetch = FetchType.LAZY)
	private Post post;
	
	@Column(nullable = false, columnDefinition = "LONGTEXT")
	private String commentDetail;
	
	
	
}
