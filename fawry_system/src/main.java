import javax.xml.crypto.Data;
import java.security.Provider;
import java.util.concurrent.ThreadPoolExecutor;

public class main {
    public static void main(String []args){
        //initialize our database
        Database.getInstance().addService(Vodafone.getInstance());
        Database.getInstance().addService(Etisalat.getInstance());
        Database.getInstance().addService(We.getInstance());
        Database.getInstance().addService(Orange.getInstance());
        Database.getInstance().addService(MobileRecharge.getInstance());
        Database.getInstance().addService(InternetRecharge.getInstance());
        Database.getInstance().addService(LandlineMonthly.getInstance());
        Database.getInstance().addService(LandlineQuarter.getInstance());
        Database.getInstance().addService(SchoolDonation.getInstance());
        Database.getInstance().addService(HospitalDonation.getInstance());
        Database.getInstance().addService(NGOsDonation.getInstance());
        //actual start of our program
        Display display=new startDisplay();
        UserAbstract userAbstract;
        while(true){
            int option= display.displayOption();
            if(option==1){
                userAbstract=new admin();
            }
            else if(option==2){
                userAbstract=new User();
            }
            else{
                break;
            }
        }
    }
}
