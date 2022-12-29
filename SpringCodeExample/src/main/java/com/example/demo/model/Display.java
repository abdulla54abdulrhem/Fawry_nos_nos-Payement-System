package com.example.demo.model;

import java.util.Scanner;

public abstract class Display {
    int option;
    Scanner sc=new Scanner(System.in);
    public abstract int displayOption();
}
