package com.example.Board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "hint")
@Getter
@Setter
@ToString
public class Hint {
	
	@Id
	@Column(name="hintId")
	private Long id;
	
	private String hintQ1;
	
	private String hintQ2;
	
	private String hintQ3;
	
	private String hintQ4;
	
	private String hintQ5;
	
	private String hintQ6;
	
	private String hintQ7;
	
	

}
