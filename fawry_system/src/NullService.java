public class NullService extends service{
    private NullService(){
        description="";
        cost=0;
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new NullService();
        }
        return instance;
    }
}
