public class SpecificDiscount implements DiscountSubject{
    Observer observer;
    double discount=0;
    Display display=new SpecificDiscountDisplay();
    public SpecificDiscount(){

    }
    public void registerObserver(Observer o){
        observer=o;
    }
    public void removeObserver(Observer o){
        observer=null;
    }
    public void notifyObserver(){
        observer.updateSpecificDiscount(discount);
        Database.getInstance().addSpecificDiscountDescription(observer.getDescription(),discount);
    }
    public void addDiscount(){
        int dis=display.displayOption();
        discount=(dis/100.0);
        //System.out.println(discount);
        notifyObserver();
    }

}
