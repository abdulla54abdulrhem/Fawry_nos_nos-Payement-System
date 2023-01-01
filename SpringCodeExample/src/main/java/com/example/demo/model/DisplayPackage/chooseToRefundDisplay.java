package com.example.demo.model.DisplayPackage;


import java.util.Scanner;

public class chooseToRefundDisplay extends Display {
    @Override
    public int displayOption() {
        option=-1;
        while (option<1||option>3){
        System.out.println("choose option: ");
        System.out.println("1-return money");
        System.out.println("2-do not return money");
        System.out.println("3-return to admin options");
        option=new Scanner(System.in).nextInt();
        }
        return option;
    }
}
