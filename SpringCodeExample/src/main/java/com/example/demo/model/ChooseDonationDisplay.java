package com.example.demo.model;
public class ChooseDonationDisplay extends Display{
    public ChooseDonationDisplay(){}
    public int displayOption(){
        System.out.println("Donations services: ");
        System.out.println("1- Cancer Hospital");
        System.out.println("2- School");
        System.out.println("3- Non profitable organizations");
        this.option=sc.nextInt();
        while(option>3||option<1){
            System.out.println("Error, invalid value, try again: ");
            this.option=sc.nextInt();
        }
        return this.option;
    }
}
