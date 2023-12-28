package com.smhrd.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Tbl_Board;

@Repository
public interface BoardRepository extends JpaRepository<Tbl_Board, String>{

	public Tbl_Board findByBoardSeq(int Boardseq);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE tbl_board SET board_cmt_num = :result WHERE board_seq = :result2", nativeQuery = true)
	int cmtupdate(@Param("result") int result, @Param("result2") int result2);
	
}
