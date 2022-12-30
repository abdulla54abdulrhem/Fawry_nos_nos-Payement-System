package com.example.demo.model;

import java.util.ArrayList;
import java.util.RandomAccess;

public class CustomerController {

    public ArrayList<String> search(String word) {
        ArrayList<String> foundServices=new ArrayList<String>();
        for(int i=0;i<Database.getInstance().services.size();i++){
            if(Database.getInstance().services.get(i).getDescription().contains(word)){
                foundServices.add(i+"- "+Database.getInstance().services.get(i).getDescription()+
                        " Costs: "+Database.getInstance().services.get(i).getCost()+
                        " EGP, Cost after discounts: "+Database.getInstance().services.get(i).getCostAfterDiscounts()+" EGP");
            }
        }
        return foundServices;
    }
    public ArrayList<String> getDiscounts(){
        return Database.getInstance().discountsDescriptions;
    }
    public ArrayList<service> getServices(){return Database.getInstance().services;}
    public boolean pay(User user,int id ){

        //working with service
        double moneyBefore=user.wallet.getBalance();
        if(Database.getInstance().services.get(id).pay(user)){
            double moneyAfter=user.wallet.getBalance();
            //important: make function getCost (because of discounts)
            user.transactions.add(new Transaction(user.email,Database.getInstance().services.get(id).getDescription(),moneyBefore-moneyAfter));
            return true;
        }
        return false;
    }

}
