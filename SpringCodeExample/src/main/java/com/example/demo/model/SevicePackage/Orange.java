package com.example.demo.model.SevicePackage;
import com.example.demo.model.*;
public class Orange extends Provider{
    public Orange(){
        this.description="Orange";
        this.cost=2.0;//the additional cost for the provider
        this.theService=NullService.getInstance();
    }

}
