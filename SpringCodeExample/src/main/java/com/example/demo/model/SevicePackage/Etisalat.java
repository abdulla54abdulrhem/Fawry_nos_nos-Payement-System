package com.example.demo.model.SevicePackage;

import com.example.demo.model.SevicePackage.NullService;
import com.example.demo.model.SevicePackage.Provider;

public class Etisalat extends Provider {
    public Etisalat(){
        this.description="Etisalat";
        this.cost=1.0;//the additional cost for the provider
        this.theService= NullService.getInstance();
    }

}
