package com.example.demo.model.ObserverPatternPackage;

import com.example.demo.model.Database;
import com.example.demo.model.DisplayPackage.Display;
import com.example.demo.model.DisplayPackage.SpecificDiscountDisplay;
import com.example.demo.model.ObserverPatternPackage.DiscountSubject;
import com.example.demo.model.ObserverPatternPackage.Observer;

public class SpecificDiscount implements DiscountSubject {
    Observer observer;
    double discount=0;
    Display display=new SpecificDiscountDisplay();
    public SpecificDiscount(){

    }
    public void registerObserver(Observer o){
        observer=o;
    }
    public void removeObserver(Observer o){
        observer=null;
    }
    public void notifyObserver(){
        observer.updateSpecificDiscount(discount);
        Database.getInstance().addSpecificDiscountDescription(observer.getDescription(),discount);
    }
    @Override
    public void addDiscount(int dis){
        discount=(dis/100.0);
        //System.out.println(discount);
        notifyObserver();
    }

}
