package com.example.demo.model;
public class LandlineMonthly extends service {
    private LandlineMonthly(){
        description="Landline monthly payment.";
        cost=100;
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new LandlineMonthly();
        }
        return instance;
    }

    @Override
    public double getCost() {
        return this.cost;
    }
}