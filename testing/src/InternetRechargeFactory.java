public class InternetRechargeFactory extends ServiceFactory{
    public InternetRechargeFactory(){
        display=new ChooseInternetRecharge();
    }
    public service chooseService(){
        option=display.displayOption();
        if(option==1){
            return new InternetVodafone();
        }
        else if(option==2){
            return new InternetWe();
        }
        else if(option==3){
            return new InternetOrange();
        }
        else{
            return new InternetEtisalat();
        }
    }
}
