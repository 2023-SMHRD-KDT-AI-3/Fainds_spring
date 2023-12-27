package com.smhrd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Tbl_Board;
import com.smhrd.entity.Tbl_User;

@Repository
public interface MemberRepository extends JpaRepository<Tbl_User, String>{

	Tbl_User findByUserIdAndUserPw(String userId, String userPw);
	Tbl_User saveByCurrentPwAndNewPw(String currentPw, String newPw);
	Tbl_User saveByCurrentEmailAndNewEmail(String currentEmail, String newEmail);

	
}
