package com.example.demo.model.SevicePackage;

public class NullService extends service {
    private NullService(){
        description="";
        cost=0;
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new NullService();
        }
        return instance;
    }

    @Override
    public double getCost() {
        return this.cost;
    }
}
