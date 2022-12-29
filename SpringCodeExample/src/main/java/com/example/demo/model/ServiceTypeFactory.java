package com.example.demo.model;
public class ServiceTypeFactory {
//    Display display;
    public ServiceTypeFactory(){

    }
    public ServiceFactory chooseMainService(int option){
//        int option=display.displayOption();
        if(option==1){
            return new MobileRechargeFactory();
        }
        else if(option==2){
            return new InternetRechargeFactory();
        }
        else if(option==3){
            return new LandLineFactory();
        }
        else if(option==4){
            return new DonationFactory();
        }
        return null;
    }
}
