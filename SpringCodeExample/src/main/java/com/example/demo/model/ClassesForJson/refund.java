package com.example.demo.model.ClassesForJson;

public class refund {
    private String description;
    private double money;
    private String email;
    private String password;
    public void setDescription(String description) {
        this.description = description;
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

    public String getDescription() {
        return this.description;
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
