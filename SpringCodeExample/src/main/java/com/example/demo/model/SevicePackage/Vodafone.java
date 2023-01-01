package com.example.demo.model.SevicePackage;
import com.example.demo.model.*;
public class Vodafone extends Provider{
    public Vodafone(){
        this.description="Vodafone";
        this.cost=2.0;//the additional cost for the provider
        this.theService=NullService.getInstance();
    }

}
