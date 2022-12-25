public class HospitalDonation extends service {
    //hospital
    private HospitalDonation(){
        cost=100;
        description="Hospital Donation.";
    }
    static private service instance=null;
    public static service getInstance(){
        if(instance==null){
            instance=new HospitalDonation();
        }
        return instance;
    }

}