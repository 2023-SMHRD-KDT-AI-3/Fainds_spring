package com.smhrd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Tbl_Board;

@Repository
public interface BoardRepository extends JpaRepository<Tbl_Board, String>{

	public Tbl_Board findByBoardSeq(int Boardseq);
	
	
	
}
