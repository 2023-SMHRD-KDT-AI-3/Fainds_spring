package com.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		 System.out.println("result : "+result);
		 int result2 = cmt.getBoardSeqId();
		 boardrepo.cmtupdate(result,result2);
		return result;
	}
}
