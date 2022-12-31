package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import com.example.demo.model.*;
@RestController
@RequestMapping("/User")
public class UserController {
    private User user;
    //sign up us
    @PostMapping("/sign_up")
    public Response sign_up(@RequestBody Userregister user1)
    {
        user=new User();
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
        user=new User();
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
        user=new User();
        System.out.println("in getAllServices ");
        return  this.user.getServices();
    }


    //list all discounts
    @GetMapping("/getalldiscounts")
    public ArrayList<String> getalldiscounts()
    {
        user=new User();
        System.out.println("in getAllDiscounts ");
        return this.user.getDiscounts();
    }

    //use service
    @PostMapping("/Useservice")
    public Response use_Service(@RequestBody UseService user)
    {
        this.user=new User();
        Response respone = new Response();
        if(!(this.user.login(user.getEmail(), user.getPassword()))){
            System.out.println("Mission Failed Because you have wrong email or password");
            respone.setStatus(false);
            respone.setMessage("Mission Failed Because you have wrong email or password");
            return respone;
        }


        if(this.user.pay(user.getId()))
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

    @PostMapping("/search")
    public ArrayList<String> sign_in(@RequestBody searchData data)
    {
        this.user=new User();
        return user.search(data.getWord());
    }

    @PostMapping("/showWalletBalance")
    public Response showWalletBalance(@RequestBody Login user1)
    {
        Response respone=new Response();
        this.user=new User();
        if(user.login(user1.getEmail(),user1.getPassword())){
            System.out.println("ok user can see his money");
            respone.setStatus(true);
            respone.setMessage("your money:"+this.user.showCurrentBalance());
        }else {
            System.out.println("wrong, user can not see his money(wrong login data)");
            respone.setStatus(false);
            respone.setMessage("wrong user data or user does not exist");

        }
        return respone;
    }
    @PostMapping("/addtowallet")
    public Response add_money_to_wallet(@RequestBody addToWallet add)
    {
        Response respone=new Response();
        this.user=new User();
        if(!(this.user.login(add.getEmail(), add.getPassword()))){
            System.out.println("Mission Failed Because you have wrong email or password");
            respone.setStatus(false);
            respone.setMessage("Mission Failed Because you have wrong email or password");
            return respone;
        }
        if(user.addMoney(add.getCraditCardBalance(),add.getMoney()))
        {
            respone.setStatus(true);
            respone.setMessage("Money Added Successfully");
            System.out.println("Money Added Successfully");
        }
        else
        {
            respone.setStatus(false);
            respone.setMessage("You don't have Enough Money in Your Cradit Card");
            System.out.println("You don't have Enough Money in Your Cradit Card");
        }
        return respone;
    }
    @PostMapping("/refundRequest")
    public Response refund_request(@RequestBody refund r)
    {
        Response respone=new Response();
        this.user=new User();
        if(!(this.user.login(r.getEmail(), r.getPassword()))){
            System.out.println("Mission Failed Because you have wrong email or password");
            respone.setStatus(false);
            respone.setMessage("Mission Failed Because you have wrong email or password");
            return respone;
        }
        user.addRefundRequest(r.getDescription(),r.getMoney());
        respone.setStatus(true);
        respone.setMessage("Request Refund Added Successfully");
        return  respone;
    }
}
