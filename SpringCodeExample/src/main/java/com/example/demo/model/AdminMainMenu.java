package com.example.demo.model;
public class AdminMainMenu extends Display{
    public AdminMainMenu(){}
    public int displayOption() {
        System.out.println("Admin Main Menu");
        System.out.println("1- Add Discounts to the system");
        System.out.println("2- List Refund requests");
        System.out.println("3- return to start");
        this.option=sc.nextInt();
        while(this.option<1||this.option>3){
            System.out.print("Error, Enter a valid number please: ");
            this.option=sc.nextInt();
        }
        return this.option;
    }
}
