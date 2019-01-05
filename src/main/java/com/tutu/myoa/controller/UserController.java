package com.tutu.myoa.controller;

import com.tutu.myoa.pojo.User;
import com.tutu.myoa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @RequestMapping("/update")
    public void  update(@RequestBody User user){
        userService.update(user);
    }

    @RequestMapping("/delete")
    public void  delete(@RequestBody Integer[] ids){
        userService.delete(ids);
    }

    @RequestMapping("/save")
    public void  save(@RequestBody User user){
        userService.save(user);
    }
}
