public class Transaction {
    String service_description=null;
    String userEmail=null;
    double cost;
    public Transaction(String userEmail,String service_description,double cost){
        this.service_description=service_description;
        this.userEmail=userEmail;
        this.cost=cost;
    }
    public void getInformaion(){
        System.out.println("Transaction description: "+service_description);
        System.out.println("Made by:" +userEmail);
        System.out.println("Cost: "+cost);
    }
}
