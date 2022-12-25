public class InternetRechargeFactory extends ServiceFactory{
    public InternetRechargeFactory(){
        display=new ChooseInternetRecharge();
    }
    public service chooseService(){
        option=display.displayOption();
        if(option==1){
            Provider voda= (Provider) Vodafone.getInstance();
            voda.addService(InternetRecharge.getInstance());
            return voda;
        }
        else if(option==2){
            Provider we= (Provider) We.getInstance();
            we.addService(InternetRecharge.getInstance());
            return we;
        }
        else if(option==3){
            Provider orange= (Provider) Orange.getInstance();
            orange.addService(InternetRecharge.getInstance());
            return orange;
        }
        else{
            Provider eti= (Provider) Etisalat.getInstance();
            eti.addService(InternetRecharge.getInstance());
            return eti;
        }
    }
}
