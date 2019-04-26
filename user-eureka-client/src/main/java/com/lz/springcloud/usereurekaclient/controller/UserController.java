package com.lz.springcloud.usereurekaclient.controller;


import com.lz.springcloud.usereurekaclient.dao.UserDao;
import com.lz.springcloud.usereurekaclient.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        User user = userDao.getUserById(id);
         return user;
    }
    @GetMapping("/hello")
    public String getHello(){
        return "hello,user-provider";
    }


}
