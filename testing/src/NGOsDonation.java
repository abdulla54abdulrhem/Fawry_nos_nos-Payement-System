
public class NGOsDonation extends service {
	private NGOsDonation(){
		description="NGOs Donation service: ";
		cost=500;
	}
	static private service instance=null;
	public static service getInstance(){
		if(instance==null){
			instance=new NGOsDonation();
		}
		return instance;
	}
}
