package com.example.demo.model.UserandAdmin;

public class Wallet {
    creditCard card=new creditCard();
    private double Balance;
    public Wallet(){
        Balance=333;
    }
    public double getBalance(){
        return this.Balance;
    }
    public boolean addMoneyByCreditCard(double creditcardbalanced ,double money) {
        card.updateBalance(creditcardbalanced);
        if (card.balance > money) {
            this.Balance += money;
            return true;
        } else {
            return false;
        }

    }
    public void deductMoney(double cost){
        this.Balance-=cost;
    }

    public void addMoney(double whereIsMyMoney) {
        this.Balance+=whereIsMyMoney;
    }
}
