package com.example.demo.model;

public class AdminController {
    public void addGenaralDiscount(int dis){
        Database.getInstance().generalDiscount.addDiscount(dis);
    }
    public void addSpecificDiscount(int dis,int serviceoption){
        Database.getInstance().specificDiscount.registerObserver(Database.getInstance().services.get(serviceoption));
        Database.getInstance().specificDiscount.addDiscount(dis);
    }
}
