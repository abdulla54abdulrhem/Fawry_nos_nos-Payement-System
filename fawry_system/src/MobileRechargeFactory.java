public class MobileRechargeFactory extends ServiceFactory{
    public MobileRechargeFactory(){
        display=new ChooseMoblieRechargeDisplay();
    }
    public service chooseService(){
        option=display.displayOption();
        if(option==1){
            Provider voda= (Provider) Vodafone.getInstance();
            voda.addService(MobileRecharge.getInstance());
            return voda;
        }
        else if(option==2){
            Provider we= (Provider) We.getInstance();
            we.addService(MobileRecharge.getInstance());
            return we;
        }
        else if(option==3){
            Provider orange= (Provider) Orange.getInstance();
            orange.addService(MobileRecharge.getInstance());
            return orange;
        }
        else{
            Provider eti= (Provider) Etisalat.getInstance();
            eti.addService(MobileRecharge.getInstance());
            return eti;
        }
    }
}
