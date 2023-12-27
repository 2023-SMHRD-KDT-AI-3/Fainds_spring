package com.smhrd.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tbl_Board {
	   @Id
	   @Column(insertable = false, updatable = false)
	   @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_Increment
	   private int boardSeq;
	   
	   
	   @Column(length = 100, nullable = false)
	   private String boardTitle;
	   
	   
	   @Column(nullable = false)
	   private String boardContent;
	   
	   
	   @ManyToOne // 현재 테이블 기준
	   @JoinColumn(referencedColumnName = "userId") // FK 지정(Tbl_user의 user_id 참조)	   
	   @JsonBackReference
	   private Tbl_User boardUser;
	   
	   
	   @Column(insertable = false, nullable = false, columnDefinition = "int default 0")
	   private int boardViews;
	   
	   @Column(updatable = false, insertable = false, columnDefinition = "datetime default now()")
	   private Date createdAt;

	   @Column(columnDefinition = "int default 0")
	   private int boardCmtNum;
	   
	   
	   // 회원(이메일) 1 <-----------> N 게시글(작성자)
	   @OneToMany(mappedBy = "boardSeq") // 1대 다 관계, mappedBy에 연결할 컬럼 지정
	   private List<Tbl_Cmt> cmt; // List<연결된 테이블의 자료형>

	   // 에러방지
	   // JPA에 FK를 사용할 때 toString메소드에서 overflow가 발생 --> toString메소드 선언
	   @Override
	   public String toString() {
	      return "Tbl_Board";
	   }
}
