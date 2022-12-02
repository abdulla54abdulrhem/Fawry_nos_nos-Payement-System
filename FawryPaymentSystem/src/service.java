
public interface service {
	double cost=null;
	String description="";
	double discountGeneral=0;
	double discountSpecific=0;
	Display serviceDisplay = null;
    User currentUser=null;

	boolean pay(User user);
	
}
