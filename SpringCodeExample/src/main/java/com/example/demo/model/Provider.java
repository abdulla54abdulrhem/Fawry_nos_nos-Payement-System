package com.example.demo.model;
public abstract class Provider extends service {
    //we will use the provider as a decorator
    service theService;
    public void addService(service s){
        this.theService=s;
    }
    // we override the following methods
    public double getCostAfterDiscounts(){
        return this.getCost()-(this.cost*this.discountGeneral+this.cost*discountSpecific)+theService.getCostAfterDiscounts();
    }
    @Override
    public String getDescription(){
        return this.description+" "+theService.description;
    }

    @Override
    public double getCost() {
        return this.cost+this.theService.getCost();
    }
}
