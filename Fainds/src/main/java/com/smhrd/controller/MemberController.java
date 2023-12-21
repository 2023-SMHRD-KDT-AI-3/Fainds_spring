package com.smhrd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.Tbl_Member;
import com.smhrd.mapper.MemberMapper;
import com.smhrd.repository.MemberRepository;

@Controller
public class MemberController {

	@Autowired
	// Mapper 구현하기!
	private MemberMapper mapper;
	
	@Autowired
	private MemberRepository repo;
	
	@RequestMapping("/test")
	public String test() {

		// consol창에 현재 시간을 출력
		// 1. mapper의 date메소드 불러와서 time에 저장
		String time = mapper.date();
		// 2. time 출력
		System.out.println(time);

		// 2)test.jsp로 이동하도록 만들자
		return "test";
	}
	@RequestMapping("/main")
	public String goMain() {

		return "main";
	}
	@RequestMapping("/join")
	public String join(Tbl_Member member) {
		// 1. 데이터 수집
		// 스프링이 넘어온 name값과 member 필드명과 같은 얘들 수집
		
	
		// 2. 기능 실행
		repo.save(member); 
		
		// 3. View 선택
		return "test";
	}
	
}
