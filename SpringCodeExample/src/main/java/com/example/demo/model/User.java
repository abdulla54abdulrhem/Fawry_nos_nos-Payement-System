package com.example.demo.model;

import java.util.ArrayList;
import java.util.Scanner;

public class User extends UserAbstract implements SubjectUser{
    static  int ids=0;
    public int ThisId;
    ArrayList<ObserverAdmin>observerAdmins= new ArrayList<ObserverAdmin>();
	ArrayList<Transaction>transactions= new ArrayList<Transaction>();
    CustomerController customerController=new CustomerController();
    Wallet wallet=new Wallet();
    ServiceTypeFactory serviceTypeFactory=new ServiceTypeFactory();
    ServiceFactory servicefactory;
    service ser;
    Scanner sc=new Scanner(System.in);
    public User(){
        //getting the admin from database (the user object needs him to send refund requests)
        this.registerAdmin(Database.getInstance().myAdmin);
    }
    //1
    @Override
    public boolean login(String logingEmail, String logingPassword){

        return system.login(logingEmail,logingPassword, this);
    }
    //2
    public boolean register(String loginUsername, String loginEmail, String loginPassword){
        return system.register(this,loginUsername,loginEmail,loginPassword);
    }
    //3
    public double showCurrentBalance(){return wallet.getBalance();}
    //4
    //todo:make the credit card thing
    public void addMoney(double money){
        wallet.addMoney(money);
    }
    //5
    public ArrayList<String> search(String word){
        return customerController.search(word);
    }
    //6
    public ArrayList<String> getDiscounts(){
        return customerController.getDiscounts();
    }

    public  ArrayList<service> getServices(){return customerController.getServices();}
    //7
    public void makeRefundRequest(String refundDescription,int money){
        RefundRequest refund=new RefundRequest(this,refundDescription,money);
        notifyObserver(refund);
    }

    //todo:make the pay function with abdullah
    public boolean pay(int id){
        return customerController.pay(this,id);
    }

//    public void startUserFunctions(){
//
//        while (true){
//            int option1=5;
//            if(option1==1){
//                //
//                //showing current balance
//                System.out.println("User Balance: "+showCurrentBalance());
//            }
//            else if(option1==2){
//                //
//                //adding money via credit card
//                addMoney(55);
//            }
//            else if(option1==3){
//                //showing services
//                search("hi");
//            }
//            else if(option1==4){
//                //controller needed
//                //showing discounts
//                System.out.println(getDiscounts());
//            }
//            else if(option1==5){
//                //make refund request
//                makeRefundRequest("hi",0);
//            }
//            else if(option1==6){
//                // paying for a service
////                servicefactory=serviceTypeFactory.chooseMainService();
////                ser=servicefactory.chooseService();
//                double moneyBefore=wallet.getBalance();
//                if(ser.pay(this)){
//                    double moneyAfter=wallet.getBalance();
//                    System.out.println("success\n current balance="+wallet.getBalance());
//                    //important: make function getCost (because of discounts)
//                    transactions.add(new Transaction(this.email,ser.description,moneyBefore-moneyAfter));
//                    transactions.get(transactions.size()-1).getInformaion();
//                }else {
//                    System.out.println("failed, no enough balance\n(if you want to buy via credit card ,just use it to add money to the wallet)\nneeded money: "+ser.cost);
//
//                }
//
//
//            }else if(option1==7){
//                // going back to start display (choose to be admin or user)
//                return;
//            }
//        }
//
//    }





//doing the observer pattern four functions
    @Override
    public void registerAdmin(ObserverAdmin a) {
        this.observerAdmins.add(a);
    }

    @Override
    public void removeObserver(ObserverAdmin a) {
        this.observerAdmins.remove(a);
    }

    @Override
    public void notifyObserver(RefundRequest r) {
        for (ObserverAdmin observerAdmin:this.observerAdmins) {
            observerAdmin.notifyAdmin(r);
        }
    }

    @Override
    public void addRefundRequest() {

    }
}
