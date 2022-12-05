public class InternetRechargeFactory extends ServiceFactory{
    public InternetRechargeFactory(){
        display=new ChooseInternetRecharge();
    }
    public service chooseService(){
        option=display.displayOption();
        if(option==1){
            return InternetVodafone.getInstance();
        }
        else if(option==2){
            return  InternetWe.getInstance();
        }
        else if(option==3){
            return InternetOrange.getInstance();
        }
        else{
            return InternetEtisalat.getInstance();
        }
    }
}
