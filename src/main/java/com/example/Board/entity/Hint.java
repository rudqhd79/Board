package com.example.Board.entity;

import jakarta.persistence.Entity;
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
	
	private Long id;
	
	private String hintQ1;

}
