package com.sa.forgot_password;

import com.sa.forgot_password.model.User;
import com.sa.forgot_password.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ForgotPasswordController {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/check")
    public String forgotPasswordCheck(){
        return "check forgot password";
    }

    @RequestMapping("/forgot-password/{userName}/{password}")
    public String registerUser(@PathVariable("userName") String userName,
                               @PathVariable("password") String password){
        System.out.println("-----In forgot password microservice from login microservice start");

        User u=null;
        u = userRepo.findAllByName(userName);
        u.setPassword(password);
        userRepo.save(u);
        System.out.println("-----In forgot password microservice from login microservice end");

        return "Successfully Changed Password !!!";
    }
}
