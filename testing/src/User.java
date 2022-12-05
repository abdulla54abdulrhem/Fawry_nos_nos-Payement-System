
import java.util.ArrayList;
import java.util.Scanner;

public class User extends UserAbstract{
	ArrayList<Transaction>transactions= new ArrayList<Transaction>();
    ArrayList<RefundRequest> refundRequests= new ArrayList<RefundRequest>();
    Wallet wallet=new Wallet();
    Display usermainMenu;
    ServiceTypeFactory serviceTypeFactory=new ServiceTypeFactory();
    ServiceFactory servicefactory;
    service ser;
    Scanner sc=new Scanner(System.in);
    public User(){
        usermainMenu=new chooseLogInOrSignUpdisplay();
        int option=usermainMenu.displayOption();
        if(option==1){
            //login in
            User u=system.login();
            this.wallet=u.wallet;
            this.transactions=u.transactions;
            this.refundRequests=u.refundRequests;
            this.email=u.email;
            this.password=u.password;
            this.username=u.username;
        }else if(option==2){
            //register new user
            system.register(this);
        }
        // i think that method name describes it very well (no need for comment)
        startUserFunctions();
    }





    public void startUserFunctions(){
        usermainMenu=new UserOptionDisplay();
        while (true){
            int option1=usermainMenu.displayOption();
            if(option1==1){
                //showing current balance
                System.out.println("User Balance: "+wallet.getBalance());
            }
            else if(option1==2){
                //adding money via credit card
                System.out.println("Enter the amount of money to add into wallet: (it's via your credit card) ");
                double money=sc.nextDouble();
                wallet.addMoney(money);
            }
            else if(option1==3){
                //showing services
                Database.getInstance().showServices();
            }
            else if(option1==4){
                //showing discounts
                Database.getInstance().showDiscounts();
            }
            else if(option1==5){
                //make refund request
                RefundRequest r=new RefundRequest();
                refundRequests.add(r);
            }
            else if(option1==6){
                // paying for a service
                servicefactory=serviceTypeFactory.chooseMainService();
                ser=servicefactory.chooseService();
                double moneyBefore=wallet.getBalance();
                if(ser.pay(this)){
                    double moneyAfter=wallet.getBalance();
                    System.out.println("success\n current balance="+wallet.getBalance());
                    //important: make function getCost (because of discounts)
                    transactions.add(new Transaction(this.email,ser.description,moneyBefore-moneyAfter));
                    transactions.get(transactions.size()-1).getInformaion();
                }else {
                    System.out.println("failed, no enough balance\n(if you want to buy via credit card ,just use it to add money to the wallet)\nneeded money: "+ser.cost);

                }


            }else if(option1==7){
                // going back to start display (choose to be admin or user)
                return;
            }
        }

    }
}
