package com.example.demo.model;

import com.example.demo.model.ObserverPatternPackage.GeneralDiscount;
import com.example.demo.model.ObserverPatternPackage.SpecificDiscount;
import com.example.demo.model.FactoryPackage.ServiceFactory;
import com.example.demo.model.FactoryPackage.ServiceTypeFactory;
import com.example.demo.model.ObserverPatternPackage.DiscountSubject;
import com.example.demo.model.SevicePackage.service;
import com.example.demo.model.UserandAdmin.User;
import com.example.demo.model.UserandAdmin.admin;

import java.util.ArrayList;

public class Database {
    static private Database instance=null;
    public admin myAdmin=new admin();
    public ArrayList<User> users=new ArrayList<User>();
    public ArrayList<service> services=new ArrayList<service>();
    String generalDiscountData="added General Discount 0%";
    public ArrayList<String> discountsDescriptions=new ArrayList<String>();

    //wow
    //the bank gave me the cards database
    //cool!!!

    public DiscountSubject generalDiscount=new GeneralDiscount();
    public DiscountSubject specificDiscount=new SpecificDiscount();
    private Database(){
        discountsDescriptions.add(generalDiscountData);
        //this function intiallizes the database with the services
        ServiceFactory servicefactory;
        service ser;
        ServiceTypeFactory serviceTypeFactory=new ServiceTypeFactory();
        int i=0;
        while (true){
            i++;
            servicefactory=serviceTypeFactory.chooseMainService(i);
            if(servicefactory==null){
                break;
            }
            int j=0;
            while (true){
                j++;
                ser=servicefactory.chooseService(j);
                if(ser==null){break;}
                addService(ser);
            }
        }
        int id=0;
        for (service s:this.services) {
            s.id=id;
            id++;
        }

    }
    public static Database getInstance() {
        if(instance==null){
            instance=new Database();
        }
        return instance;
    }
    public void addUser(User user){
        users.add(user);
    }
    public void addService(service service){
        services.add(service);
        //to add make the service and observer in the general discount
        generalDiscount.registerObserver(service);
    }

    public void addGeneralDiscountDiscription(double discount){
        discountsDescriptions.remove(generalDiscountData);
        generalDiscountData=("added General Discount "+discount*100+"%");
        discountsDescriptions.add(generalDiscountData);
    }
    public void addSpecificDiscountDescription(String description,double discount){
        for (int i = 0; i < discountsDescriptions.size(); i++) {
            if(discountsDescriptions.get(i).contains(description)){
                discountsDescriptions.remove(i);
                break;
            }
        }
        discountsDescriptions.add("Added discount to: "+description+" "+discount*100+"%" );
    }



}
