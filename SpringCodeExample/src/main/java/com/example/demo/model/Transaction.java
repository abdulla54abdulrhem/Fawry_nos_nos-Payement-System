package com.example.demo.model;
public class Transaction {
    String service_description=null;
    String userEmail=null;
    double cost;
    public Transaction(String userEmail,String service_description,double cost){
        this.service_description=service_description;
        this.userEmail=userEmail;
        this.cost=cost;
    }
    public String getInformaion(){
        return ("Transaction description: "+service_description)+" "+ ("Made by:" +userEmail)+" " +("Cost: "+cost);
    }
}
