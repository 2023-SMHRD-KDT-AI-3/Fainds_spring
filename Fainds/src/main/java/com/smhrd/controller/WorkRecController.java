package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smhrd.entity.Tbl_WorkRec;
import com.smhrd.repository.WorkRecRepository;

@Controller
public class WorkRecController {
	
	@Autowired
	private WorkRecRepository repo;
	
	@RequestMapping("/regiSalary")
	@ResponseBody
	public String regiSalary(Tbl_WorkRec work){
		
		System.out.println("sal에 뭐가 있지"+work);
		
		 repo.save(work);
		
		return "성공";
		
	}
	
	@RequestMapping("/calenderInfo")
	@ResponseBody
	public List<Tbl_WorkRec> calenderInfo(String workUser){
		
		List<Tbl_WorkRec> result = repo.findByworkUser(workUser);
		
		return result;
	}
	
	
}
