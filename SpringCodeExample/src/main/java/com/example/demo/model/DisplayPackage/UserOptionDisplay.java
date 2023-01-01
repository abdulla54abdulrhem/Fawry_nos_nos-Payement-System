package com.example.demo.model.DisplayPackage;

import com.example.demo.model.DisplayPackage.Display;

public class UserOptionDisplay extends Display {
    public UserOptionDisplay(){}
    public int displayOption(){
        System.out.println("User Options Menu");
        System.out.println("1- Show My Wallet Balance");
        System.out.println("2- Add money to my wallet");
        System.out.println("3- Search Services available");
        System.out.println("4- Show discounts available");
        System.out.println("5- make refund request");
        System.out.println("6- use services");
        System.out.println("7- return to start display");
        this.option=sc.nextInt();
        while(this.option>7||this.option<1){
            System.out.println("Error, wrong option, Enter again: ");
            this.option=sc.nextInt();
        }
        return this.option;
    }
}
