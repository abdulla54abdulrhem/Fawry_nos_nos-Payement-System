public class Wallet {
    private double Balance;
    public Wallet(){
        Balance=0;
    }
    public double getBalance(){
        return this.Balance;
    }
    public void addMoney(double money){
        this.Balance+=money;
    }
    public void deductMoney(double cost){
        this.Balance-=cost;
    }
}
