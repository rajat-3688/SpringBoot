package com.practice.mongo.controller;

import com.practice.mongo.dao.UserDataMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userdatamongo")
public class UserMongoController {

    @Autowired
    UserDataMongo dataMongoRepo;

    @GetMapping(value = "getallusers")
    public List<User> getAllUsers(){
        return dataMongoRepo.findAll();
    }

    @PostMapping(value = "addUser")
    public void addUser(@RequestBody User u){
        dataMongoRepo.save(u);
    }
}
