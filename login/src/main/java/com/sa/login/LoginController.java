package com.sa.login;

import com.sa.login.model.User;
import com.sa.login.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Controller
public class LoginController {
    @Autowired
    private UserRepo userRepo;
    RestTemplate restTemplate = new RestTemplate();
    @RequestMapping("/")
    public String checkMVC(){
        return "login";
    }

    @RequestMapping("/login")
    public String loginHomePage(@RequestParam("userName") String userName,
                                @RequestParam("password") String password, Model model) {
        User u=null;
        try {
            u = userRepo.findAllByName(userName);
        } catch (Exception e) {
            System.out.println("User Not Found!!!");
        }
        if (u != null) {
            if(!u.getPassword().equals(password)){
                model.addAttribute("passwordError","Wrong Password");
                return "login";
            }
            model.addAttribute("UserName", userName);
            return "homePage";
        }
        model.addAttribute("error","User Not Found, Kindly Register!!!");
        return "login";
    }

    @RequestMapping("/register")
    public String goToRegistrationPage(){
        return "register";
    }

    @RequestMapping("/set-user")
    public String goToRegisterMicroservice(@RequestParam("userName") String userName,
                                           @RequestParam("password1") String password1,
                                           @RequestParam("password2") String password2,
                                           Model model){
        System.out.println("-----going to register microservice from login microservice start");
        if(password1.equals(password2)){
            restTemplate.getForObject("http://localhost:8081/register-user/"+userName+"/"+password1, String.class);
            model.addAttribute("registerSuccess","Successfully Registered, kindly login to continue!!");
        }
        else{
            model.addAttribute("registrationError","Password Not Same!!!");
            return "register";
        }
        System.out.println("-----going to register microservice from login microservice end");
        return "login";
    }

    @RequestMapping("/forgot_password")
    public String goToForgotPasswordPage(){
        return "forgotPassword";
    }

    @RequestMapping("/update-user")
    public String goToForgotPasswordMicroservice(@RequestParam("userName") String userName,
                                           @RequestParam("password1") String password1,
                                           @RequestParam("password2") String password2,
                                           Model model){
        System.out.println("-----going to forgot password microservice from login microservice start");
        if(password1.equals(password2)){
            restTemplate.getForObject("http://localhost:8082/forgot-password/"+userName+"/"+password1, String.class);
            model.addAttribute("forgotPasswordSuccess","Successfully Updated Password, kindly login to continue!!");
        }
        else{
            model.addAttribute("forgotPasswordError","Password Not Same!!!");
            return "forgotPassword";
        }
        System.out.println("-----going to forgot password microservice from login microservice end");
        return "login";
    }
}
