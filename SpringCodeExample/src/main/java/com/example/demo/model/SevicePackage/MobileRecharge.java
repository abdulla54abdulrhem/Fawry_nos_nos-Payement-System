package com.example.demo.model.SevicePackage;

public class MobileRecharge extends service {
    private MobileRecharge(){
        description="Mobile Recharge.";
        cost=10;
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new MobileRecharge();
        }
        return instance;
    }

    @Override
    public double getCost() {
        return this.cost;
    }
}