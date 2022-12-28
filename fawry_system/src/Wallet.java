import java.util.Scanner;

public class Wallet {
    creditCard card=new creditCard();
    private double Balance;
    public Wallet(){
        Balance=0;
    }
    public double getBalance(){
        return this.Balance;
    }
    public void addMoneyByCreditCard(double money){
        System.out.println("enter credit card balance:");
        double balance= new Scanner(System.in).nextDouble();
        card.updateBalance(balance);
        if(card.balance>money){
            this.Balance+=money;
            System.out.println("added successfully");
        }else {
            System.out.println("not enough money in credit card");
        }

    }
    public void addMoney(double money){
        this.Balance+=money;
    }
    public void deductMoney(double cost){
        this.Balance-=cost;
    }
}
