package com.smhrd.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Tbl_Board;
import com.smhrd.entity.Tbl_User;

@Repository
public interface MemberRepository extends JpaRepository<Tbl_User, String>{


	Tbl_User findByUserIdAndUserPw(String userId, String userPw);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE tbl_user SET user_email = :newEmail WHERE user_email = :currentEmail", nativeQuery = true)
	int chemail(@Param("currentEmail") String currentEmail, @Param("newEmail") String newEmail);
	

	@Query(value = "SELECT user_email from tbl_user where user_id = :userId", nativeQuery = true)
	String settingemail(@Param("userId") String userId);
	

	@Transactional
	@Modifying
	@Query(value = "UPDATE tbl_user SET user_pw = :newPw WHERE user_Pw = :currentPw", nativeQuery = true)
	int chepw(@Param("currentPw") String currentPw, @Param("newPw") String newPw);
	
	//여기 insert
	@Transactional
	@Modifying
	@Query(value = "insert into tbl_user(user_id,user_email,user_name,user_pw) values (:userId,:userEmail,:userName,:userPw)", nativeQuery = true)
	int join(@Param("userId") String userId,@Param("userEmail") String userEmail,@Param("userName") String userName,@Param("userPw") String userPw);
	
}
