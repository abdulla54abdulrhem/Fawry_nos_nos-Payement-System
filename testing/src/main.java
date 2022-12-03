public class main {
    public static void main(String []args){
//        User user=new User();
//        user.tempFactoryforDisplays();
        //initialize our database
        //Todo: create all services and add to database


        Database.getInstance().cards.add(new creditCard());
        Database.getInstance().cards.add(new creditCard(2,2));

        Display display=new startDisplay();
        UserAbstract userAbstract;
        while (true){
            int option=display.displayOption();
            if(option==1){
                userAbstract=new admin();
            }else if(option==2){
                userAbstract=new User();
            }else {
                break;
            }
        }

    }
}
