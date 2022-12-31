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
    //now we make 3 arrays of the transactions we need to keep about every user
    //at every transaction done for the user, we just add to those appropriate array
    public ArrayList<String>paymentTransactions=new ArrayList<>();
    public ArrayList<String>refundTransactions=new ArrayList<>();
    public ArrayList<String>addToWalletTransactions=new ArrayList<>();
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
    public boolean addMoney(double craditCardBalance,double money){
        if(wallet.addMoneyByCreditCard(craditCardBalance,money)) {
            //here we add successful add to wallet transaction
            Transaction t=new Transaction(username,"Succssfull add to wallet transaction",money);
            addToWalletTransactions.add(t.getInformaion());
            return true;
        }
        else
            return false;
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
    public void makeRefundRequest(String refundDescription,double money){
        RefundRequest refund=new RefundRequest(this,refundDescription,money);
        //now we make refund request transaction to refund transaction array

        refundTransactions.add(new Transaction(username,"Refund Request "+refundDescription,money).getInformaion());
        notifyObserver(refund);
    }

    //todo:make the pay function with abdullah
    public boolean pay(int id){
        return customerController.pay(this,id);
    }

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
    public void addRefundRequest(String description,double money) {
        this.makeRefundRequest(description,money);
    }
    public double getWalletMoney()
    {
        return this.wallet.getBalance();
    }
}
