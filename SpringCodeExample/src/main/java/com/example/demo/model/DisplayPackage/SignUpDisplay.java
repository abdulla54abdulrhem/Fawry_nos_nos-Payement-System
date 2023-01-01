package com.example.demo.model.DisplayPackage;

import com.example.demo.model.DisplayPackage.Display;

public class SignUpDisplay extends Display {
    public int displayOption(){
       System.out.println("Sign up:");
       return 0;
    }
    public String getEmail(){
        String s= sc.next();
        return s;
    }
    public String getPassword(){
        String pas=sc.next();
        return pas;
    }
}
