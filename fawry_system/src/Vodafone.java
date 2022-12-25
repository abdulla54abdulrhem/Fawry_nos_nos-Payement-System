public class Vodafone extends Provider{
    private Vodafone(){
        this.description="Vodafone";
        this.cost=2.0;//the additional cost for the provider
        this.theService=NullService.getInstance();
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new Vodafone();
        }
        return instance;
    }
}
