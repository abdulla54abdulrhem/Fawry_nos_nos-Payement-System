
public abstract class service {
	double cost = 0;
	String description="";
	double discountGeneral=0;
	double discountSpecific=0;
	Display serviceDisplay = null;
    User currentUser=null;

	abstract boolean pay(User user);

}
