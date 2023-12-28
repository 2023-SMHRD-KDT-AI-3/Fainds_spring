package com.smhrd.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	@Autowired
    private S3Uploader s3Uploader;
	
	
	
	
	@RequestMapping("/join")
	public String join(Tbl_User user) {
		System.out.println("user : " + user);
		Tbl_User result =new Tbl_User();
		
		
		repo.save(user);
		
		System.out.println("result="+result);
		
		return "성공";
	}
	
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
	@RequestMapping("/getimg")
	@ResponseBody
	public String getimg(@RequestParam("image") MultipartFile file) {
		String res = "failed";
        try {
            byte[] bytes = file.getBytes();
            // 이제 'bytes'를 사용하여 이미지 처리를 할 수 있습니다.
            // 필요한 경우 BufferedImage로 변환할 수도 있습니다.
            System.out.println("성공!!");
            String originFilename = file.getOriginalFilename();
            System.out.println(originFilename);
            res = s3Uploader.saveFile(file);
            System.out.println(res);
            //return ResponseEntity.ok("Image uploaded successfully");
            
        } catch (IOException e) {
        	System.out.println("실패...");
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in image upload");
        }
        return res;
	}
	@RequestMapping("/chemail")
	@ResponseBody
	public String chemail(String currentEmail, String newEmail) {
		
		System.out.println(currentEmail);
		System.out.println(newEmail);
		
		int result =repo.chemail(currentEmail, newEmail);
		
		return "성공";
	}
	
	@RequestMapping("/settingemail")
	@ResponseBody
	public String settingemail(String userId) {
		
		String useremail = repo.settingemail(userId);
			System.out.println(useremail);
		
		return useremail;
	}
}
