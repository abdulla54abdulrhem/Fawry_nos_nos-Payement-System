package com.example.demo.model;
public class SpecificDiscountDisplay extends Display{
    public SpecificDiscountDisplay(){}
    public int displayOption(){
        System.out.println("Specific Discount:");
        //باقي حتة انه يعرف هيعمل الدسكاونت ده في انهي service لسه هتتعمل
        System.out.println("Enter the amount of discount you want (0-100%): ");
        this.option=sc.nextInt();
        while(this.option<0||this.option>100){
            System.out.println("Error, Enter correct value: ");
            this.option=sc.nextInt();
        }
        return this.option;
    }
}
