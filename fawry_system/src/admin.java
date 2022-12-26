import java.util.ArrayList;
import java.util.Scanner;

public class admin extends UserAbstract implements ObserverAdmin {
    ArrayList<RefundRequest> refundRequests=new ArrayList<RefundRequest>();
    admin(){
        //initializing admin
        email="admin@gmail.com";
        password="1234";
        username="admin";
    }
    void login(){
        while (true){
            System.out.println("enter email:  just type--> "+email);
            String e=new Scanner(System.in).next();
            System.out.println("enter password: "+password);
            String pass=new Scanner(System.in).next();
            if(e.equals(email)&&pass.equals(password)){
                System.out.println("welcome "+ username);
                break;
            }else {
                System.out.println("error: wrong email or password ");
            }
        }
    }

    void startAdminFunctions(){
        login();
        while (true){
            int option=new AdminMainMenu().displayOption();
            if(option==1){
                Display display=new DiscountOptionsDisplay();
                int option1=display.displayOption();
                if(option1==1){
                    Database.getInstance().generalDiscount.addDiscount();
                }
                else{
                    Display specificService=new ChooseSpecifictoDiscountDisplay();
                    int serviceoption= specificService.displayOption();
                    Database.getInstance().specificDiscount.registerObserver(Database.getInstance().services.get(serviceoption));
                    Database.getInstance().specificDiscount.addDiscount();
                }
            }else if(option==2) {
                boolean returnTomenu=false;
                //important: not sure if this a copy or refrence
                    ArrayList<RefundRequest>tobeDeleted=new ArrayList<RefundRequest>();
                    for (RefundRequest refund:this.refundRequests) {
                        System.out.println("user: "+refund.user.username);
                        System.out.println("email: "+refund.user.email);
                        System.out.println(refund.refundDescription);
                        System.out.println("requested: "+refund.whereIsMyMoney);
                        int refundOption=new chooseToRefundDisplay().displayOption();
                        if(refundOption==1){
                            //give him his money
                            refund.user.wallet.addMoney(refund.whereIsMyMoney);
                            tobeDeleted.add(refund);
//                            u.refundRequests.remove(refund);
                            System.out.println("successfull\nmoney after: "+ refund.user.wallet.getBalance());
                        }else if(refundOption==2){
                            tobeDeleted.add(refund);
                        }else if(refundOption==3){
                            returnTomenu=true;
                            break;
                        }
                    }
                    for (RefundRequest deleteThis: tobeDeleted) {
                        this.refundRequests.remove(deleteThis);
                    }
                    tobeDeleted.clear();
                    if(returnTomenu){
                        break;
                    }

            }else if(option==3){
                break;
            }
        }

    }

    @Override
    public void notifyAdmin(RefundRequest r) {
        this.refundRequests.add(r);
    }
}
