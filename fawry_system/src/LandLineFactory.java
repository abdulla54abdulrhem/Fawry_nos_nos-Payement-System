public class LandLineFactory extends ServiceFactory{
    public LandLineFactory(){
        display=new ChooseLandlineDisplay();
    }
    public service chooseService(){
        option=display.displayOption();
        if(option==1){
            return LandlineMonthly.getInstance();
        }
        else{
            return LandlineQuarter.getInstance();
        }
    }
}
