package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smhrd.entity.Tbl_User;
import com.smhrd.entity.Tbl_WorkRec;
import com.smhrd.repository.WorkRecRepository;

@Controller
public class WorkRecController {
	
	@Autowired
	private WorkRecRepository repo;
	
	@RequestMapping("/regiSalary")
	@ResponseBody
	public String regiSalary(Tbl_WorkRec work){
		
		String startedAt = work.getStartedAt();
		String endedAt = work.getEndedAt();
		String workday =work.getWorkDay();
		int workPay = work.getWorkPay();
		Tbl_User workUser = work.getWorkUser();
		 
		repo.insertsal(startedAt,endedAt,workday,workPay,workUser);
		return "성공";
		
	}
	
	@RequestMapping("/calenderInfo")
	@ResponseBody
	public List<Tbl_WorkRec> calenderInfo(String workUser){
		
		List<Tbl_WorkRec> result = repo.findByworkUser(workUser);
		
		return result;
	}
	
	@RequestMapping("/updatesal")
	@ResponseBody
	public void updatesal(Tbl_WorkRec work) {
		
		String startedAt = work.getStartedAt();
		String endedAt = work.getEndedAt();
		String workday =work.getWorkDay();
		int workPay = work.getWorkPay();
		Tbl_User workUser = work.getWorkUser();
		
		repo.updatesal(startedAt,endedAt,workday,workPay,workUser);
		
	}
	
	@RequestMapping("/deletesal")
	@ResponseBody
	public void deletesal(String workSeq) {
		
		
		repo.deletesal(workSeq);
		
		
	}
	
	
}
