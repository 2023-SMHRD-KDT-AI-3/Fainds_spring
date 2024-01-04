package com.smhrd.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smhrd.entity.MongoDBModel;

public interface MongoDBRepository extends MongoRepository<MongoDBModel, String> {
	MongoDBModel findByUserid(String userid);
	List<MongoDBModel> findAllByUserid(String userid);
}
