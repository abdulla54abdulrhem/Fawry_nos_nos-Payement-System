
import java.util.ArrayList;
import java.util.Scanner;

public class User extends UserAbstract implements SubjectUser{
    static  int ids=0;
    public int ThisId;
    ArrayList<ObserverAdmin>observerAdmins= new ArrayList<ObserverAdmin>();
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
            //login
            User u=system.login();
            this.wallet=u.wallet;
            this.transactions=u.transactions;
            this.refundRequests=u.refundRequests;
            this.email=u.email;
            this.password=u.password;
            this.username=u.username;
            this.ThisId=u.ThisId;
            Database.getInstance().users.add(this);
        }else if(option==2){
            //register new user
            system.register(this);
        }
        //getting the admin from database (the user object needs him to send refund requests)
        this.registerAdmin(Database.getInstance().myAdmin);
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
                System.out.println("enter search word: IMPORTANT: type a dot to show all ---> .");
                System.out.println("note: upper case letters and lower case letter are considered different");
                String s=sc.next();
                Database.getInstance().showMatchingServices(s);
            }
            else if(option1==4){
                //showing discounts
                Database.getInstance().showDiscounts();
            }
            else if(option1==5){
                //make refund request
                RefundRequest r=new RefundRequest(this);
                notifyObserver(r);
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
//doing the observer pattern four functions
    @Override
    public void registerAdmin(ObserverAdmin a) {
        this.observerAdmins.add(a);
    }

    @Override
    public void removeObserver(ObserverAdmin a) {
        this.observerAdmins.remove(a);
    }

    @Override
    public void notifyObserver(RefundRequest r) {
        for (ObserverAdmin observerAdmin:this.observerAdmins) {
            observerAdmin.notifyAdmin(r);
        }
    }

    @Override
    public void addRefundRequest() {

    }
}
