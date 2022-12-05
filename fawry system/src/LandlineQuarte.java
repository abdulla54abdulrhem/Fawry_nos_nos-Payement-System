
public class LandlineQuarte extends service {
	private LandlineQuarte(){
		description="Landline Quarter Receipt.";
		cost=400;
	}
	static private service instance=null;
	public static service getInstance(){
		if(instance==null){
			instance=new LandlineQuarte();
		}
		return instance;
	}

}
