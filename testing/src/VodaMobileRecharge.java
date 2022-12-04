
public class VodaMobileRecharge extends service {

	private VodaMobileRecharge(){
		description="VodaMobileRecharge service";
		cost=10;
	}
	static private service instance=null;
	public static service getInstance(){
		if(instance==null){
			instance=new VodaMobileRecharge();
		}
		return instance;
	}

}
