
public class OrangeMobileRecharge extends service {
	private OrangeMobileRecharge(){
		description="OrangeMobileRecharge service.";
		cost=10;
	}
	static private service instance=null;
	public static service getInstance(){
		if(instance==null){
			instance=new OrangeMobileRecharge();
		}
		return instance;
	}

}
