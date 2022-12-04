public class LandLineFactory extends ServiceFactory{
    public LandLineFactory(){
        display=new ChooseLandlineDisplay();
    }
    public service chooseService(){
        option=display.displayOption();
        if(option==1){
            return landlineMonthly.getInstance();
        }
        else{
            return LandlineQuarte.getInstance();
        }
    }
}
