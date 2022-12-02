import java.sql.Ref;
import java.util.Scanner;
import java.util.Vector;

public class User extends UserAbstract{
	Vector<Transaction>transactions= new Vector<Transaction>();
    Vector<RefundRequest>refundRequests= new Vector<RefundRequest>();
    Wallet wallet=new Wallet();
    Display usermainMenu=new UserOptionDisplay();
    ServiceTypeFactory serviceTypeFactory=new ServiceTypeFactory();
    ServiceFactory servicefactory;
    service ser;
    Scanner sc=new Scanner(System.in);
    public User(){}
    public void tempFactoryforDisplays(){
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
            //show services available in the system
        }
        else if(option1==4){
            //show discounts in the system
        }
        else if(option1==5){
            //make refund request
            RefundRequest r=new RefundRequest();
            refundRequests.add(r);
        }
        else if(option1==6){
            servicefactory=serviceTypeFactory.chooseMainService();
            ser=servicefactory.chooseService();

        }
    }
}
