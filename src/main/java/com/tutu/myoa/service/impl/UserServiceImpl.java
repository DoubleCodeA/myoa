package com.tutu.myoa.service.impl;

import com.tutu.myoa.dao.UserDAO;
import com.tutu.myoa.pojo.User;
import com.tutu.myoa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> optional = userDAO.findById(id);
        return optional.get();
    }

    @Override
    public void update(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            userDAO.deleteById(id);
        }
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }
}
