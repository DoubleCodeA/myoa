package com.tutu.myoa.dao;

import com.tutu.myoa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {

}
