package com.example.demo.controller;

import com.example.demo.service.AdminService;
import com.example.demo.service.AdminServieImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.*;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    //sign in
    @Autowired
    AdminService adminService=new AdminServieImp();
    @PostMapping("/login")
    public Response login(@RequestBody TheUser user){
        Response res=new Response();
        if(adminService.loginAdmin(user.getEmail(),user.getPassword())){
            System.out.println("Admin logged in successfully");
            res.setStatus(true);
            res.setMessage("Admin logged in successfully");

        }
        else{
            System.out.println("Log in failed");
            res.setStatus(false);
            res.setMessage("Admin log in faild (wrong email or pass)");
        }
        return res;
    }
    //add general discount
    @PostMapping("/addGeneralDiscount")
    public Response addGeneralDiscount(@RequestBody GeneralDiscountForJson discount){
        //in case the user added a negative discount value
        discount.setDiscount(Math.abs(discount.getDiscount()));
        Response res=new Response();
        if(adminService.addGeneralDiscount(discount.getDiscount())){
            res.setMessage("General discount have been added successfully");
            res.setStatus(true);
        }
        else{
            res.setMessage("faild, admin is not logged in");
            res.setStatus(false);
        }
        return res;
    }
    //add specific discount
    @PostMapping("/addSpecificDiscount")
    public Response addSpecificDiscount(@RequestBody SpecificDiscountForJson discount){
        //in case the user added a negative discount value
        discount.setDiscount(Math.abs(discount.getDiscount()));
        Response res=new Response();
        if(adminService.addSpecificDiscount(discount.getIndexOfService(),discount.getDiscount())){
            res.setMessage("Specific discount have been added successfully");
            res.setStatus(true);
        }
        else{
            res.setMessage("faild, admin is not logged in, or wrong index");
            res.setStatus(false);
        }
        return res;
    }
    //list refund requests;
    @GetMapping("/RefundRequests")
    public Response showRefundRequests(){
        Response res=new Response();
        res.object=adminService.showRefundRequests();
        if(res==null){
            res.setMessage("The admin is not logged in");
            res.setStatus(false);
            return res;
        }
        res.setMessage("Refund request get successfully");
        res.setStatus(true);
        return res;
    }
    //answer the refund request
    @PostMapping("/AnswerRefund")
    public Response anwerRefund(AnsOfRequestJson ans){
        Response res=new Response();
        if(adminService.answerRefundRequest(ans.getId(),ans.getAnswer()))
        {
            res.setMessage("Response "+ans.getId()+" has been answered successfully");
            res.setStatus(true);
        }
        else{
            res.setMessage("The id of request doesn't exist or the admin is not logged in");
            res.setStatus(false);
        }
        return res;
    }
}
