package com.smhrd.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Tbl_Cmt;

@Repository
public interface ComentRepository extends JpaRepository<Tbl_Cmt, Long> {



	int countByBoardSeqId(int boardSeqId);
	

	 @Query(value = "SELECT * from tbl_cmt where board_seq_id = :boardSeqId", nativeQuery = true)
	 List<Tbl_Cmt> cmtlist(@Param("boardSeqId") String boardSeqId);

	 

	

	

	

	

	 

	

}
