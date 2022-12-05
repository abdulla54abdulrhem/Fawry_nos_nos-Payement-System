
public class InternetEtisalat extends service {
	private InternetEtisalat(){
		description="Etisalat internet receipt.";
		cost=160;
	}
	static private service instance=null;
	public static service getInstance(){
		if(instance==null){
			instance=new InternetEtisalat();
		}
		return instance;
	}
}
