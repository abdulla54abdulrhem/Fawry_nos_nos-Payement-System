package com.example.demo.model;
public class RefundRequest {
    int id;
    static int StaticID=0;
    public String refundDescription=null;
    public User user;

    double whereIsMyMoney;

    public int getId() {
        return id;
    }

    public RefundRequest(User user, String refundDescription, double whereIsMyMoney){
        this.user=user;
        this.refundDescription=refundDescription;
        this.whereIsMyMoney= whereIsMyMoney;
        this.id=StaticID;
        StaticID++;
    }

}
