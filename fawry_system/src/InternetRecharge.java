public class InternetRecharge extends service {
    private InternetRecharge(){
        description="Internet Recharge.";
        cost=100;
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new InternetRecharge();
        }
        return instance;
    }
}