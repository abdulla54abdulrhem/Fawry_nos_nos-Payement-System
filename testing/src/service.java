
public abstract class service {
	double cost = 0;
	boolean cashOnDelivery=false;
	String description="";
	double discountGeneral=0;
	double discountSpecific=0;
	Display serviceDisplay = null;
    User currentUser=null;

	abstract boolean pay(User user);

}
