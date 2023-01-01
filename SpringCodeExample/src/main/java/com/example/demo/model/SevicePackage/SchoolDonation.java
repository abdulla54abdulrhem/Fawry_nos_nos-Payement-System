package com.example.demo.model.SevicePackage;
public class SchoolDonation extends service {
    private SchoolDonation(){
        description="School Donation service.";
        cost=20;
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new SchoolDonation();
        }
        return instance;
    }

    @Override
    public double getCost() {
        return this.cost;
    }
}