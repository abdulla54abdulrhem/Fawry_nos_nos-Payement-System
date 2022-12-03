import java.util.ArrayList;

public class Database {
    static private Database instance=null;
    ArrayList<UserAbstract> users=new ArrayList<UserAbstract>();
    ArrayList<service> services=new ArrayList<service>();
    //wow
    //the bank gave me the cards database
    //cool!!!
    ArrayList<creditCard> cards=new ArrayList<creditCard>();

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
    }
    public void deleteService(service service){
        services.remove(service);
    }

}
