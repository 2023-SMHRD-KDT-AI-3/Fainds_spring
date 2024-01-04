package com.smhrd.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.JsonObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "user")
public class MongoDBModel {

	@Id
	private String id;
	
	private String userid;
	private String url;
	private String resdata;
	private String registername;
}
