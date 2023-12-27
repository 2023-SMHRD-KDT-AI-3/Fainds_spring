package com.smhrd.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tbl_User {
	

	   @Id
	   @Column(length = 30)
	   private String userId;
	   
	   
	   @Column(length = 30, nullable = false)
	   private String userPw;
	   
	   
	   @Column(length = 40, nullable = false)
	   private String userName;
	   
	   
	   @Column(updatable = false, insertable = false, columnDefinition = "datetime default now()")
	   private Date joinedAt;
	   
	   
	   @Column(length = 50, nullable = false)
	   private String userEmail;
	   

	   
	   

	   // 회원(이메일) 1 <-----------> N 게시글(작성자)
	   @OneToMany(mappedBy = "boardUser") // 1대 다 관계, mappedBy에 연결할 컬럼 지정
	   
	   @JsonManagedReference
	   private List<Tbl_Board> board; // List<연결된 테이블의 자료형>
	   
	   
	   // 회원(이메일) 1 <-----------> N 게시글(작성자)
	   @OneToMany(mappedBy = "cmtUser") // 1대 다 관계, mappedBy에 연결할 컬럼 지정
	   private List<Tbl_Cmt> cmt; // List<연결된 테이블의 자료형>
	   
	   // 회원(이메일) 1 <-----------> N 게시글(작성자)
	   @OneToMany(mappedBy = "workUser") // 1대 다 관계, mappedBy에 연결할 컬럼 지정
	   private List<Tbl_WorkRec> workRec; // List<연결된 테이블의 자료형>

	   // 에러방지
	   // JPA에 FK를 사용할 때 toString메소드에서 overflow가 발생 --> toString메소드 선언
	   @Override
	   public String toString() {
	      return "Tbl_User";
	   }
}
