public class MobileRechargeFactory extends ServiceFactory{
    public MobileRechargeFactory(){
        display=new ChooseMoblieRechargeDisplay();
    }
    public service chooseService(){
        option=display.displayOption();
        if(option==1){
            return new VodaMobileRecharge();
        }
        else if(option==2){
            return new WeMobileRecharge();
        }
        else if(option==3){
            return new OrangeMobileRecharge();
        }
        else{
            return new EtisalatMobileRecharge();
        }
    }
}
