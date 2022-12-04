
public class EtisalatMobileRecharge extends service {
	private EtisalatMobileRecharge(){
		description="Etisalat Mobile recharge service";
		cost=12;
	}
	static private service instance=null;
	public static service getInstance(){
		if(instance==null){
			instance=new EtisalatMobileRecharge();
		}
		return instance;
	}
}
