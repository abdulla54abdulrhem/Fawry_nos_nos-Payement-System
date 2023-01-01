package com.example.demo.model.FactoryPackage;

import com.example.demo.model.DisplayPackage.ChooseLandlineDisplay;
import com.example.demo.model.SevicePackage.LandlineMonthly;
import com.example.demo.model.SevicePackage.LandlineQuarter;
import com.example.demo.model.SevicePackage.service;

public class LandLineFactory extends ServiceFactory{
    public LandLineFactory(){
        display=new ChooseLandlineDisplay();
    }
    public service chooseService(int option){
//        option=display.displayOption();
        if(option==1){
            return LandlineMonthly.getInstance();
        }
        else if(option==2){
            return LandlineQuarter.getInstance();
        }
        return null;
    }
}
