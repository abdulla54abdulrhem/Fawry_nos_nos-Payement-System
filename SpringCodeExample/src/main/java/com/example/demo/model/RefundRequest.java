package com.example.demo.model;
public class RefundRequest {
    static int StaticID=0;
    public String refundDescription=null;
    public User user;
    int id;
    double whereIsMyMoney;
    public RefundRequest(User user,String refundDescription,int whereIsMyMoney){
        this.user=user;
        this.refundDescription=refundDescription;
        this.whereIsMyMoney= whereIsMyMoney;
        this.id=StaticID;
        StaticID++;
    }

}
