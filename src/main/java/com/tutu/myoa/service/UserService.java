package com.tutu.myoa.service;

import com.tutu.myoa.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> findAll();

    User findById(Integer id);

    void update (User user);

    void delete (Integer[] ids);

    void save(User user);
}
