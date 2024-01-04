package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smhrd.entity.Tbl_Cmt;
import com.smhrd.repository.BoardRepository;
import com.smhrd.repository.ComentRepository;

@Controller
public class ComentController {

	
	@Autowired
	private ComentRepository repo;
	
	@Autowired
	private BoardRepository boardrepo;
	
	@RequestMapping("/cmtwrite")
	@ResponseBody
	public int cmtwrite(@RequestBody Tbl_Cmt cmt) {
		
		repo.save(cmt);
		
		 int result = repo.countByBoardSeqId(cmt.getBoardSeqId());
		 
		 int result2 = cmt.getBoardSeqId();
		 boardrepo.cmtupdate(result,result2);
		return result;
	}
	
	
	@RequestMapping("/cmtlist")
	@ResponseBody
	public List<Tbl_Cmt> cmtlist(String boardSeqId) {
				
		List<Tbl_Cmt> result =repo.cmtlist(boardSeqId);	
		return result;
	}
	
//	@RequestMapping("/cmtlist")
//	@ResponseBody
//	public List<Tbl_Cmt> cmtlist(Tbl_Cmt cmt){
//		
//		System.out.println("getCmtUser1가 왜 안와 : "+cmt.getCmtUser1());
//		List<Tbl_Cmt> result = repo.cmtlist(cmt.getBoardSeqId());
//		
//		return result;
//	}
	
	
}
