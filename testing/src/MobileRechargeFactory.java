public class MobileRechargeFactory extends ServiceFactory{
    public MobileRechargeFactory(){
        display=new ChooseMoblieRechargeDisplay();
    }
    public service chooseService(){
        option=display.displayOption();
        if(option==1){
            return VodaMobileRecharge.getInstance();
        }
        else if(option==2){
            return  WeMobileRecharge.getInstance();
        }
        else if(option==3){
            return  OrangeMobileRecharge.getInstance();
        }
        else{
            return  EtisalatMobileRecharge.getInstance();
        }
    }
}
