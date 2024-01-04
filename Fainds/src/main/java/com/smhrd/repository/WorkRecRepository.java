package com.smhrd.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Tbl_User;
import com.smhrd.entity.Tbl_WorkRec;

@Repository
public interface WorkRecRepository extends JpaRepository<Tbl_WorkRec, Integer> {
	
		// 날짜 순서대로 select 하기 
	    @Query(value = "SELECT * from tbl_work_rec where work_user_user_id = :workUser order by work_day asc", nativeQuery = true)
	    List<Tbl_WorkRec> findByworkUser(@Param("workUser") String workUser);

	    // 월급 등록
	 	@Transactional
		@Modifying
		@Query(value = "insert into tbl_work_rec(work_user_user_id,ended_at,started_at,work_day,work_pay) values (:workUser,:endedAt,:startedAt,:workDay,:workPay)", nativeQuery = true)
		int insertsal(@Param("startedAt") String startedAt,@Param("endedAt") String endedAt,@Param("workDay") String workDay,@Param("workPay") int workPay,@Param("workUser") Tbl_User workUser);
	 	
	 	// 월급 수정
	 	@Transactional
		@Modifying
		@Query(value = "update tbl_work_rec set started_at = :startedAt , ended_at = :endedAt , work_pay = :workPay where work_day = :workDay and work_user_user_id = :workUser", nativeQuery = true)
		int updatesal(@Param("startedAt") String startedAt,@Param("endedAt") String endedAt,@Param("workDay") String workDay,@Param("workPay") int workPay,@Param("workUser") Tbl_User workUser);
	 	
	 	// 월급 삭제 
	 	@Transactional
		@Modifying
		@Query(value = "delete from tbl_work_rec where work_seq = :workSeq", nativeQuery = true)
		int deletesal(@Param("workSeq") String workSeq);
	 	
	
}
