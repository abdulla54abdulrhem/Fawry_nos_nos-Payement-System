package com.example.demo.model.DisplayPackage;
public class chooseLogInOrSignUpdisplay extends Display {
    @Override
    public int displayOption() {
        option=-1;
        while(option<1||option>2){
            System.out.println("choose:");
            System.out.println("1-login\n2-sign up");
            option=sc.nextInt();
        }

        return option;
    }
}
