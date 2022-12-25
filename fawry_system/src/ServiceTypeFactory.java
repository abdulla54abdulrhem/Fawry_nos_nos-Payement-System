public class ServiceTypeFactory {
    Display display;
    public ServiceTypeFactory(){
        display= new ChooseMainServicesDisplay();
    }
    public ServiceFactory chooseMainService(){
        int option=display.displayOption();
        if(option==1){
            return new MobileRechargeFactory();
        }
        else if(option==2){
            return new InternetRechargeFactory();
        }
        else if(option==3){
            return new LandLineFactory();
        }
        else{
            return new DonationFactory();
        }
    }
}
