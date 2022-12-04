public class InternetVodafone extends service {
    private InternetVodafone(){
        description="Vodafone Internet Receipt";
        cost=160;
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new InternetVodafone();
        }
        return instance;
    }
}
