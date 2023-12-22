package com.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
