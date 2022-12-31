package com.example.demo.model;

import java.util.Scanner;

public class UsersAuthSystem {
    boolean login(String email,String password,User current){
            for (User u:Database.getInstance().users) {
                if(email.equals(u.email)&&password.equals(u.password)){
                    System.out.println("welcome"+ u.username);
                    Database.getInstance().users.remove(u);
                    current.wallet=u.wallet;
                    current.transactions=u.transactions;
                    current.email=u.email;
                    current.password=u.password;
                    current.username=u.username;
                    current.ThisId=u.ThisId;
                    Database.getInstance().users.add(current);
                    current.refundTransactions=u.refundTransactions;
                    current.paymentTransactions=u.paymentTransactions;
                    current.addToWalletTransactions=u.addToWalletTransactions;
                    return true;
                }
            }
        return false;
    }
    boolean register(User user,String username,String email,String password){
            for (UserAbstract u:Database.getInstance().users) {
                if(email.equals(u.email)||username.equals(u.username)){
                    {
                        return false;
                    }
                }
            }
            user.email=email;
            user.password=password;
            user.username=username;
            user.ThisId=User.ids;
            User.ids=User.ids+1;
            System.out.println("registerd as "+user.username);
            Database.getInstance().users.add(user);
            return true;
    }
}
