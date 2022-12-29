package com.example.demo.model;

import java.util.ArrayList;

public class GeneralDiscount implements DiscountSubject{
    ArrayList<Observer>observers=new ArrayList<Observer>();
    double discount;
    Display display=new GeneralDiscountDisplay();
    public GeneralDiscount(){}
    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        observers.remove(o);
    }
    public void notifyObserver(){
        for(Observer ob:observers){
            ob.updateDiscount(discount);
        }
    }
    public void addDiscount(int dis){
//        int dis=display.displayOption();
        discount=(dis/100.0);
        Database.getInstance().addGeneralDiscountDiscription(discount);
        //System.out.println(discount);
        notifyObserver();
    }
}
