package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
	
	@RequestMapping("/board")
	@ResponseBody
	public List<Tbl_Board> board(Tbl_Board board) {
		
		
		List<Tbl_Board> result =repo.findAll();
		System.out.println("board :"+result);
		
		return result;
	}
	
	
}
