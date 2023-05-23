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
@Table (name = "profile")
@Getter
@Setter
@ToString
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "profileId")
	private Long id;
	
	@Column (nullable = true)
	private String profileOriName;
	
	@Column (nullable = true)
	private String profileLocation;
	
	@Column (nullable = true)
	private String profileName;

}
