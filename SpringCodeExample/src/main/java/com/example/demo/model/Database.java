package com.example.demo.model;

import java.util.ArrayList;

public class Database {
    static private Database instance=null;
    public admin myAdmin=new admin();
    ArrayList<User> users=new ArrayList<User>();
    public ArrayList<service> services=new ArrayList<service>();
    String generalDiscountData="added General Discount 0%";
    ArrayList<String> discountsDescriptions=new ArrayList<String>();

    //wow
    //the bank gave me the cards database
    //cool!!!

    public DiscountSubject generalDiscount=new GeneralDiscount();
    public DiscountSubject specificDiscount=new SpecificDiscount();
    private Database(){
        intiallizeDataBaseWithServices();
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
        generalDiscountData=("added General Discount "+discount*100+"%");
    }
    public void addSpecificDiscountDescription(String description,double discount){
        discountsDescriptions.add("Added discount to: "+description+" "+discount*100+"%" );
    }
    public void showDiscounts(){
        System.out.println(generalDiscountData);
        for(String dis:discountsDescriptions){
            System.out.println(dis);
        }
    }

    public void intiallizeDataBaseWithServices(){
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
    }
}
