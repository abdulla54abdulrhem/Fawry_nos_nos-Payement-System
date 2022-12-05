
public class WeMobileRecharge extends service {
	private WeMobileRecharge(){
		description="WeMobileRecharge service.";
		cost=12;
	}
	static private service instance=null;
	public static service getInstance(){
		if(instance==null){
			instance=new WeMobileRecharge();
		}
		return instance;
	}

}
