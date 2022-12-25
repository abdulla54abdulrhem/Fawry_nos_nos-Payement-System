public class Etisalat extends Provider{
    private Etisalat(){
        this.description="Etisalat";
        this.cost=1.0;//the additional cost for the provider
        this.theService=NullService.getInstance();
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new Etisalat();
        }
        return instance;
    }
}
