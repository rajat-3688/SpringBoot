package com.practice.mysql.controller;


import com.practice.mysql.dao.UserDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userdata")
public class UserController {
    private ArrayList<User> users = new ArrayList<>();

    @Autowired
    private UserDataDao userDataDao;

    public UserController(){
        users.add(new User(1, "Rob OLeary", 21));
        users.add(new User(2, "Angela Merkel", 20));
        users.add(new User(3, "Tamer Osman", 20));
    }


    //@ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<User> getAllUsers() {
        return userDataDao.findAll();
        //return users;

    }
    //@ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public ResponseEntity getUsersList(@PathVariable("id") long id) {
        User userFound = null;

       /* for(User user: users){
            if(user.getId() == id){
                userFound = user;
                break;
            }
        }*/
        userFound = userDataDao.getById(id);
        if(userFound == null) {
            return new ResponseEntity(userFound, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(userFound, HttpStatus.OK);
    }
    @PostMapping(value="/adduser")
    public ResponseEntity addUser(@RequestBody User user) {
        //users.add(user);
        userDataDao.save(user);
        return new ResponseEntity(HttpStatus.CREATED);

    }
    @PutMapping(value="updateuser")
    public ResponseEntity updateUser(@RequestBody User u){
        boolean found = false;
        /*for(User user : users) {
            if(user.getId() == u.getId())
            {
                user.setAge(u.getAge());
                user.setName(u.getName());
                found = true;
                break;
            }
        }*/
        userDataDao.save(u);
        if(found) {
           return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
