package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.smhrd.entity.MongoDBModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/mongo")
public class MongoDBController {
	Gson gson = new Gson();

    @Autowired
    MongoDBService mongoDBService;

    @GetMapping(value = "/find")
    public String findUserData(@RequestParam String Userid) {
        return mongoDBService.selectUser(Userid);
    }

    @RequestMapping(value = "/mongoinsert")
    public String saveUserData(MongoDBModel mongomodel) {
    	System.out.println(mongomodel.getUserid());
    	System.out.println(mongomodel.getUrl());
    	System.out.println(mongomodel.getResdata());
//        log.info("[Controller][Recv] name : {}, age : {}", name, age);
        mongoDBService.saveUser(mongomodel);
//        String res = mongoDBTestService.selectUser("1");
//        System.out.println(res);
//        JsonObject jsonObject = gson.fromJson(res, JsonObject.class);
//        System.out.println(jsonObject.get("resdata"));
        return ("success!");
//        return mongoDBTestService.selectUser(name);
    }
    
    @RequestMapping(value = "/findall")
    public List<MongoDBModel> findAllUserData(@RequestParam String userid) {
    	System.out.println(mongoDBService.selectAllUser(userid));
    	List<MongoDBModel> list = mongoDBService.selectAllUser(userid);
    	return list;
    }
    
    @RequestMapping(value = "/deleteid")
    public String deletedata(@RequestParam String userid) {
    	mongoDBService.deleteUser(userid);
    	return ("delete success!");
    }
    
}