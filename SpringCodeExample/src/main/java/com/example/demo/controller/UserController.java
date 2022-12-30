package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import com.example.demo.model.*;
@RestController
@RequestMapping("/User")
public class UserController {
    private User user = new User();
    //sign up us
    @PostMapping("/sign_up")
    public Response sign_up(@RequestBody Userregister user1)
    {
        Response responde = new Response();
        if(this.user.register(user1.getUsername(),user1.getEmail(), user1.getPassword()))
        {
            System.out.print("User Signed Up successfully");
            responde.setStatus(true);
            responde.setMessage("User Signed Up successfully");
        }
        else
        {
            System.out.print("User Signed Up failed");
            responde.setStatus(false);
            responde.setMessage("User Signed up failed Because you Enter Email or UserName already Exist");
        }
        return responde;
    }
    //sign in user
    @PostMapping("/sign_in")
    public Response sign_in(@RequestBody Login user1)
    {
        Response responde = new Response();
        if(this.user.login(user1.getEmail(),user1.getPassword()))
        {
            System.out.println("User logged in successfully");
            responde.setStatus(true);
            responde.setMessage("User logged in successfully");
        }
        else
        {
            System.out.println("Log in failed");
            responde.setStatus(false);
            responde.setMessage("User Sign in failed Because you Enter Email or Password is wrong");
        }
        return responde;
    }

    //list all services
    @GetMapping("/getallservices")
    public ArrayList<service> getalllservices()
    {
        System.out.println("in getAllServices ");
        return  this.user.getServices();
    }


    //list all discounts
    @GetMapping("/getalldiscounts")
    public ArrayList<String> getalldiscounts()
    {
        System.out.println("in getAllDiscounts ");
        return this.user.getDiscounts();
    }

    //use service
    @PostMapping("/Useservice")
    public Response use_Service(@RequestBody UseService user)
    {
        Response respone = new Response();
        if(this.user.pay(user.getId(),user.getMainServicesNumber(),user.getServiceTypeNumber()))
        {
            System.out.println("Service is Done Successfully");
            respone.setStatus(true);
            respone.setMessage("Service is Done Successfully");
        }
        else
        {
            System.out.println("Mission is Failed Because you don't have enough Money or Enter Wrong Id");
            respone.setStatus(false);
            respone.setMessage("Mission is Failed Because you don't have enough Money or Enter Wrong Id");
        }
        return  respone;
    }
}
