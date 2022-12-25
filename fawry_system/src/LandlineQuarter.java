public class LandlineQuarter extends service {
    private LandlineQuarter(){
        description="Landline quarter payment.";
        cost=100;
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new LandlineQuarter();
        }
        return instance;
    }
}