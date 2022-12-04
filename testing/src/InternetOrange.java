public class InternetOrange extends service {
    private InternetOrange(){
        description="Orange internet receipt";
        cost=160;
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new InternetOrange();
        }
        return instance;
    }
}
