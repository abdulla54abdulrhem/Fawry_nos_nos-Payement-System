package com.example.demo.model.DisplayPackage;
public class ChooseMainServicesDisplay extends Display{
    public ChooseMainServicesDisplay(){}
    public int displayOption(){
        System.out.println("Services in the system: ");
        System.out.println("1- Mobile recharge services");
        System.out.println("2- Internet payment services");
        System.out.println("3- Landline services");
        System.out.println("4- Donations");
        this.option=sc.nextInt();
        while(option>4||option<1){
            System.out.println("Error, invalid value, try again: ");
            this.option=sc.nextInt();
        }
        return this.option;
    }
}
