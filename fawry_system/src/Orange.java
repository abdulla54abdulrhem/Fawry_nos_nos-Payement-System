public class Orange extends Provider{
    private Orange(){
        this.description="Orange";
        this.cost=2.0;//the additional cost for the provider
        this.theService=NullService.getInstance();
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new Orange();
        }
        return instance;
    }
}
