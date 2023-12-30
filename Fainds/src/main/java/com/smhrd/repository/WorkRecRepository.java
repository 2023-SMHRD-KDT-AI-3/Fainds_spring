package com.smhrd.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.smhrd.entity.Tbl_WorkRec;

@Repository
public interface WorkRecRepository extends JpaRepository<Tbl_WorkRec, Integer> {
	
	
	 @Query(value = "SELECT * from tbl_work_rec where work_user_user_id = :workUser", nativeQuery = true)
	 List<Tbl_WorkRec> findByworkUser(@Param("workUser") String workUser);

}
