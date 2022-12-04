import java.security.Provider;
import java.util.concurrent.ThreadPoolExecutor;

public class main {
    public static void main(String []args){
//        User user=new User();
//        user.tempFactoryforDisplays();
        //initialize our database
        //Todo: create all services and add to database

        Database.getInstance().addService(VodaMobileRecharge.getInstance());
        Database.getInstance().addService(EtisalatMobileRecharge.getInstance());
        Database.getInstance().addService(OrangeMobileRecharge.getInstance());
        Database.getInstance().addService(WeMobileRecharge.getInstance());
        Database.getInstance().addService(InternetVodafone.getInstance());
        Database.getInstance().addService(InternetEtisalat.getInstance());
        Database.getInstance().addService(InternetOrange.getInstance());
        Database.getInstance().addService(InternetWe.getInstance());
        Database.getInstance().addService(LandlineQuarte.getInstance());
        Database.getInstance().addService(landlineMonthly.getInstance());
        Database.getInstance().addService(SchoolDonation.getInstance());
        Database.getInstance().addService(NGOsDonation.getInstance());
        Database.getInstance().addService(Donation.getInstance());
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
