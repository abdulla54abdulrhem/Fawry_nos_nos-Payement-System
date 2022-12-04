
public class Donation extends service {
	//hospital
	private Donation(){
		cost=100;
		description="Hospital Donation";
	}
	static private service instance=null;
	public static service getInstance(){
		if(instance==null){
			instance=new Donation();
		}
		return instance;
	}

}
