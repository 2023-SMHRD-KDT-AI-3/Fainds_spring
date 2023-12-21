package com.smhrd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tbl_Member {
	
	@Id
	private String user_id;
	
	@Column( length = 30,nullable =false )
	private String user_pw;
	
	private String user_name;
	
	private Date joined_at;
	
	private String user_email;
	
}
