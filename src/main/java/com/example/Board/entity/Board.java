package com.example.Board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "board")
@Getter
@Setter
@ToString
public class Board {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "boardId")
	private Long id;
	
	private Member member;
	
}
