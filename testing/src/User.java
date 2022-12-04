import javax.xml.crypto.Data;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class User extends UserAbstract{
	ArrayList<Transaction>transactions= new ArrayList<Transaction>();
    ArrayList<RefundRequest> refundRequests= new ArrayList<RefundRequest>();
    Wallet wallet=new Wallet();
    Display usermainMenu=new UserOptionDisplay();
    ServiceTypeFactory serviceTypeFactory=new ServiceTypeFactory();
    ServiceFactory servicefactory;
    service ser;
    Scanner sc=new Scanner(System.in);
    public User(){
        usermainMenu=new chooseLogInOrSignUpdisplay();
        int option=usermainMenu.displayOption();
        if(option==1){
            User u=system.login();
            this.wallet=u.wallet;
            this.transactions=u.transactions;
            this.refundRequests=u.refundRequests;
            this.email=u.email;
            this.password=u.password;
            this.username=u.username;
        }else if(option==2){
            system.register(this);
        }
        tempFactoryforDisplays();
    }





    public void tempFactoryforDisplays(){
        usermainMenu=new UserOptionDisplay();
        while (true){
            int option1=usermainMenu.displayOption();
            if(option1==1){
                System.out.println("User Balance: "+wallet.getBalance());
            }
            else if(option1==2){
                System.out.println("Enter the amount of money to add into wallet: ");
                double money=sc.nextDouble();
                wallet.addMoney(money);
            }
            else if(option1==3){
                Database.getInstance().showServices();
            }
            else if(option1==4){
                Database.getInstance().showDiscounts();
            }
            else if(option1==5){
                //make refund request
                RefundRequest r=new RefundRequest();
                refundRequests.add(r);
            }
            else if(option1==6){
                servicefactory=serviceTypeFactory.chooseMainService();
                ser=servicefactory.chooseService();
                if(ser.pay(this)){
                    System.out.println("success\n current balance="+wallet.getBalance());
                    //important: make function getCost (because of discounts)
                    transactions.add(new Transaction(this.email,ser.description,ser.cost));
                    transactions.get(0).getInformaion();
                }else {
                    System.out.println("failed, no enough balance\n");
                }


            }else if(option1==7){
                return;
            }
        }

    }
}
