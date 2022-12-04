import java.util.ArrayList;
import java.util.Scanner;

public class admin extends UserAbstract{
    admin(){
        email="admin@gmail.com";
        password="1234";
        username="admin";
        login();
        startAdminFunctions();
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
                for (User u:Database.getInstance().users) {
                    ArrayList<RefundRequest> tobeDeleted=new ArrayList<RefundRequest>();
                    for (RefundRequest refund:u.refundRequests) {
                        System.out.println(refund.refundDescription);
                        System.out.println("requested: "+refund.whereIsMyMoney);
                        int refundOption=new chooseToRefundDisplay().displayOption();
                        if(refundOption==1){
                            u.wallet.addMoney(refund.whereIsMyMoney);
                            tobeDeleted.add(refund);
//                            u.refundRequests.remove(refund);
                            System.out.println("successfull\nmoney after: "+ u.wallet.getBalance());
                        }else if(refundOption==2){
                            tobeDeleted.add(refund);
//                            u.refundRequests.remove(refund);
                        }else if(refundOption==3){
                            returnTomenu=true;
                            break;
                        }
                    }
                    for (RefundRequest deleteThis: tobeDeleted) {
                        u.refundRequests.remove(deleteThis);
                    }
                    if(returnTomenu){
                        break;
                    }
                }
            }else if(option==3){
                break;
            }
        }

    }

}
