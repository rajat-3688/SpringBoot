package com.practice.mysql.dao;


//import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import com.practice.mysql.controller.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataDao extends JpaRepository<User, Long>{

}
