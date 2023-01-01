package com.example.demo.service;

import com.example.demo.model.UserandAdmin.RefundRequest;

import java.util.ArrayList;

public interface AdminService {
    public Boolean loginAdmin(String username,String password);
    public Boolean addGeneralDiscount(int dis);
    public Boolean addSpecificDiscount(int indexOfChosenService,int dis);
    public ArrayList<RefundRequest> showRefundRequests();
    public Boolean answerRefundRequest(int id,int answer);
    public ArrayList<String> getPaymentTransactions(int userIndx);
    public ArrayList<String> getRefundTransactions(int userIndx);
    public ArrayList<String> getAddToWalletTransactions(int userIndx);
}
