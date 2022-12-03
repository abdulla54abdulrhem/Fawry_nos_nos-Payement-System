
public abstract class service implements Observer{
	double cost = 0;
	boolean cashOnDelivery=false;
	String description="";
	double discountGeneral=0;
	double discountSpecific=0;
	Display serviceDisplay = null;
    User currentUser=null;

	abstract boolean pay(User user);
	public void updateDiscount(double discount){
		this.discountGeneral=discount;
	}
	public void updateSpecificDiscount(double discount){
		this.discountSpecific=discount;
	}
	public double getCost(){
		return this.cost;
	}
	public String getDescription(){
		return this.description;
	}
}
