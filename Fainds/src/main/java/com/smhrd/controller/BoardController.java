package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smhrd.dto.BoardDTO;
import com.smhrd.entity.Tbl_Board;
import com.smhrd.repository.BoardRepository;

@Controller
public class BoardController {

	
	@Autowired
	private BoardRepository repo;
	
	//게시판 저장 기능
	@RequestMapping("/boardwrite")
	@ResponseBody
	public String boardwrite(Tbl_Board board) {
		
		
		repo.save(board);		
							
		return null;
	}
	
	// 게시판 수정 기능
	@RequestMapping("/boardedit")
	@ResponseBody
	public void boardEdit(String title, String content, String boardSeq) {
		
		repo.boardedit(title, content, boardSeq);
		System.out.println("boardSeq : " + boardSeq);
	
	}
	
	@RequestMapping("/board")
	@ResponseBody
	public List<Tbl_Board> board(Tbl_Board board) {
		
		
		List<Tbl_Board> result =repo.findAll(Sort.by(Sort.Direction.DESC,"boardSeq"));
		System.out.println("여기에 뭐가 들었어 ? "+result);
		
		return result;
	}
	
	
	
	@RequestMapping("/boardSearch")
	@ResponseBody
	public List<Tbl_Board> boardSearch(String keyword){
		List<Tbl_Board> result =repo.keywordsearch(keyword);
		System.out.println("boardSearch : " + keyword);
		
		return result;
		
	}
	
	
	
}
