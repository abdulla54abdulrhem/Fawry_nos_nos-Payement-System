
public class VodaMobileRecharge extends service {

	public VodaMobileRecharge(){
		description="hi VodaMobileRecharge";
		cost=9971;
	}
	@Override
	public boolean pay(User user) {
		// TODO Auto-generated method stub
		if(user.wallet.getBalance()<cost){
			return false;
		}else {
			user.wallet.deductMoney(cost);
			return true;
		}

	}

}
