package com.example.demo.model.SevicePackage;

public class LandlineQuarter extends service {
    private LandlineQuarter(){
        description="Landline quarter payment.";
        cost=100;
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new LandlineQuarter();
        }
        return instance;
    }

    @Override
    public double getCost() {
        return this.cost;
    }
}