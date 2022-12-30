import javax.xml.crypto.Data;
import java.security.Provider;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

public class main {
    public static void main(String []args){
        //initialize our database with services
        ServiceFactory servicefactory;
        service ser;
        ServiceTypeFactory serviceTypeFactory=new ServiceTypeFactory();
        int i=0;
        while (true){
            i++;
            servicefactory=serviceTypeFactory.chooseMainService(i);
            if(servicefactory==null){
                break;
            }
            int j=0;
            while (true){
                j++;
                ser=servicefactory.chooseService(j);
                if(ser==null){break;}
                Database.getInstance().addService(ser);
            }
        }
        ArrayList<service> hi=Database.getInstance().services;
//        Database.getInstance().addService(Vodafone.getInstance());
//        Database.getInstance().addService(Etisalat.getInstance());
//        Database.getInstance().addService(We.getInstance());
//        Database.getInstance().addService(Orange.getInstance());
//        Database.getInstance().addService(MobileRecharge.getInstance());
//        Database.getInstance().addService(InternetRecharge.getInstance());
//        Database.getInstance().addService(LandlineMonthly.getInstance());
//        Database.getInstance().addService(LandlineQuarter.getInstance());
//        Database.getInstance().addService(SchoolDonation.getInstance());
//        Database.getInstance().addService(HospitalDonation.getInstance());
//        Database.getInstance().addService(NGOsDonation.getInstance());

        //creating the only admin in database
//        Display display=new startDisplay();
        Database.getInstance().myAdmin=new admin();
        CustomerController customerController=new CustomerController();

        for (String dis:customerController.search(".")) {
            System.out.println(dis);
        }
        //actual start of our program
//        while(true){
//            int option= display.displayOption();
//            if(option==1){
//                Database.getInstance().myAdmin.startAdminFunctions();
//            }
//            else if(option==2){
//                new User();
//            }
//            else{
//                break;
//            }
//        }
    }
}
