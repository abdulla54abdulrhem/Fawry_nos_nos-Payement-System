public class ChooseInternetRecharge extends Display{
    public ChooseInternetRecharge(){}
    public int displayOption(){
        System.out.println("Mobile recharge services: ");
        System.out.println("1- Vodafone");
        System.out.println("2- We");
        System.out.println("3- Orange");
        System.out.println("4- Etisalat");
        this.option=sc.nextInt();
        while(option>4||option<1){
            System.out.println("Error, invalid value, try again: ");
            this.option=sc.nextInt();
        }
        return this.option;
    }
}
