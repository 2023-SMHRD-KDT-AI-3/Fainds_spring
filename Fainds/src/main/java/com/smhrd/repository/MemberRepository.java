package com.smhrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Tbl_Member;

@Repository
public interface MemberRepository extends JpaRepository<Tbl_Member, String>{


	
}
