public class LandLineFactory extends ServiceFactory{
    public LandLineFactory(){
        display=new ChooseLandlineDisplay();
    }
    public service chooseService(int option){
//        option=display.displayOption();
        if(option==1){
            return LandlineMonthly.getInstance();
        }
        else if(option==2){
            return LandlineQuarter.getInstance();
        }
        return null;
    }
}
