package com.smhrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Tbl_Cmt;

@Repository
public interface ComentRepository extends JpaRepository<Tbl_Cmt, Long> {

	

	

	int countByBoardSeqId(int boardSeqId);

	

	

	

	 

	

}
