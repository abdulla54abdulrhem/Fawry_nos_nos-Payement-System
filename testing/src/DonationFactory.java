public class DonationFactory extends ServiceFactory{
    public DonationFactory(){
        display= new ChooseDonationDisplay();
    }
    public service chooseService(){
        option=display.displayOption();
        if(option==1){
            return Donation.getInstance();
        }
        else if(option==2){
            return  SchoolDonation.getInstance();
        }
        else {
            return  NGOsDonation.getInstance();
        }

    }
}
