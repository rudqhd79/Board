package com.Board.entity;

import groovy.transform.ToString;
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

@Getter
@Setter
@ToString
@Entity
public class ProfileImg extends RegistDate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "profileImg_id")
	private Long id;	// 프로필 이미지 식별자
	private String pro_ori_img_name;		// 원본 프로필 이미지 이름
	private String pro_use_img_name;	// 사용할 프로필 이미지 이름
	private String pro_img_path;			// 경로 프로필 이미지
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="member_id")
	private Member member;
	
	public void updateProfileImg(String pro_ori_img_name, String pro_use_img_name, String pro_img_path) {
		this.pro_ori_img_name = pro_ori_img_name;
		this.pro_use_img_name = pro_use_img_name;
		this.pro_img_path = pro_img_path;
	}
}
