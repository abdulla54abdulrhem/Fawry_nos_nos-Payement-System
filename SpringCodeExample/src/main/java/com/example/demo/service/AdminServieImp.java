package com.example.demo.service;

import com.example.demo.model.SevicePackage.service;
import com.example.demo.model.UserandAdmin.RefundRequest;
import org.springframework.stereotype.Service;
import static com.example.demo.util.Common.database;

import java.util.ArrayList;

@Service
public class AdminServieImp implements AdminService{
    public Boolean is_admin_loggedIn=false;
    public Boolean loginAdmin(String username,String password){
        try {
            if(database.myAdmin.login(username,password)){
                is_admin_loggedIn=true;
                return true;
            }
            return false;
        }
        catch (Exception e){
            System.out.println("Exception in loginAdmin as"+e.getMessage());
            return false;
        }

    }
    public Boolean addGeneralDiscount(int dis){
        if(is_admin_loggedIn&&dis>=0){
            database.generalDiscount.addDiscount(dis);
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean addSpecificDiscount(int indxOfChosenService,int dis){
        if(database.services.size()>indxOfChosenService&&is_admin_loggedIn){
            //then the index of the chosen services is correct
            service choosenService=database.services.get(indxOfChosenService);
            database.specificDiscount.registerObserver(choosenService);
            database.specificDiscount.addDiscount(dis);
            return true;
        }
        return false;
    }

    public ArrayList<RefundRequest> showRefundRequests(){
        try{
            if(is_admin_loggedIn)
                return database.myAdmin.showAllRefunds();
            return null;
        }
        catch (Exception e){
            System.out.println("Exception in show refund request as"+e.getMessage());
            return null;
        }
    }

    public Boolean answerRefundRequest(int id,int answer){
        Boolean ans;
        if(answer==0)ans=false;
        else ans=true;
        if(database.myAdmin.manageRequest(id,ans)&&is_admin_loggedIn){
            return true;
        }
        return false;
    }
    public ArrayList<String> getPaymentTransactions(int userIndx){
        if(database.users.size()<=userIndx){
            //the user indx is wrong (out of range)
            return null;
        }
        else{
            return database.users.get(userIndx).paymentTransactions;
        }
    }
    public ArrayList<String> getRefundTransactions(int userIndx){
        if(database.users.size()<=userIndx){
            //the user indx is wrong (out of range)
            return null;
        }
        else{
            return database.users.get(userIndx).refundTransactions;
        }
    }
    public ArrayList<String> getAddToWalletTransactions(int userIndx){
        if(database.users.size()<=userIndx){
            //the user indx is wrong (out of range)
            return null;
        }
        else{
            return database.users.get(userIndx).addToWalletTransactions;
        }
    }
}
