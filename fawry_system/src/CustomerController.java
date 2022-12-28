import java.util.ArrayList;

public class CustomerController {

    public ArrayList<String> search(String word) {
        ArrayList<String> foundServices=new ArrayList<String>();
        for(int i=0;i<Database.getInstance().services.size();i++){
            if(Database.getInstance().services.get(i).getDescription().contains(word)){
                foundServices.add(i+"- "+Database.getInstance().services.get(i).getDescription()+
                        " Costs: "+Database.getInstance().services.get(i).getCost()+
                        " EGP, Cost after discounts: "+Database.getInstance().services.get(i).getCostAfterDiscounts()+" EGP");
            }
        }
        return foundServices;
    }
    public ArrayList<String> getDiscounts(){
        return Database.getInstance().discountsDescriptions;
    }
    public boolean pay(User user,int mainServicesNumber,int serviceTypeNumber ){
        ServiceFactory servicefactory;
        service ser;
        ServiceTypeFactory serviceTypeFactory=new ServiceTypeFactory();// ChooseMainServicesDisplay();

        //getting objects from factories
        servicefactory=serviceTypeFactory.chooseMainService(mainServicesNumber);
        if(servicefactory==null){
            return false;
        }
        ser=servicefactory.chooseService(serviceTypeNumber);
        if(ser==null){
            return false;
        }


        //working with service
        double moneyBefore=user.wallet.getBalance();
        if(ser.pay(user)){
            double moneyAfter=user.wallet.getBalance();
            //important: make function getCost (because of discounts)
            user.transactions.add(new Transaction(user.email,ser.getDescription(),moneyBefore-moneyAfter));
            return true;
        }
        return false;
    }

}
