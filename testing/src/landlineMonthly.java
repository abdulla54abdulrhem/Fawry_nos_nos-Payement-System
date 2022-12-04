
public class landlineMonthly extends service {
	private landlineMonthly(){
		description="Landline Monthly Receipt";
		cost=100;
	}
	static private service instance=null;
	public static service getInstance(){
		if(instance==null){
			instance=new landlineMonthly();
		}
		return instance;
	}
}
