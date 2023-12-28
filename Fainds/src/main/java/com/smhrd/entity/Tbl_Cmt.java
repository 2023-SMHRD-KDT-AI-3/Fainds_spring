package com.smhrd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tbl_Cmt {
		@Id
	   @Column(insertable = false, updatable = false)
	   @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_Increment
	   private long cmtSeq;
	
	
	   @ManyToOne // 현재 테이블 기준
	   @JoinColumn(referencedColumnName = "userId") // FK 지정(Tbl_user의 user_id 참조)  
	   private Tbl_User cmtUser;
	   
	   
	   @ManyToOne // 현재 테이블 기준
	   @JoinColumn(referencedColumnName = "boardSeq")
	   // FK 지정(Tbl_board의 board_seq 참조)
	   private Tbl_Board boardSeq;
	   
	   
	   @Column(length = 1000, nullable = false)
	   private String cmtContent;
	   
	   
	   @Column(updatable = false, insertable = false, columnDefinition = "datetime default now()")
	   private Date createdAt;
	   
	   @Column(nullable = true) 
	    private int boardSeqId;
	   
	   
	   @Override
	   public String toString() {
	      return "Tbl_Cmt";
	   }
	   
	   
}
