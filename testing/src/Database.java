import java.util.ArrayList;

public class Database {
    static private Database instance=null;
    ArrayList<User> users=new ArrayList<User>();
    ArrayList<service> services=new ArrayList<service>();
    String generalDiscountData="added General Discount 0%";
    ArrayList<String> discountsDescriptions=new ArrayList<String>();
    //wow
    //the bank gave me the cards database
    //cool!!!
    ArrayList<creditCard> cards=new ArrayList<creditCard>();
    public DiscountSubject generalDiscount=new GeneralDiscount();
    public DiscountSubject specificDiscount=new SpecificDiscount();
    private Database(){}
    public static Database getInstance() {
        if(instance==null){
            instance=new Database();
        }
        return instance;
    }
    public void addUser(User user){
        users.add(user);
    }
    public void addService(service service){
        services.add(service);
        //to add make the service and observer in the general discount
        generalDiscount.registerObserver(service);
    }
    public void deleteService(service service){
        services.remove(service);
    }
    public void showServices(){
        for(int i=0;i<services.size();i++){
            System.out.println(i+"- "+services.get(i).getDescription()+" Costs: "+services.get(i).getCost()+" EGP, Cost after discounts: "+services.get(i).getCostAfterDiscounts()+" EGP");
        }

    }
    public void addGeneralDiscountDiscription(double discount){
        generalDiscountData=("added General Discount "+discount*100+"%");
    }
    public void addSpecificDiscountDescription(String description,double discount){
        discountsDescriptions.add("Added discount to: "+description+" "+discount*100+"%");
    }
    public void showDiscounts(){
        System.out.println(generalDiscountData);
        for(String dis:discountsDescriptions){
            System.out.println(dis);
        }
    }
}
