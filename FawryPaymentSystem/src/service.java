
public interface service {
	public  double cost = 0;
	public String description="";
	public double discountGeneral=0;
	public double discountSpecific=0;
	public Display serviceDisplay = null;
    public User currentUser=null;
	
	
	boolean pay(User user);
	
}
