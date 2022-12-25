public class We extends Provider{
    private We(){
        this.description="We";
        this.cost=5.0;//the additional cost for the provider
        this.theService=NullService.getInstance();
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new We();
        }
        return instance;
    }
}
