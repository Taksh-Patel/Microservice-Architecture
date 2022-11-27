package com.sa.register;

import com.sa.register.model.User;
import com.sa.register.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/check")
    public String registerCheck(){
        return "check register!";
    }

    @RequestMapping("/register-user/{userName}/{password}")
    public String registerUser(@PathVariable("userName") String userName,
                               @PathVariable("password") String password){
        System.out.println("-----In register microservice from login microservice start");

        User u=new User();
        u.setId((int)(new Date().getTime()));
        u.setName(userName);
        u.setPassword(password);
        userRepo.save(u);
        System.out.println("-----In register microservice from login microservice end");

        return "Successfully Registered !!!";
    }
}
