import java.util.ArrayList;

public class Database {
    static private Database instance=null;
    ArrayList<UserAbstract> users=new ArrayList<UserAbstract>();
    ArrayList<service> services=new ArrayList<service>();
    ArrayList<String> discountsDescriptions=new ArrayList<String>();
    //wow
    //the bank gave me the cards database
    //cool!!!
    ArrayList<creditCard> cards=new ArrayList<creditCard>();
    DiscountSubject generalDiscount=new GeneralDiscount();
    DiscountSubject specificDiscount=new SpecificDiscount();
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
        for(service ser:services){
            System.out.println(ser.getDescription()+" Costs: "+ser.getCost()+" EGP");
        }
    }
    public void addGeneralDiscountDiscription(double discount){
        discountsDescriptions.add("added General Discount "+discount*100+"%");
    }
    public void addSpecificDiscountDescription(String description,double discount){
        discountsDescriptions.add("Added discount to: "+description+" "+discount*100+"%");
    }
    public void showDiscounts(){
        for(String dis:discountsDescriptions){
            System.out.println(dis);
        }
    }
}
