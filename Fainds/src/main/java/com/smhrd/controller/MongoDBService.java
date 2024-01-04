package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.entity.MongoDBModel;
import com.smhrd.repository.MongoDBRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MongoDBService {

    @Autowired
    MongoDBRepository mongoDBRepository;

    public String selectUser(String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
        	System.out.println("here!");
            if (mongoDBRepository.findByUserid(name) == null) {
                log.info("[Service] user name : {} not exist!!", name);
                return String.format("user name : %s not exist!!", name);
            } else {
                return objectMapper.writeValueAsString(mongoDBRepository.findByUserid(name));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
    
    public List<MongoDBModel> selectAllUser(String name) {
    	List<MongoDBModel> mongotestvo = mongoDBRepository.findAllByUserid(name);
    	return mongotestvo;
    }

    public void saveUser(MongoDBModel mongoDBTestModel) {
    	
//        MongoDBTestModel mongoDBTestModel = new MongoDBTestModel();
//        mongoDBTestModel.setName(name);
//        mongoDBTestModel.setAge(age);
        System.out.println("saveUser!!!");
//        if (mongoDBTestRepository.findByUserid(mongoDBTestModel.getUserid()) != null) {
//            log.info("[Service][update] name is already exist!!");
//            System.out.println("maybe here!");
//            mongoDBTestModel.setId(mongoDBTestRepository.findByUserid(mongoDBTestModel.getUserid()).getId());
//        } else {
//            log.info("[Service][insert] New name received!!");
//        }
        
        mongoDBRepository.save(mongoDBTestModel);
    }
}