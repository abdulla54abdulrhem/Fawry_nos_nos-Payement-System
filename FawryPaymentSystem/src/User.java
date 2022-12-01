import java.sql.Ref;
import java.util.Vector;

public class User extends UserAbstract{
	Vector<Transaction>transactions= new Vector<Transaction>();
    Vector<RefundRequest>refundRequests= new Vector<RefundRequest>();
    Wallet wallet=new Wallet();
    Display usermainMenu=new UserMainMenu();
}
