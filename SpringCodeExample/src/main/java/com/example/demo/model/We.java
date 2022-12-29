package com.example.demo.model;
public class We extends Provider{
    public We(){
        this.description="We";
        this.cost=5.0;//the additional cost for the provider
        this.theService=NullService.getInstance();
    }

}
