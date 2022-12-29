package com.example.demo.model;
public class DonationFactory extends ServiceFactory{
    public DonationFactory(){
        display= new ChooseDonationDisplay();
    }
    public service chooseService(int option){
//        option=display.displayOption();
        if(option==1){
            return HospitalDonation.getInstance();
        }
        else if(option==2){
            return  SchoolDonation.getInstance();
        }
        else if(option==3) {
            return  NGOsDonation.getInstance();
        }
        return null;

    }
}
