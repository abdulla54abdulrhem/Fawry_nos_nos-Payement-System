public class DonationFactory extends ServiceFactory{
    public DonationFactory(){
        display= new ChooseDonationDisplay();
    }
    public service chooseService(){
        option=display.displayOption();
        if(option==1){
            return new Donation();
        }
        else if(option==2){
            return new SchoolDonation();
        }
        else {
            return new NGOsDonation();
        }

    }
}
