package com.example.demo.model.DisplayPackage;

import java.util.Scanner;

public abstract class Display {
    int option;
    Scanner sc=new Scanner(System.in);
    public abstract int displayOption();
}
