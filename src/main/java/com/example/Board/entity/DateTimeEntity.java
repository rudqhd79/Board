package com.example.Board.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter
@Setter
public class DateTimeEntity {

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime regTime;	//java에서 제공하는 현재시간 객체
	
	@LastModifiedDate
	private LocalDateTime updateTime;
	
}
