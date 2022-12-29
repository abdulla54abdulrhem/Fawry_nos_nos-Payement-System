package com.example.demo.model;
public class InternetRechargeFactory extends ServiceFactory{
    public InternetRechargeFactory(){
        display=new ChooseInternetRecharge();
    }
    public service chooseService(int option){
//        option=display.displayOption();
        if(option==1){
            Provider voda= (Provider) new Vodafone();
            voda.addService(InternetRecharge.getInstance());
            return voda;
        }
        else if(option==2){
            Provider we= (Provider)new We();
            we.addService(InternetRecharge.getInstance());
            return we;
        }
        else if(option==3){
            Provider orange= (Provider) new Orange();
            orange.addService(InternetRecharge.getInstance());
            return orange;
        }
        else if(option==4){
            Provider eti= (Provider) new Etisalat();
            eti.addService(InternetRecharge.getInstance());
            return eti;
        }
        return null;
    }
}
