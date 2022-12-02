import java.util.ArrayList;

public class Database {
    static private Database instance=null;
    ArrayList<User> users=new ArrayList<User>();
    ArrayList<service> services=new ArrayList<service>();

    private Database(){}
    public static Database getInstance() {
        if(instance==null){
            instance=new Database();
        }
        return instance;
    }
}
