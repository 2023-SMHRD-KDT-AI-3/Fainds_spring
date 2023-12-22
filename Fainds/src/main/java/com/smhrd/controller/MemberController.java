package com.smhrd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smhrd.entity.Tbl_Board;
import com.smhrd.entity.Tbl_User;
import com.smhrd.mapper.MemberMapper;
import com.smhrd.repository.MemberRepository;

@Controller
public class MemberController {

	@Autowired
	// Mapper 구현하기!
	private MemberMapper mapper;
	
	@Autowired
	private MemberRepository repo;
	
	
	//로그인 기능
	@RequestMapping("/login")
	@ResponseBody
	public boolean login(Tbl_User user) {
		boolean loginCheck = false;
		System.out.println(user);
		Tbl_User result =repo.findByUserIdAndUserPw(user.getUserId(),user.getUserPw());
		
		if(result != null) {
			loginCheck=true;
		}
		System.out.println("loginCheck="+loginCheck);
		
		
		return loginCheck;
	}
	
	
	@RequestMapping("/join")
	public String join(Tbl_User user) {
		System.out.println("user : " + user);
		Tbl_User result =new Tbl_User();
		
		
		repo.save(user);
		
		System.out.println("result="+result);
		
		return "성공";
	}
	
	
	
}
