package com.example.demo.model.ClassesForJson;

public class addToWallet {
    private double craditCardBalance;
    private  double money;
    private String email;
    private  String password;
    public void setCraditCardBalance(double craditCardBalance) {
        this.craditCardBalance = craditCardBalance;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCraditCardBalance() {
        return this.craditCardBalance;
    }

    public double getMoney() {
        return this.money;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
