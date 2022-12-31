package com.example.demo.model;

import java.util.ArrayList;
import java.util.Scanner;


public class admin extends UserAbstract implements ObserverAdmin {
    ArrayList<RefundRequest> refundRequests=new ArrayList<RefundRequest>();
    AdminController adminController=new AdminController();
    admin(){
        //initializing admin
        email="admin@gmail.com";
        password="1234";
        username="admin";
    }

    @Override
    public boolean login(String logingEmail, String logingPassword) {
        if(logingEmail.equals(email)&&logingPassword.equals(password)){
            System.out.println("welcome "+ username);
            return true;
        }else {
            return false;
        }
    }

    public void addGenaralDiscount(int dis){
        adminController.addGenaralDiscount(dis);
    }
    public void addSpecificDiscount(int dis,int servicOption){
        adminController.addSpecificDiscount(dis,servicOption);
    }
    public ArrayList<RefundRequest> showAllRefunds(){
        return this.refundRequests;
    }
    public boolean manageRequest(int id,boolean acceptRefund){
        for (RefundRequest request:this.refundRequests) {
            if(request.id==id){
                if(acceptRefund){
                    request.user.wallet.addMoney(request.whereIsMyMoney);
                }
                refundRequests.remove(request);
                return true;
            }
        }
        return false;
    }
    //todo: remove this function
//    void startAdminFunctions(){
//
//        while (true){
//            int option=new AdminMainMenu().displayOption();
//            if(option==1){
//                Display display=new DiscountOptionsDisplay();
//                int option1=display.displayOption();
//                if(option1==1){
//                    addGenaralDiscount(55);
//                }
//                else{
////                    Display specificService=new ChooseSpecifictoDiscountDisplay();
//                    int serviceoption= specificService.displayOption();
//                    Database.getInstance().specificDiscount.registerObserver(Database.getInstance().services.get(serviceoption));
//                    Database.getInstance().specificDiscount.addDiscount(55);
//                }
//            }else if(option==2) {
//                boolean returnTomenu=false;
//                //important: not sure if this a copy or refrence
//                    ArrayList<RefundRequest>tobeDeleted=new ArrayList<RefundRequest>();
//                    for (RefundRequest refund:this.refundRequests) {
//                        System.out.println("user: "+refund.user.username);
//                        System.out.println("email: "+refund.user.email);
//                        System.out.println(refund.refundDescription);
//                        System.out.println("requested: "+refund.whereIsMyMoney);
//                        int refundOption=new chooseToRefundDisplay().displayOption();
//                        if(refundOption==1){
//                            //give him his money
//                            refund.user.wallet.addMoney(refund.whereIsMyMoney);
//                            tobeDeleted.add(refund);
////                            u.refundRequests.remove(refund);
//                            System.out.println("successfull\nmoney after: "+ refund.user.wallet.getBalance());
//                        }else if(refundOption==2){
//                            tobeDeleted.add(refund);
//                        }else if(refundOption==3){
//                            returnTomenu=true;
//                            break;
//                        }
//                    }
//                    for (RefundRequest deleteThis: tobeDeleted) {
//                        this.refundRequests.remove(deleteThis);
//                    }
//                    tobeDeleted.clear();
//                    if(returnTomenu){
//                        break;
//                    }
//
//            }else if(option==3){
//                break;
//            }
//        }
//
//    }

    @Override
    public void notifyAdmin(RefundRequest r) {
        this.refundRequests.add(r);
    }
}
