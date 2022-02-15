package com.practice.mongo.dao;

import com.practice.mongo.controller.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDataMongo extends MongoRepository<User, Long> {
}
