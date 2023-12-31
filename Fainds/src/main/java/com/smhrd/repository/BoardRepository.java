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

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE tbl_board SET board_title= :boardTitle, board_content= :boardContent WHERE board_seq= :boardSeq", nativeQuery = true)
	void boardEdit(@Param("boardTitle") String boardTitle, @Param("boardContent") String boardContent, @Param("boardSeq") String boardSeq);
	 
	@Query(value = "SELECT * from tbl_board where board_title LIKE %:keyword%", nativeQuery = true)
	List<Tbl_Board> keywordsearch(@Param("keyword") String keyword);


	@Transactional
	@Modifying
	@Query(value = "delete from tbl_board where board_seq = :boardSeqId", nativeQuery = true)
	void boardDelete(@Param("boardSeqId") String boardSeqId);

	
}
