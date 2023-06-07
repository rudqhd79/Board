package com.example.Board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Board.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Member findByUserId(String userId);
	
}
