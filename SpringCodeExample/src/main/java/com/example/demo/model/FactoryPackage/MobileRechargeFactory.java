package com.example.demo.model.FactoryPackage;

import com.example.demo.model.DisplayPackage.ChooseMoblieRechargeDisplay;
import com.example.demo.model.SevicePackage.*;

public class MobileRechargeFactory extends ServiceFactory{
    public MobileRechargeFactory(){
        display=new ChooseMoblieRechargeDisplay();
    }
    public service chooseService(int option){
//        option=display.displayOption();
        if(option==1){
            Provider voda= (Provider) new Vodafone();
            voda.addService(MobileRecharge.getInstance());
            return voda;
        }
        else if(option==2){
            Provider we= (Provider) new We();
            we.addService(MobileRecharge.getInstance());
            return we;
        }
        else if(option==3){
            Provider orange= (Provider) new Orange();
            orange.addService(MobileRecharge.getInstance());
            return orange;
        }
        else if(option==4){
            Provider eti= (Provider) new Etisalat();
            eti.addService(MobileRecharge.getInstance());
            return eti;
        }
        return null;
    }
}
