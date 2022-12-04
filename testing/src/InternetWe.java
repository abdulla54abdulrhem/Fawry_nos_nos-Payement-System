
public class InternetWe extends service {
	private InternetWe(){
		description="We Internet Receipt";
		cost=150;
	}
	static private service instance=null;
	public static service getInstance(){
		if(instance==null){
			instance=new InternetWe();
		}
		return instance;
	}
}
