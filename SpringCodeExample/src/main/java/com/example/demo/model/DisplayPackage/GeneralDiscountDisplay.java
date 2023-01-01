package com.example.demo.model.DisplayPackage;

import com.example.demo.model.DisplayPackage.Display;

public class GeneralDiscountDisplay extends Display {
    public GeneralDiscountDisplay(){}
    public int displayOption(){
        System.out.println("General Discount:");
        System.out.println("Enter the amount of discount you want (0-100%): ");
        this.option=sc.nextInt();
        while(this.option<0||this.option>100){
            System.out.println("Error, Enter correct value: ");
            this.option=sc.nextInt();
        }
        return this.option;
    }
}
