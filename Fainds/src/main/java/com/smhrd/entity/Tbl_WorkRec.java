package com.smhrd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tbl_WorkRec {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_Increment
	   private int workSeq;
	   
	   
	   private Date startedAt;
	   
	   
	   private Date endedAt;
	   
	   
	   @ManyToOne // 현재 테이블 기준
	   @JoinColumn(referencedColumnName = "userId") // FK 지정(Tbl_user의 user_id 참조)
	   private Tbl_User workUser;
	   
	   
	   @Column(insertable = false, nullable = false, columnDefinition = "int default 0")
	   private int workPay;
	   
	   
	   private Date workDay;
}
